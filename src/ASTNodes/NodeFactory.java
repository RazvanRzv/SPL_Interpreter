package ASTNodes;


/**
 * @author Curcudel Ioan-Razvan<razvanionutz13@yahoo.com>
 */

public class NodeFactory {

	public ASTNode getNode(String type) {
		if(type.equals("+")) return new SumNode();
		if(type.equals("-")) return new DifferenceNode();
		if(type.equals("*")) return new ProductNode();
		if(type.equals("/")) return new QuotientNode();
		if(type.equals("2")) return new ConstantNode(2);
		if(type.equals("3")) return new ConstantNode(3);
		if(type.equals("4")) return new ConstantNode(4);
		return null;
	}
	
}

