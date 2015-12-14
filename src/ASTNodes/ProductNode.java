package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ProductNode extends OperatorNode{

	public ProductNode() {
		super("ProductNode", 2);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

