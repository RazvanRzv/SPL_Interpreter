package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ProductNode extends OperatorNode{

	/**
	 * Constructor
	 */
	public ProductNode() {
		super("ProductNode", 2);
	}
	
	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}

