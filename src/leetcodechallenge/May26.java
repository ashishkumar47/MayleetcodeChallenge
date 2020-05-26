package leetcodechallenge;

import java.util.HashMap;
import java.util.Map;

public class May26 {
	public static int findMaxLength(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		m.put(0, -1);
		int count = 0, maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count--;
			if (nums[i] == 1)
				count++;
			if (m.containsKey(count)) {
				maxLength = Math.max(maxLength, i - m.get(count));
			} else {
				m.put(count, i);
			}

		}
		return maxLength;
	}

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 0, 0, 0, 1, 1 };
		System.out.println(findMaxLength(a));
	}

}
