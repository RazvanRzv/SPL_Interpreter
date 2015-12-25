package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class AssignmentNode extends ASTNode{

	/**
	 * Constructor
	 */
	public AssignmentNode() {
		super("AssignmentNode");
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
	

	
	
}

