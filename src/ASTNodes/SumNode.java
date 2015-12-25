package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SumNode extends OperatorNode {

	/**
	 * Constructor
	 */
	public SumNode() {
		super("SumNode",2);

	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}
