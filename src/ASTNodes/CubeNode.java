package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class CubeNode extends OperatorNode{

	/**
	 * Constructor
	 */
	public CubeNode() {
		super("CubeNode", 1);
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}

