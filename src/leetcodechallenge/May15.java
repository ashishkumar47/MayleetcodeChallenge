package leetcodechallenge;

public class May15 {
	public int maxSubarraySumCircular(int[] A) {
		int globalMax = A[0];
		int localMax = A[0];
		for (int i = 1; i < A.length; i++) {
			localMax = Integer.max(A[i], localMax + A[i]);
			if (localMax > globalMax)
				globalMax = localMax;
		}
		int globalMin = A[0];
		int localMin = A[0];
		int sum = A[0];

		for (int j = 1; j < A.length; j++) {
			localMin = Integer.min(A[j], localMin + A[j]);
			sum = sum + A[j];
			if (globalMin > localMin)
				globalMin = localMin;
		}
		if (sum == globalMin)
			return globalMax;
		return Integer.max(globalMax, sum - globalMin);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
