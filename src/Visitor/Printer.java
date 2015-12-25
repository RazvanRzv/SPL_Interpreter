package Visitor;

import ASTNodes.ASTNode;
import ASTNodes.ActNode;
import ASTNodes.AssignmentNode;
import ASTNodes.ConstantNode;
import ASTNodes.LvalNode;
import ASTNodes.OperatorNode;
import ASTNodes.OutputNode;
import ASTNodes.ProgramNode;
import ASTNodes.RvalNode;
import ASTNodes.SceneNode;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class Printer implements Visitor {

	private String tabs = "";

	private void addTab() {
		tabs += "\t";
	}

	private void removeTab() {
		tabs = tabs.substring(0, tabs.length() - 1);
	}

	@Override
	public void visit(ASTNode node) {

	}

	@Override
	public void visit(ProgramNode node) {
		System.out.println(node.getType());
	}

	@Override
	public void visit(ActNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType() + " " + node.getName());
	}

	@Override
	public void visit(SceneNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType() + " " + node.getName());
	}

	@Override
	public void visit(AssignmentNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType());
	}

	@Override
	public void visit(LvalNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType());
	}

	@Override
	public void visit(OperatorNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType());
	}


	@Override
	public void visit(ConstantNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType() + " " + node.getValue());
	}

	@Override
	public void visit(RvalNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType());
	}

	@Override
	public void visit(OutputNode node) {
		for (int i = 0; i < node.depth; i++) {
			System.out.print("\t");
		}
		System.out.println(node.getType());
	}

}
