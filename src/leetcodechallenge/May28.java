package leetcodechallenge;

public class May28 {
	public static int[] countBits(int num) {
		int[] dp = new int[num + 1];
		dp[0] = 0;
		for (int i = 1; i <= num; i++) {
			if (i % 2 == 0) {
				int numberOfSetBits = dp[i / 2];
				dp[i] = numberOfSetBits;
			} else {
				int numberOfSetBits = dp[i / 2];
				dp[i] = numberOfSetBits + 1;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		int[] a = countBits(5);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}

}
