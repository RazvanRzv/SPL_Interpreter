package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SceneNode extends ASTNode {

	private String name;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            numarul scenei
	 */
	public SceneNode(String name) {
		super("SceneNode");
		this.name = name;
	}

	/**
	 * 
	 * @return numarul scenei
	 */
	public String getName() {
		return name;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}
