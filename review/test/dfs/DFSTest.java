package dfs;

import java.util.LinkedList;

import org.junit.Test;

import bfs.Node;

public class DFSTest {

	@Test
	public void test() {
		Node source = new Node("source");
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
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

		source.distance = 0;
		DFS.dfs(source);	
	}

}
