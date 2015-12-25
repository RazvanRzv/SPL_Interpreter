package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class LvalNode extends ASTNode {

	private String charName;

	/**
	 * Constructor
	 * 
	 * @param charName
	 *            numele personajului
	 */
	
	public LvalNode(String charName) {
		super("LvalNode " + charName);
		this.charName = charName;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

	/**
	 * 
	 * @return numele personajului
	 */
	
	public String getChar() {
		return charName;
	}

}
