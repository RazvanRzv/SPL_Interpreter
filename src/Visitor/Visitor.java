package Visitor;

import ASTNodes.*;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public interface Visitor {
	public int visit(ASTNode node);
	public int visit(ProgramNode node);
	public int visit(ActNode node);
	public int visit(SceneNode node);
	public int visit(AssignmentNode node);
	public int visit(LvalNode node);
	public int visit(SumNode node);
	public int visit(DifferenceNode node);
	public int visit(ProductNode node);
	public int visit(QuotientNode node);
	public int visit(SquareNode node);
	public int visit(CubeNode node);
	public int visit(ConstantNode node);
	public int visit(RvalNode node);
	public int visit(IntOutputNode node);
	public int visit(CharOutputNode node);
	
}

