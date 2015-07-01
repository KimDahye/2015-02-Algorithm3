package dfs;

import bfs.Node;

public class DFS {
	/* input: source의 distance가 0으로, 나머지 노드들의 distance는 null로 초기화된 그래프의 source Node.
	 * output: void. (그래프의 각 노드의 distance값은 source로부터의 깊이 우선 탐색 결과값으로 변경됨)
	 * print: source에서의 깊이 우선 탐색 결과대로 프린트 됨.
	 * */
	public static void dfs(Node source) {
		// 방어 코드
		if(source == null) {
			return;
		}
		
		//dfs 알고리즘
		System.out.println(source.value);
		for(Node adj : source.adjacents) {
			if(adj.distance == null) {
				adj.distance = source.distance + 1;
				dfs(adj);
			}
		}
	}
}
