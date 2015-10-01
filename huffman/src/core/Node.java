package core;


public class Node {
	Node parent;
	Node left;
	Node right;
	Item item;
	
	Node(Node parent, Node left, Node right, Item item){
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.item = item;
	}
}
