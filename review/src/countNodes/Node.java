package countNodes;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node (int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}	
}