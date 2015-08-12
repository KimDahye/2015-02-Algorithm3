package core;

import java.util.ArrayList;

public class Vertex {
	String value;
	ArrayList<Edge> ingoingEdgeList; 
	
	public Vertex(String value, ArrayList<Edge> ingoingEdgeList) {
		this.value = value;
		this.ingoingEdgeList = ingoingEdgeList;
	}
	
	public Vertex(String value) {
		this(value, null);
	}
	
	public ArrayList<Edge> getIngoingEdgeList() {
		return this.ingoingEdgeList;
	}
}
