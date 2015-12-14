package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SquareNode extends OperatorNode{

	public SquareNode() {
		super("SquareNode",1);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

