package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	public static void bfs(Node source) {
		source.distance = 0;
		Queue<Node> que = new LinkedList<Node>();
		que.add(source);
		while(!que.isEmpty()){
			Node current = que.poll();
			for(Node adj : current.adjacents){
				if(adj.distance == null) {
					adj.distance = current.distance + 1;
					que.add(adj);
				}
			}
		}
	}
}
