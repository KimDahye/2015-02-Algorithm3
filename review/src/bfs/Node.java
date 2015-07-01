package bfs;

import java.util.LinkedList;

public class Node {
	public Integer weight;
	LinkedList<Node> adjacents;
	
	public Node() {
		this.weight = null;
		this.adjacents = null;
	}
	
	public Node(Integer weight, LinkedList<Node> adjacents) {
		this.weight = weight;
		this.adjacents = adjacents;
	}
	
	public void setAdjacents(LinkedList<Node> adjacents) {
		this.adjacents = adjacents;
	}
}