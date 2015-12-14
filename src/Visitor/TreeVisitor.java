package Visitor;

import ASTNodes.ASTNode;
import ASTNodes.ActNode;
import ASTNodes.AssignmentNode;
import ASTNodes.CharacterNode;
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

public class TreeVisitor implements Visitor {

	private Visitor baseVisitor;

	public TreeVisitor(Visitor baseVisitor) {
		this.baseVisitor = baseVisitor;
	}

	@Override
	public void visit(ASTNode node) {}

	@Override
	public void visit(ProgramNode node) {
		node.accept(baseVisitor);
		for(int i = 0 ; i < node.children.size(); i++) {
			node.children.get(i).depth ++ ;
			node.children.get(i).accept(this);
		}
	}

	@Override
	public void visit(ActNode node) {
		node.accept(baseVisitor);
		for(int i = 0 ; i < node.children.size(); i++) {
			node.children.get(i).depth = node.depth + 1 ;
			node.children.get(i).accept(this);
		}
	}

	@Override
	public void visit(SceneNode node) {
		node.accept(baseVisitor);
		for(int i = 0 ; i < node.children.size(); i++) {
			node.children.get(i).depth = node.depth + 1 ;
			node.children.get(i).accept(this);
		}
	}

	@Override
	public void visit(AssignmentNode node) {
		node.accept(baseVisitor);
		for(int i = 0 ; i < node.children.size(); i++) {
			node.children.get(i).depth = node.depth + 1 ;
			node.children.get(i).accept(this);
		}
	}

	@Override
	public void visit(LvalNode node) {
		node.accept(baseVisitor);
	}

	@Override
	public void visit(OperatorNode node) {
		node.accept(baseVisitor);
		for(int i = 0 ; i < node.children.size(); i++) {
			node.children.get(i).depth = node.depth + 1 ;
			node.children.get(i).accept(this);
		}
	}

	@Override
	public void visit(CharacterNode node) {

	}

	@Override
	public void visit(ConstantNode node) {
		node.accept(baseVisitor);
	}

	@Override
	public void visit(RvalNode node) {
		node.accept(baseVisitor);
	}

	@Override
	public void visit(OutputNode node) {
		node.accept(baseVisitor);
	}

}
