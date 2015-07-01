package countNodes;

public class CountNodes {
	public static int countNodes(Node root) {
		if(root == null) return 0;
		return 1+ countNodes(root.left) + countNodes(root.right);
	}
}