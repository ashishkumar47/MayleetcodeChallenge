package leetcodechallenge;

public class May25 {

	Integer[][] dp = null;

	public int helperDP(int[] a, int startA, int[] b, int startB, Integer[][] dp) {
		int t1 = Integer.MIN_VALUE, t2 = Integer.MIN_VALUE, t3 = Integer.MIN_VALUE;
		if (startA == a.length || startB == b.length)
			return 0;
		if (dp[startA][startB] != null)
			return dp[startA][startB];
		if (a[startA] == b[startB]) {
			t1 = helperDP(a, startA + 1, b, startB + 1, dp) + 1;
			dp[startA][startB] = t1;
		} else {
			t2 = helperDP(a, startA, b, startB + 1, dp);
			t3 = helperDP(a, startA + 1, b, startB, dp);
		}
		int t = Integer.max(t1, Integer.max(t2, t3));
		dp[startA][startB] = t;
		return t;
	}

	public int maxUncrossedLinesDP(int[] A, int[] B) {
		dp = new Integer[A.length + 1][B.length + 1];
		return helperDP(A, 0, B, 0, dp);
	}

	public int helperRecursion(int[] a, int startA, int[] b, int startB) {
		int t1 = Integer.MIN_VALUE, t2 = Integer.MIN_VALUE, t3 = Integer.MIN_VALUE;
		if (startA == a.length || startB == b.length)
			return 0;
		if (a[startA] == b[startB]) {
			t1 = helperRecursion(a, startA + 1, b, startB + 1) + 1;
		} else {
			t2 = helperRecursion(a, startA, b, startB + 1);
			t3 = helperRecursion(a, startA + 1, b, startB);
		}
		int t = Integer.max(t1, Integer.max(t2, t3));
		return t;
	}

	public int maxUncrossedLinesRecursion(int[] A, int[] B) {
		return helperRecursion(A, 0, B, 0);
	}


	public static void main(String[] args) {
		
		int[] a = { 15, 14, 1, 7, 15, 1, 12, 18, 9, 15, 1, 20, 18, 15, 16, 18, 11, 8, 11, 18, 11, 11, 17, 20, 16, 20,
				15, 15, 9, 18, 16, 4, 16, 1, 13, 10, 10, 20, 4, 18, 17, 3, 8, 1, 8, 19, 14, 10, 10, 12 };
		int[] b = { 12, 8, 17, 4, 2, 18, 16, 10, 11, 12, 7, 1, 8, 16, 4, 14, 12, 18, 18, 19, 19, 1, 11, 18, 1, 6, 12,
				17, 6, 19, 10, 5, 11, 16, 6, 17, 12, 1, 9, 3, 19, 2, 18, 18, 2, 4, 11, 11, 14, 9, 20, 19, 2, 20, 9, 15,
				8, 7, 8, 6, 19, 12, 4, 11, 18, 18, 1, 6, 9, 17, 13, 19, 5, 4, 14, 9, 11, 15, 2, 5, 4, 1, 10, 11, 6, 4,
				9, 7, 11, 7, 3, 8, 11, 12, 4, 19, 12, 17, 14, 18 };
		May25 may25 = new May25();
		// System.out.println(may25.maxUncrossedLinesRecursion(a, b));
		System.out.println(may25.maxUncrossedLinesDP(a, b));

	}

}
