package leetcodechallenge;

import java.util.LinkedList;
import java.util.List;

public class May29 {
	public static boolean checkCycle(List<Integer>[] graph, int[] color, int curr) {
		if (color[curr] == 2)
			return true;
		color[curr] = 2;
		List<Integer> list = graph[curr];
		for (int i = 0; i < list.size(); i++) {
			if (color[list.get(i)] != 1) {
				boolean flag = checkCycle(graph, color, list.get(i));
				if (flag == true)
					return true;
			}
		}
		color[curr] = 1;
		return false;
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new LinkedList[numCourses];
		int[] color = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new LinkedList<>();
		}
		for (int k = 0; k < prerequisites.length; k++) {
			int v1 = prerequisites[k][0];
			int v2 = prerequisites[k][1];
			graph[v1].add(v2);
		}
		for (int m = 0; m < numCourses; m++) {
			if (color[m] == 0) {
				if (checkCycle(graph, color, m))
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		int[][] a = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(2, a));
	}

}
