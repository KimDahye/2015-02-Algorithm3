package core;

public class Edge {
	Vertex start;
	Vertex end;
	int weight;
	
	public Edge(Vertex start, Vertex end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public Vertex getStartVertex(){
		return start;
	}
	
	public Vertex getEndVertex() {
		return end;
	}
	
	public int getWeight() {
		return weight;
	}
}
