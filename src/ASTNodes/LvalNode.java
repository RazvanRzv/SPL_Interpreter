package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class LvalNode extends ASTNode{

	public LvalNode(String charName) {
		super("LvalNode " + charName);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}

