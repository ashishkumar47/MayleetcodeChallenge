package leetcodechallenge;

import java.util.HashMap;
import java.util.Map;

public class May10 {
	public static int findJudgeImproved(int N, int[][] trust) {
		if (N == 0)
			return 1;
		int persons[] = new int[N + 1];
		for (int i = 0; i < trust.length; i++) {
			int a = trust[i][0];
			int b = trust[i][1];
			persons[a]--;
			persons[b]++;
		}
		int m = -1;
		for (int j = 1; j <= N; j++) {
			if (persons[j] == N - 1) {
				m = j;
				break;
			}
		}
		return m;
	}
	public static int findJudge(int N, int[][] trust) {
		if (trust.length == 0)
			return 1;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < trust.length; i++) {
			int key = trust[i][1];
			if (map.containsKey(key)) {
				int t = map.get(key);
				t++;
				map.put(key, t);
			} else {
				map.put(key, 1);
			}
		}
		int m = -1;
		for (int j = 1; j <= N; j++) {
			int key = j;
			if (map.containsKey(key) && map.get(key) == N - 1) {
				m = j;
				break;
			}
		}
		for (int k = 0; k < trust.length; k++) {
			int q = trust[k][0];
			if (q == m) {
				m = -1;
				break;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		System.out.println(findJudge(n, trust));
		System.out.println(findJudgeImproved(n, trust));
	}

}
