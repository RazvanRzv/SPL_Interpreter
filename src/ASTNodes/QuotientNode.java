package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class QuotientNode extends OperatorNode{

	public QuotientNode() {
		super("QuotientNode", 2);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
