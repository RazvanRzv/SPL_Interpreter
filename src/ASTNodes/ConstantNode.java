package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ConstantNode extends ASTNode{
	
	public ConstantNode(int value) {
		super("ConstantNode " + value);
		this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

