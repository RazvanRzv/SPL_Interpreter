package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ProgramNode extends ASTNode{

	/**
	 * Constructor
	 */
	public ProgramNode() {
		super("ProgramNode");
	}
	
	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}

