package ASTNodes;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class OutputNode extends ASTNode {

	protected String charName;

	/**
	 * Constructor
	 * 
	 * @param charName
	 *            numele personajului
	 */
	public OutputNode(String charName) {
		super("OutputNode " + charName);
		this.charName = charName;
	}

	/**
	 * 
	 * @return numele personajului
	 */
	public String getCharName() {
		return charName;
	}

}
