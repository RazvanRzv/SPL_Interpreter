package ASTNodes;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class OperatorNode extends ASTNode {

	private int maxChildren;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            tipul nodului
	 * @param max
	 *            numarul maxim de copii pe care ii poate avea
	 */
	public OperatorNode(String type, int max) {
		super(type);
		maxChildren = max;
	}

	/**
	 * 
	 * @return numarul maxim de copii pe care ii poate avea operatorul
	 */
	public int getMaxChildren() {
		return maxChildren;
	}

}
