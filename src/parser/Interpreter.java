package parser;

import java.io.FileNotFoundException;
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
import Visitor.ASTVisitor;
import Visitor.Printer;
import Visitor.TreeVisitor;
import parser.Parser.Token;

public class Interpreter {

	static ProgramNode			pN				= new ProgramNode();	// change
																		// from
																		// static
	Token						token			= null;
	int							actIndex		= -1;
	int							sceneIndex		= -1;
	Parser						parser			= null;
	HashMap<String, Integer>	charsOnStage	= new HashMap<>();
	HashMap<String, Integer>	characters		= new HashMap<>();
	String						speaking		= null;
	String						notSpeaking		= null;

	Interpreter() {}

	int i = 0;

	// TODO
	void parse() {
		String polishForm = "";
		try {
			parser = new Parser("wordlists", "test8.spl");
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

			// System.out.println(token);

			if (token.type == TYPE.keyword) {
				String value = token.value;
				switch (value) {
					case "Act":
						ActNode act = new ActNode(parser.getNext().value);
						pN.addChild(act);
						actIndex++;
						sceneIndex = 0;
						break;
					case "Scene":
						SceneNode scene = new SceneNode(parser.getNext().value);
						pN.children.get(actIndex).addChild(scene);
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
								// TO DO Exeunt one char
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
				SceneNode currentScene = (SceneNode) pN.children
						.get(actIndex).children.get(sceneIndex - 1);

				AssignmentNode asgnNode = new AssignmentNode();
				currentScene.addChild(asgnNode);
				asgnNode.addChild(new LvalNode(notSpeaking));

				token = parser.getNext();

				polishForm = "";

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
							int constant = addConstant();
							polishForm += constant + " ";
						}
					}
					token = parser.getNext();
				} // finish terminator
					// System.out.println(polishForm);
				asgnNode.children.add(evaluatePolishForm(polishForm));
			} // finish second_person

			if (token.type == TYPE.speak) {
				SceneNode currentScene = (SceneNode) pN.children
						.get(actIndex).children.get(sceneIndex - 1);
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

	public ASTNode evaluatePolishForm(String polishForm) {
		Stack<OperatorNode> stack = new Stack<>();
		String[] pTokens = polishForm.split("\\s+");
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
				while (currentNode.maxChildren == currentNode.children.size()
						&& stack.size() > 1) { // size > 1 pt ca primulelement
												// va fi null
					OperatorNode temp = stack.pop();
					temp.addChild(currentNode);
					currentNode = temp;
				}

			}

		}

		return currentNode;
	}

	public static void print(ASTNode root, int tabs) {
		System.out.println(root.getType());
		for (int i = 0; i < root.children.size(); i++) {
			for (int j = 0; j < tabs; j++) {
				System.out.print("\t");
			}
			print(root.children.get(i), tabs + 1);
		}
	}

	public int addConstant() {
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

	public static void main(String[] args) {
		Interpreter inter = new Interpreter();
		ASTVisitor visitor = new ASTVisitor(null);
		inter.parse();
		// visitor.visit(pN);
		TreeVisitor treeVisitor = new TreeVisitor(new Printer());
		treeVisitor.visit(pN);
		// ASTNode x = inter.evaluatePolishForm("/ / * - + 1 2 + + 8 2 + 8 + 1 2
		// - + - 8 1 - 8 2 - Balthazar 4194304 / + 8 1 - 4 1 ^3 -1 ");
		// System.out.println(x.children.get(0).children.get(0).children.get(1));

	}

}
