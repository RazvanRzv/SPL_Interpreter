package Visitor;

import java.io.PrintWriter;

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

public class TreeVisitor implements Visitor {

	private ASTPrinter baseVisitor;

	/**
	 * Constructor
	 * 
	 * @param output
	 *            writer-ul
	 */
	public TreeVisitor(PrintWriter output) {
		baseVisitor = new ASTPrinter(output);
	}

	@Override
	public int visit(ASTNode node) {
		return 0;
	}

	@Override
	public int visit(ProgramNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(ActNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(SceneNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(AssignmentNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(LvalNode node) {
		node.accept(baseVisitor);
		return 0;
	}

	@Override
	public int visit(ConstantNode node) {
		node.accept(baseVisitor);
		return 0;
	}

	@Override
	public int visit(RvalNode node) {
		node.accept(baseVisitor);
		return 0;
	}

	@Override
	public int visit(SumNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(DifferenceNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(ProductNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(QuotientNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(SquareNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(CubeNode node) {
		node.accept(baseVisitor);
		for (int i = 0; i < node.getChildren().size(); i++) {
			node.getChildren().get(i).setDepth(node.getDepth() + 1);
			node.getChildren().get(i).accept(this);
		}
		return 0;
	}

	@Override
	public int visit(IntOutputNode node) {
		node.accept(baseVisitor);
		return 0;
	}

	@Override
	public int visit(CharOutputNode node) {
		node.accept(baseVisitor);
		return 0;
	}
}
