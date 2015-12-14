package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ActNode extends ASTNode{

	public String name;
	
	public ActNode(String name) {
		super("ActNode");
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
	
}

