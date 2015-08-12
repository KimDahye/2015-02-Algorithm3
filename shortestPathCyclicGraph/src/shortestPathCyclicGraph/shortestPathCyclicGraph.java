package shortestPathCyclicGraph;

import core.Edge;
import core.Graph;

public class shortestPathCyclicGraph {
	public static int[][] topDownMemoization(Graph g) {
		return null;
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
