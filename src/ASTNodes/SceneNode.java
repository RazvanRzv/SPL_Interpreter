package ASTNodes;

import Visitor.ASTVisitor;
import Visitor.Visitor;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class SceneNode extends ASTNode {

	public String name; // make it private

	public SceneNode(String name) {
		super("SceneNode");
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
