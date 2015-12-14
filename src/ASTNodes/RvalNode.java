package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class RvalNode extends ASTNode {

	public RvalNode(String charName) {
		super("RValNode " + charName);
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
