package leetcodechallenge;

public class May31 {
	public static int minDistanceRecursion(String word1, String word2) {
		int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE, t3 = Integer.MAX_VALUE;
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();
		if (word1.charAt(0) == word2.charAt(0))
			return minDistanceRecursion(word1.substring(1), word2.substring(1));

		if (word1.charAt(0) != word2.charAt(0)) {
			t1 = minDistanceRecursion(word1.substring(1), word2.substring(1));
			t2 = minDistanceRecursion(word1.substring(1), word2);
			t3 = minDistanceRecursion(word1, word2.substring(1));
		}
		return Math.min(t1, Math.min(t2, t3)) + 1;
	}

	public int helperMemoization(String word1, String word2, int[][] dp) {
		int t1 = Integer.MAX_VALUE, t2 = Integer.MAX_VALUE, t3 = Integer.MAX_VALUE;
		if (word1.length() == 0)
			return word2.length();
		if (word2.length() == 0)
			return word1.length();
		if (dp[word1.length()][word2.length()] > 0)
			return dp[word1.length()][word2.length()];

		if (word1.charAt(0) == word2.charAt(0)) {
			int t = helperMemoization(word1.substring(1), word2.substring(1), dp);
			dp[word1.length()][word2.length()] = t;
			return t;
		}

		if (word1.charAt(0) != word2.charAt(0)) {
			t1 = helperMemoization(word1.substring(1), word2.substring(1), dp);
			t2 = helperMemoization(word1.substring(1), word2, dp);
			t3 = helperMemoization(word1, word2.substring(1), dp);
		}
		dp[word1.length()][word2.length()] = Math.min(t1, Math.min(t2, t3)) + 1;
		return Math.min(t1, Math.min(t2, t3)) + 1;
	}

	public int minDistanceMemoization(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		return helperMemoization(word1, word2, dp);
	}

	public static int minDistanceDP(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}
		for (int j = 0; j <= word1.length(); j++) {
			dp[j][0] = j;
		}
		for (int l = 1; l <= word1.length(); l++) {
			for (int m = 1; m <= word2.length(); m++) {
				if (word1.charAt(l - 1) == word2.charAt(m - 1))
					dp[l][m] = dp[l - 1][m - 1];
				else
					dp[l][m] = 1 + Math.min(dp[l - 1][m - 1], Math.min(dp[l - 1][m], dp[l][m - 1]));
			}
		}
		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {

	}

}
