package shortestPathCyclicGraph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import core.Edge;
import core.Graph;
import core.Vertex;

public class shortestPathCyclicGraphTest {
	Graph graph;
	
	@Before
	public void setup() {
		Vertex s = new Vertex("s"); // Assume that the first vertex is the source vertex.
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		
		Edge edge1 = new Edge(s, v1, 1);
		Edge edge2 = new Edge(v1, v3, -2);
		Edge edge3 = new Edge(v3, v1, 2);
		Edge edge4 = new Edge(v3, s, 3);
		Edge edge5 = new Edge(v1, v2, 2);
		Edge edge6 = new Edge(v3, v2, 1);

		ArrayList<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(0, s);
		vertexList.add(1, v1);
		vertexList.add(2, v2);
		vertexList.add(3, v3);
		
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		edgeList.add(edge1);
		edgeList.add(edge2);
		edgeList.add(edge3);
		edgeList.add(edge4);
		edgeList.add(edge5);
		edgeList.add(edge6);

		graph = new Graph(vertexList, edgeList);
	}

	@Test
	public void testTopDownMemoization() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBottomUp() {
		int[][] pathWeight = shortestPathCyclicGraph.bottomUp(graph);
		assertEquals(-1, pathWeight[3][graph.getVertexSize() - 1]);	
		assertEquals(0, pathWeight[2][graph.getVertexSize() - 1]);	
	}
	
	//BottomUp 방식이 k에 따라 모든 edge에 대해 relaxation을 하는데 k가 증가하며 차례 차례하는 것이므로 topological sorting되어 있는 상태로 돌아간다.
	//따라서 topological sorting을 추가적으로 한 알고리즘은 구현하지 않겠다.
}
