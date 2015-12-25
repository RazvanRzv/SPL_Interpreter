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

public class ASTPrinter implements Visitor {

	private PrintWriter output;

	/**
	 * Constructor
	 * 
	 * @param output
	 *            writer-ul
	 */
	public ASTPrinter(PrintWriter output) {
		this.output = output;
	}

	@Override
	public int visit(ASTNode node) {
		return 0;
	}

	@Override
	public int visit(ProgramNode node) {
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(ActNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType() + " " + node.getName());
		return 0;
	}

	@Override
	public int visit(SceneNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType() + " " + node.getName());
		return 0;
	}

	@Override
	public int visit(AssignmentNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(LvalNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(ConstantNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(RvalNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(IntOutputNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(CharOutputNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(SumNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(DifferenceNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(ProductNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(QuotientNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(SquareNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}

	@Override
	public int visit(CubeNode node) {
		for (int i = 0; i < node.getDepth(); i++) {
			output.print("\t");
		}
		output.println(node.getType());
		return 0;
	}
}
