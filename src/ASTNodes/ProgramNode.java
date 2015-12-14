package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class ProgramNode extends ASTNode{

	public ProgramNode() {
		super("ProgramNode");
	}
	
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}
}

