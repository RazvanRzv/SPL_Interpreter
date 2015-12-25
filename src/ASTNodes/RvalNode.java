package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class RvalNode extends ASTNode {

	private String	charName;
	private int		value;

	/**
	 * Constructor
	 * 
	 * @param charName
	 *            numele personajului
	 */
	public RvalNode(String charName) {
		super("RValNode " + charName);
		this.charName = charName;
		value = 0;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

	/**
	 * 
	 * @return numele personajului
	 */

	public String getCharName() {
		return charName;
	}

	/**
	 * 
	 * @return valoarea personajului
	 */

	public int getValue() {
		return value;
	}
}
