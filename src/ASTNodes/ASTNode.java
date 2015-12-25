package ASTNodes;

import java.util.ArrayList;

import Visitor.Visitable;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class ASTNode implements Visitable {

	protected ArrayList<ASTNode>	children;
	protected String				type;
	private int						depth	= 0;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            tipul nodului
	 */
	public ASTNode(String type) {
		children = new ArrayList<>();
		this.type = type;
	}

	/**
	 * Adauga un nou nod la lista de adiacenta
	 * 
	 * @param child
	 *            nodul care trebuie adaugat
	 */
	public void addChild(ASTNode child) {
		children.add(child);
	}

	/**
	 * @return tipul nodului
	 */
	public String getType() {
		return type;
	}

	/**
	 * @return lista de adiacenta
	 */
	public ArrayList<ASTNode> getChildren() {
		return children;
	}

	/**
	 * 
	 * @param value
	 *            adancimea la care se gaseste nodul in arbore
	 */
	public void setDepth(int value) {
		depth = value;
	}

	/**
	 * @return adancimea la care se afla nodul in arbore
	 */
	public int getDepth() {
		return depth;
	}

	@Override
	public int accept(Visitor v) {
		return v.visit(this);
	}

}
