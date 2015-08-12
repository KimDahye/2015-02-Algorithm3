package core;

import java.util.ArrayList;

public class Vertex {
	String value;
	ArrayList<Vertex> adjacentList; 
	
	public Vertex(String value, ArrayList<Vertex> adjacentList) {
		this.value = value;
		this.adjacentList = adjacentList;
	}
	
	public Vertex(String value) {
		this(value, null);
	}
}
