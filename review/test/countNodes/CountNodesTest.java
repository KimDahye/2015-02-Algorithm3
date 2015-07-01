package countNodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountNodesTest {

	@Test
	public void testWhenRootHasTwoChild() {
		Node left = new Node(2, null, null);
		Node right = new Node(3, null, null);
		Node root = new Node(1, left, right);
		
		assertEquals(CountNodes.countNodes(root), 3);
	}
	
	@Test
	public void testWhenRootIsNull() {		
		assertEquals(CountNodes.countNodes(null), 0);
	}
	
	@Test
	public void testWhenRootHasOnlyOneChild() {	
		Node left = new Node(2, null, null);
		Node root = new Node(1, left, null);
		assertEquals(CountNodes.countNodes(root), 2);
	}
	
	
}
