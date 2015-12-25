package Visitor;

import ASTNodes.*;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ASTVisitor implements Visitor {

	private Visitor	bVisitor;
	private String	tabs	= "";

	private void addTab() {
		tabs += "\t";
	}

	private void removeTab() {
		tabs = tabs.substring(0, tabs.length() - 1);
	}

	public ASTVisitor(Visitor bVisitor) {
		this.bVisitor = bVisitor;
	}

	@Override
	public void visit(ProgramNode node) {
		// node.accept(bVisitor);
		System.out.println(node.getType());
		addTab();
		for (Visitable v : node.children) {
			v.accept(this);
		}
		removeTab();
	}

	@Override
	public void visit(ActNode node) {
		System.out.print(tabs);
		// node.accept(bVisitor);
		System.out.println(node.getType() + " " + node.getName());
		addTab();
		for (Visitable v : node.children) {
			v.accept(this);
		}
		removeTab();
	}

	@Override
	public void visit(SceneNode node) {
		System.out.print(tabs);
		// node.accept(bVisitor);
		System.out.println(node.getType() + " " + node.getName());
		addTab();
		for (Visitable v : node.children) {
			v.accept(this);
		}
		removeTab();
	}

	@Override
	public void visit(AssignmentNode node) {
		System.out.print(tabs);
		// node.accept(bVisitor);
		System.out.println(node.getType());
		addTab();
		for (Visitable v : node.children) {
			v.accept(this);
		}
		removeTab();
	}

	@Override
	public void visit(LvalNode node) {
		System.out.print(tabs);
		// node.accept(bVisitor);
		System.out.println(node.getType());
	}

	@Override
	public void visit(OperatorNode node) {
//		System.out.println(tabs.length());
		System.out.print(tabs);
		// node.accept(bVisitor);
		System.out.println(node.getType());
		addTab();
		for (Visitable v : node.children) {
			v.accept(this);
		}
		removeTab();
	}


	@Override
	public void visit(ConstantNode node) {
		System.out.print(tabs);
		System.out.println(node.getType());
	}

	@Override
	public void visit(RvalNode node) {
		System.out.print(tabs);
		System.out.println(node.getType());
	}

	@Override
	public void visit(OutputNode node) {
		System.out.print(tabs);
		System.out.println(node.getType());
	}

	@Override
	public void visit(ASTNode node) {
		// TODO Auto-generated method stub

	}

}
