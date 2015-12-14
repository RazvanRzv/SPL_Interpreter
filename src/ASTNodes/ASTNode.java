package ASTNodes;

import java.util.ArrayList;

import Visitor.Visitable;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class ASTNode implements Visitable {

	public ArrayList<ASTNode>	children;	// change to protected
	protected String			type;
	protected int				value;
	public ASTNode				parent;
	public int					depth	= 0;

	public ASTNode(String type) {
		children = new ArrayList<>();
		this.type = type;
	}

	public void addChild(ASTNode child) {
		children.add(child);
	}

	public String getType() {
		return type;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
