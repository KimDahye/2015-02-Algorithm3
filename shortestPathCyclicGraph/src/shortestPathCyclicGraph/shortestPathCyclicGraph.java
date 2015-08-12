package shortestPathCyclicGraph;

import core.Edge;
import core.Graph;

public class shortestPathCyclicGraph {
	public static int[][] topDownMemoization(Graph g) {
		int n = g.getVertexSize();
		int[][] pathWeight = new int[n][n];
		
		//pathWeight initialize
		for(int i = 0; i < n; i ++ ){
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					pathWeight[i][j] = 0; 
					continue;
				}
				pathWeight[i][j] = Integer.MAX_VALUE;
			}
		}
		for(int i = 1; i < n; i ++) {
			pathWeight[i][n-1] =topDownMemoizationAug(i, n-1, g, pathWeight);
		}
		return pathWeight;
	}
	
	private static int topDownMemoizationAug(int i, int j, Graph g, int[][] pathWeight) {
		if(i == 0 || j == 0 || pathWeight[i][j] < Integer.MAX_VALUE) {
			return pathWeight[i][j]; 
		}
		
		int endIdx = i;
		pathWeight[endIdx][j] = topDownMemoizationAug(endIdx, j-1, g, pathWeight);

		for(Edge edge : g.getVertexList().get(i).getIngoingEdgeList()) {
			int startIdx = g.getVertexIndex(edge.getStartVertex());
			
			if(topDownMemoizationAug(startIdx, j-1, g, pathWeight) == Integer.MAX_VALUE){ 
				continue;
			}

			int newPathWeight = topDownMemoizationAug(startIdx, j-1, g, pathWeight) + edge.getWeight();
			
			if(pathWeight[endIdx][j] > newPathWeight){
				pathWeight[endIdx][j] = newPathWeight;
			}			
		}
		return pathWeight[endIdx][j];
	}

	
	public static int[][] bottomUp(Graph g) {
		int n = g.getVertexSize();
		int[][] pathWeight = new int[n][n];
		
		//pathWeight initialize
		for(int i = 0; i < n; i ++ ){
			for(int j = 0; j < n; j++) {
				if(i == 0) {
					pathWeight[i][j] = 0; 
					continue;
				}
				pathWeight[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int j = 1; j < n; j++) {
			for(Edge e : g.getEdgeList()){
				int startIdx = g.getVertexIndex(e.getStartVertex());
				int endIdx = g.getVertexIndex(e.getEndVertex());
				int weight = e.getWeight();

				//check boundary conditions carefully. weight can be negative.
				if(pathWeight[startIdx][j-1] == Integer.MAX_VALUE){ 
					continue;
				}
				
				if(pathWeight[endIdx][j] > pathWeight[endIdx][j-1]){
					pathWeight[endIdx][j] = pathWeight[endIdx][j-1];
				}
				int newPathWeight = pathWeight[startIdx][j-1] + weight;
			
				if(pathWeight[endIdx][j] > newPathWeight){
					pathWeight[endIdx][j] = newPathWeight;
				}
			}		
		}
		
		return pathWeight;
	}
}
