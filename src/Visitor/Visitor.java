package Visitor;

import ASTNodes.*;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public interface Visitor {
	public void visit(ASTNode node);
	public void visit(ProgramNode node);
	public void visit(ActNode node);
	public void visit(SceneNode node);
	public void visit(AssignmentNode node);
	public void visit(LvalNode node);
	public void visit(OperatorNode node);
	public void visit(CharacterNode node);
	public void visit(ConstantNode node);
	public void visit(RvalNode node);
	public void visit(OutputNode node);
}

