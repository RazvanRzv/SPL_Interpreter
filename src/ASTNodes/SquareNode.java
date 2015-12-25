package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SquareNode extends OperatorNode{

	/**
	 * Constructor
	 */
	public SquareNode() {
		super("SquareNode", 1);
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}

