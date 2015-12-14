package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class CharOutputNode extends OutputNode{

	public CharOutputNode(String charName) {
		super(charName);
	}
	

	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

