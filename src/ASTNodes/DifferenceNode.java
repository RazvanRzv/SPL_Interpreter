package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class DifferenceNode extends OperatorNode{
	
	/**
	 * Constructor
	 */
	public DifferenceNode() {
		super("DifferenceNode",2);
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}

