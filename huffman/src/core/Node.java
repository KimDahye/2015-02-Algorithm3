package core;

public class Node {
	public Node parent;
	public Node left;
	public Node right;
	public Item item;
	
	public Node(Node parent, Node left, Node right, Item item){
		this.parent = parent;
		this.left = left;
		this.right = right;
		this.item = item;
	}
	
	public Node(Item item) {
		this(null, null, null, item);
	}
	
	public void print(int level){
		if(this.left != null) this.left.print(level+1);
		System.out.println();
		printRepeatedString(" ", level);
		System.out.println(this.toString());
		if(this.right != null) this.right.print(level+1);
	}

	
	private static void printRepeatedString (String str, int count) {
		for(int i = 0; i < count; i++){
			System.out.print(str);
		}
	}

	@Override
	public String toString() {
		return "Node [item=" + item + "]";
	}
}
