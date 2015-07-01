package bfs;

import static org.junit.Assert.*;
import java.util.LinkedList;
import org.junit.Test;

public class BFSTest {

	@Test
	public void test() {
		Node source = new Node();
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		LinkedList<Node> adj_d = new LinkedList<Node>();
		LinkedList<Node> adj_c = new LinkedList<Node>();
		LinkedList<Node> adj_b = new LinkedList<Node>();
		LinkedList<Node> adj_a = new LinkedList<Node>();
		LinkedList<Node> adj_source = new LinkedList<Node>();

		adj_d.add(b);
		adj_c.add(b);
		adj_c.add(a);
		adj_b.add(source);
		adj_b.add(c);
		adj_b.add(d);
		adj_a.add(source);
		adj_a.add(c);
		adj_source.add(a);
		adj_source.add(b);
		d.setAdjacents(adj_d);
		c.setAdjacents(adj_c);
		b.setAdjacents(adj_b);
		a.setAdjacents(adj_a);
		source.setAdjacents(adj_source);

		BFS.bfs(source);
		assertTrue(a.weight.equals(1));
		assertTrue(b.weight.equals(1));
		assertTrue(c.weight.equals(2));
		assertTrue(d.weight.equals(2));
	}
}
