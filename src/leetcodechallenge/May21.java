package leetcodechallenge;

public class May21 {
	public static int countSquares(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		int count = 0;
		int[][] dp = new int[n][m];
		for (int i = 0; i < m; i++) {
			int t = matrix[0][i];
			dp[0][i] = t;
			count += t;
		}
		for (int j = 1; j < n; j++) {
			int t = matrix[j][0];
			dp[j][0] = t;
			count += t;
		}
		for (int k = 1; k < n; k++) {
			for (int l = 1; l < m; l++) {
				if (matrix[k][l] == 1)
					dp[k][l] = 1 + Math.min(dp[k - 1][l], Math.min(dp[k][l - 1], dp[k - 1][l - 1]));
				count += dp[k][l];
			}
		}
		return count;
	}
	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		int[][] b = { { 1, 0, 1 }, { 1, 1, 0 }, { 1, 1, 0 } };
		System.out.println(countSquares(a));
		System.out.println(countSquares(b));
	}

}
