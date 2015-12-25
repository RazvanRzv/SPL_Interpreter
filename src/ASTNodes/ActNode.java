package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ActNode extends ASTNode {

	private String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            numarul actului
	 */

	public ActNode(String name) {
		super("ActNode");
		this.name = name;
	}

	/**
	 * 
	 * @return numarul actului
	 */

	public String getName() {
		return name;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}
