package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SumNode extends OperatorNode {

	public SumNode() {
		super("SumNode",2);

	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}
