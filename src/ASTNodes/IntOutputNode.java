package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class IntOutputNode extends OutputNode {

	/**
	 * Constructor
	 * 
	 * @param charName
	 *            numele personajului
	 */
	public IntOutputNode(String charName) {
		super(charName);
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}
}
