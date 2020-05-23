package leetcodechallenge;

import java.util.ArrayList;
import java.util.List;

public class May23 {
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
		List<Integer> list = new ArrayList<>();
		int n = A.length;
		int m = B.length;
		int i = 0, j = 0;
		while (i < n && j < m) {
			int l = Integer.max(A[i][0], B[j][0]);
			int r = Integer.min(A[i][1], B[j][1]);
			if (r == A[i][1])
				i++;
			else if (r == B[j][1])
				j++;

			if (l <= r) {
				list.add(l);
				list.add(r);
			}
		}
		int[][] c = new int[list.size() / 2][2];
		int z = 0;
		for (int k = 0; k < list.size() - 1; k = k + 2) {
			c[z][0] = list.get(k);
			c[z][1] = list.get(k + 1);
			z++;
		}
		return c;
	}

	public static void main(String[] args) {
		int[][] a = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
		int[][] b = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
		int[][] c = intervalIntersection(a, b);
		System.out.print("[");
		for (int i = 0; i < c.length; i++) {
			System.out.print("[" + c[i][0] + "," + c[i][1] + "]" + ",");
		}
		System.out.println("]");
	}

}
