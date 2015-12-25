package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ConstantNode extends ASTNode {

	private int value;

	/**
	 * Constructor
	 * 
	 * @param value
	 *            valoarea din nod
	 */
	public ConstantNode(int value) {
		super("ConstantNode " + value);
		this.value = value;
	}

	/**
	 * @return valoarea din nod
	 */
	public int getValue() {
		return value;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}
