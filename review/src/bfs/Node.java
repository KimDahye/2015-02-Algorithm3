package bfs;

import java.util.LinkedList;

public class Node {
	public Integer distance;
	public String value;
	public LinkedList<Node> adjacents;
	
	public Node() {
		this.distance = null;
		this.value = null;
		this.adjacents = null;
	}
	
	public Node(String value) {
		this.distance = null;
		this.adjacents = null;
		this.value = value;
	}
	
	public void setAdjacents(LinkedList<Node> adjacents) {
		this.adjacents = adjacents;
	}
}