package ASTNodes;

/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public abstract class OperatorNode extends ASTNode {

	public int maxChildren;
	
	public OperatorNode(String type, int max) {
		super(type);
		maxChildren = max;
	}

}
