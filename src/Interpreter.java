
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Stack;

import ASTNodes.ASTNode;
import ASTNodes.ActNode;
import ASTNodes.AssignmentNode;
import ASTNodes.CharOutputNode;
import ASTNodes.ConstantNode;
import ASTNodes.CubeNode;
import ASTNodes.DifferenceNode;
import ASTNodes.IntOutputNode;
import ASTNodes.LvalNode;
import ASTNodes.OperatorNode;
import ASTNodes.ProductNode;
import ASTNodes.ProgramNode;
import ASTNodes.QuotientNode;
import ASTNodes.RvalNode;
import ASTNodes.SceneNode;
import ASTNodes.SquareNode;
import ASTNodes.SumNode;
import Visitor.OutputPrinter;
import Visitor.TreeVisitor;

public class Interpreter {

	private Parser.Token				token			= null;
	private int							actIndex		= -1;
	private int							sceneIndex		= -1;
	private Parser						parser			= null;
	private HashMap<String, Integer>	charsOnStage	= new HashMap<>();
	private HashMap<String, Integer>	characters		= new HashMap<>();
	private String						speaking;
	private String						notSpeaking;

	/**
	 * Constructor
	 */
	Interpreter() {}

	/**
	 * Metoda ce construieste arborele sintactic
	 * 
	 * @param pN
	 *            radacina arborelui sintactic
	 * @param testNumber
	 *            numarul testului
	 */
	public void parse(ProgramNode pN, int testNumber) {

		try {
			parser = new Parser("wordlists",
					"tests/test" + testNumber + ".spl");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// sarim peste titlu si declararea personajelor
		while ((token = parser.getNext()).type != TYPE.keyword) {
			if (token.type == TYPE.character) {
				if (!characters.containsKey(token.value)) {
					characters.put(token.value, 0);
				}
			}
		}

		while (token != null) {
			if (token.type == TYPE.keyword) {
				String value = token.value;
				switch (value) {
					case "Act":
						ActNode act = new ActNode(parser.getNext().value);
						pN.addChild(act);
						actIndex++;
						sceneIndex = -1; // resetam numaratoarea scenelor in
											// cazul unui nou act
						break;
					case "Scene":
						if ((token = parser.getNext()).type == TYPE.terminator)
							break;
						SceneNode scene = new SceneNode(token.value);
						pN.getChildren().get(actIndex).addChild(scene);
						sceneIndex++;
						break;
					case "[":
						String action = parser.getNext().value;
						switch (action) {
							case "Enter":
								token = parser.getNext();
								while (!token.value.equals("]")) {
									if (token.type == TYPE.character) {
										int val = characters.get(token.value);
										charsOnStage.put(token.value, val);
									}
									token = parser.getNext();
								}
								break;
							case "Exit":
								String charOut = parser.getNext().value;
								int val = charsOnStage.get(charOut);
								characters.put(charOut, val);
								charsOnStage.remove(charOut);
								break;
							case "Exeunt":
								for (Entry<String, Integer> entry : charsOnStage
										.entrySet()) {
									characters.put(entry.getKey(),
											entry.getValue());
								}
								charsOnStage.clear();
								break;
						}
				}
			}

			if (token.value.contains(":") && token.value.length() > 1) {
				String character = token.value.substring(0,
						token.value.length() - 1);
				speaking = character;
				for (Entry<String, Integer> entry : charsOnStage.entrySet()) {
					if (!entry.getKey().equals(character)) {
						notSpeaking = entry.getKey();
					}
				}
			}

			if (token.type == TYPE.second_person) {

				if (speaking == null || notSpeaking == null) {
					token = parser.getNext();
					continue;
				}

				// adaugarea se face la scena curenta
				SceneNode currentScene = (SceneNode) pN.getChildren()
						.get(actIndex).getChildren().get(sceneIndex);

				AssignmentNode asgnNode = new AssignmentNode();
				currentScene.addChild(asgnNode);
				asgnNode.addChild(new LvalNode(notSpeaking));

				token = parser.getNext();

				String polishForm = "";

				// construim forma poloneza a replicii
				while (token.type != TYPE.terminator) {
					if (token.type == TYPE.math) {
						String operator = token.value;
						switch (operator) {
							case "sum":
								polishForm += "+ ";
								break;
							case "difference":
								polishForm += "- ";
								break;
							case "product":
								polishForm += "* ";
								break;
							case "quotient":
								polishForm += "/ ";
								break;
							case "square":
								polishForm += "^2 ";
								break;
							case "cube":
								polishForm += "^3 ";
								break;
						}
					}

					if (token.type == TYPE.second_person_reflexive) {
						polishForm += notSpeaking + " ";
					}

					if (token.type == TYPE.first_person_reflexive) {
						polishForm += speaking + " ";
					}

					if (token.type == TYPE.character) {
						polishForm += token.value + " ";
					}

					if (token.type == TYPE.negative_noun) {
						polishForm += "-1 ";
					}
					if (token.type == TYPE.neutral_noun
							|| token.type == TYPE.positive_noun) {

						polishForm += "1 ";
					}

					if (token.type == TYPE.positive_adjective
							|| token.type == TYPE.neutral_adjective
							|| token.type == TYPE.negative_adjective) {
						token = parser.getNext();
						if (token.type != TYPE.irelevant) {
							int constant = getConstant();
							polishForm += constant + " ";
						}
					}
					token = parser.getNext();
				} // finish terminator
					// adaugam radacina formei poloneze la dreapta egalului
				asgnNode.getChildren().add(evaluatePolishForm(polishForm));
			} // finish second_person

			if (token.type == TYPE.speak) {
				SceneNode currentScene = (SceneNode) pN.getChildren()
						.get(actIndex).getChildren().get(sceneIndex);
				if (token.value.equals("Speak")) {
					currentScene.addChild(new CharOutputNode(notSpeaking));
				}
				if (token.value.equals("Open")) {
					currentScene.addChild(new IntOutputNode(notSpeaking));
				}
			}

			token = parser.getNext();
		}

	}

	/**
	 * Creeaza arborele corespunzator formei poloneze
	 * 
	 * @param polishForm
	 *            forma poloneza
	 * @return radacina arborelui
	 */
	private ASTNode evaluatePolishForm(String polishForm) {
		Stack<OperatorNode> stack = new Stack<>();
		String[] pTokens = polishForm.split("\\s+"); // separam termenii formei
														// poloneze
		OperatorNode currentNode = null;
		try {
			int constant = Integer.parseInt(pTokens[0]);
			return new ConstantNode(constant);
		} catch (NumberFormatException e) {
			for (Entry<String, Integer> entry : characters.entrySet()) {
				if (pTokens[0].equals(entry.getKey())) {
					return new RvalNode(pTokens[0]);
				}
			}
			for (int i = 0; i < pTokens.length; i++) {
				switch (pTokens[i]) {
					case "+":
						stack.push(currentNode);
						currentNode = new SumNode();
						break;
					case "-":
						stack.push(currentNode);
						currentNode = new DifferenceNode();
						break;
					case "*":
						stack.push(currentNode);
						currentNode = new ProductNode();
						break;
					case "/":
						stack.push(currentNode);
						currentNode = new QuotientNode();
						break;
					case "^2":
						stack.push(currentNode);
						currentNode = new SquareNode();
						break;
					case "^3":
						stack.push(currentNode);
						currentNode = new CubeNode();
						break;
					default:
						try {
							int constant = Integer.parseInt(pTokens[i]);
							currentNode.addChild(new ConstantNode(constant));

						} catch (NumberFormatException ex) {
							currentNode.addChild(new RvalNode(pTokens[i]));
						}

						break;
				}
				// size > 1 deoarece primul element este null
				while (currentNode.getMaxChildren() == currentNode.getChildren()
						.size() && stack.size() > 1) {
					OperatorNode temp = stack.pop();
					temp.addChild(currentNode);
					currentNode = temp;
				}

			}

		}
		return currentNode;
	}

	/**
	 * Evalueaza o insiruire de adjective si un substantiv
	 * 
	 * @return valoarea insiruirii
	 */
	private int getConstant() {
		int noOfShifts = 1;
		int sign = 1;
		while (token.type == TYPE.positive_adjective
				|| token.type == TYPE.neutral_adjective
				|| token.type == TYPE.negative_adjective) {
			noOfShifts++;
			token = parser.getNext();
		}
		while (token.type == TYPE.irelevant) {
			token = parser.getNext();
		}

		if (token.type == TYPE.negative_noun) {
			sign = -1;
		} else
			sign = 1;

		return (1 << noOfShifts) * sign;

	}

	/**
	 * Functia de testare
	 */
	public static void doThings() {
		for (int i = 1; i <= 10; i++) {

			Interpreter interpreter = new Interpreter();
			ProgramNode pN = new ProgramNode();
			interpreter.parse(pN, i);

			PrintWriter astPrinter = null;
			try {
				astPrinter = new PrintWriter(
						new File("output/test" + i + ".ast"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			new TreeVisitor(astPrinter).visit(pN);
			astPrinter.close();

			PrintWriter outputPrinter = null;
			try {
				outputPrinter = new PrintWriter(
						new File("output/test" + i + ".out"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			new OutputPrinter(interpreter.characters, outputPrinter).visit(pN);
			outputPrinter.close();

		}

	}

	public static void main(String[] args) {
		doThings();
	}

}
