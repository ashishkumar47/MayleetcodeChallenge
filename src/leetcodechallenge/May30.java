package leetcodechallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class May30 {
	public static double findDistance(int[][] points, int m) {
		int x1 = points[m][0];
		int y1 = points[m][1];
		return Math.sqrt((x1 * x1) + (y1 * y1));
	}

	public static int[][] kClosest(int[][] points, int K) {
		double[] store = new double[points.length];
		Map<Double, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			double distance = findDistance(points, i);
			store[i] = distance;
		}
		Arrays.sort(store);
		double kthDistance = store[K - 1];
		int[][] result = new int[K][2];
		int z = 0;
		for (int j = 0; j < points.length; j++) {
			double distance = findDistance(points, j);
			if (distance <= kthDistance) {
				result[z] = points[j];
				z++;
			}
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
