package leetcodechallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class May6 {
	public static int majorityElementUsingSorting(int[] nums) {
		Arrays.sort(nums);
		// return this if there is gurantee for majority element in the array
		return nums[nums.length / 2];

		// if there is no gurantee of majority element than calculate the frequency of
		// middle element.
		// if frequency is not greater than n/2 then majority element does not exist and
		// return -1.
		// if frequency is greater than n/2 then return the nums[n/2];
	}

	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i]))
				map.put(nums[i], 1);
			else {
				int t = map.get(nums[i]);
				t++;
				map.put(nums[i], t);
				if (t > nums.length / 2)
					return nums[i];
			}
		}
		return nums[0];

	}

	public static void main(String[] args) {
		int[] a = { 2, 2, 1, 1, 1, 2, 2, 2 };
		System.out.println(majorityElement(a));
		System.out.println(majorityElementUsingSorting(a));

	}

}
