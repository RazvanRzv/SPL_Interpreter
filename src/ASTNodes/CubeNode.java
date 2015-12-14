package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class CubeNode extends OperatorNode{

	public CubeNode() {
		super("CubeNode", 1);
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

