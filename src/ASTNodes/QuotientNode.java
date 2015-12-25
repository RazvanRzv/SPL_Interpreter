package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class QuotientNode extends OperatorNode{

	/**
	 * Constructor
	 */
	public QuotientNode() {
		super("QuotientNode",2);
	}
	
	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}

