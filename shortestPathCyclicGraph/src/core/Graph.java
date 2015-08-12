package core;

import java.util.ArrayList;

public class Graph {
	ArrayList<Vertex> vertexList;	
	ArrayList<Edge> edgeList;
	
	public Graph(ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}
	
	public int getVertexSize() {
		return vertexList.size();
	}
	
	public ArrayList<Edge> getEdgeList() {
		return this.edgeList;
	}
	
	public int getVertexIndex(Vertex vertex) {
		return vertexList.indexOf(vertex);
	}
}
