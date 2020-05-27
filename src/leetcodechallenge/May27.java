package leetcodechallenge;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class May27 {
	public static boolean possibleBipartition(int N, int[][] dislikes) {
		List<Integer>[] graph = new LinkedList[N + 1];
		int[] group = new int[N + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int k = 0; k < dislikes.length; k++) {
			int v1 = dislikes[k][0];
			int v2 = dislikes[k][1];
			graph[v1].add(v2);
			graph[v2].add(v1);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int l = 1; l <= N; l++) {
			if (group[l] == 0) {
				group[l] = 1;
				q.add(l);
				while (!q.isEmpty()) {
					int element = q.remove();
					List<Integer> list = graph[element];
					for (int j = 0; j < list.size(); j++) {
						if (group[list.get(j)] == 0) {
							if (group[element] == 1)
								group[list.get(j)] = 2;
							else
								group[list.get(j)] = 1;
							q.add(list.get(j));
						}
						if (group[element] == group[list.get(j)])
							return false;

					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } };
		System.out.println(possibleBipartition(5, a));
	}

}
