package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class AssignmentNode extends ASTNode{

	public AssignmentNode() {
		super("AssignmentNode");
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	

	
	
}

