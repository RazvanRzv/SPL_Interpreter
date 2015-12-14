package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class DifferenceNode extends OperatorNode{
	
	public DifferenceNode() {
		super("DifferenceNode",2);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

