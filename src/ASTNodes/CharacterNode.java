package ASTNodes;

import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class CharacterNode extends ASTNode{

	public String name;
	
	public CharacterNode(String name) {
		super("CharacterNode");
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

