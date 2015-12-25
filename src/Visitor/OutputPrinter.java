package Visitor;

import java.io.PrintWriter;
import java.util.HashMap;

import ASTNodes.ASTNode;
import ASTNodes.ActNode;
import ASTNodes.AssignmentNode;
import ASTNodes.CharOutputNode;
import ASTNodes.ConstantNode;
import ASTNodes.CubeNode;
import ASTNodes.DifferenceNode;
import ASTNodes.IntOutputNode;
import ASTNodes.LvalNode;
import ASTNodes.ProductNode;
import ASTNodes.ProgramNode;
import ASTNodes.QuotientNode;
import ASTNodes.RvalNode;
import ASTNodes.SceneNode;
import ASTNodes.SquareNode;
import ASTNodes.SumNode;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class OutputPrinter implements Visitor {

	private HashMap<String, Integer>	characters;
	private PrintWriter					output	= null;

	/**
	 * 
	 * @param characters
	 *            personajele prezente
	 * @param output
	 *            writer-ul
	 */
	public OutputPrinter(HashMap<String, Integer> characters,
			PrintWriter output) {
		this.characters = characters;
		this.output = output;

	}

	@Override
	public int visit(ASTNode node) {
		return 0;
	}

	@Override
	public int visit(ProgramNode node) {
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(ActNode node) {
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(SceneNode node) {
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(AssignmentNode node) {
		String key = ((LvalNode) node.getChildren().get(0)).getChar();
		characters.put(key, node.getChildren().get(1).accept(this));
		return 0;
	}

	@Override
	public int visit(LvalNode node) {
		return 0;
	}

	@Override
	public int visit(ConstantNode node) {
		return node.getValue();
	}

	@Override
	public int visit(RvalNode node) {
		return characters.get(node.getCharName());
	}

	@Override
	public int visit(SumNode node) {
		return node.getChildren().get(0).accept(this)
				+ node.getChildren().get(1).accept(this);
	}

	@Override
	public int visit(DifferenceNode node) {
		return node.getChildren().get(0).accept(this)
				- node.getChildren().get(1).accept(this);
	}

	@Override
	public int visit(ProductNode node) {
		return node.getChildren().get(0).accept(this)
				* node.getChildren().get(1).accept(this);
	}

	@Override
	public int visit(QuotientNode node) {
		return node.getChildren().get(0).accept(this)
				/ node.getChildren().get(1).accept(this);
	}

	@Override
	public int visit(SquareNode node) {
		return (int) Math.pow(node.getChildren().get(0).accept(this), 2);
	}

	@Override
	public int visit(CubeNode node) {
		return (int) Math.pow(node.getChildren().get(0).accept(this), 3);
	}

	@Override
	public int visit(IntOutputNode node) {
		output.println(characters.get(node.getCharName()));
		return 0;
	}

	@Override
	public int visit(CharOutputNode node) {
		output.println(Character.toChars(characters.get(node.getCharName())));
		return 0;
	}

}
