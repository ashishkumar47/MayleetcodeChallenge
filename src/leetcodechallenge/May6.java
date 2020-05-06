package leetcodechallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class May6 {
	public static int BoyerMooreVotingAlgorithm(int[] nums) {
		int count = 1;
		int major = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == major)
				count++;
			else
				count--;
			if (count == 0) {
				major = nums[i];
				count = 1;
			}
		}
		return major;
		// In case if there is no gurantee of having majority element in the array
		// then we have to calculate the frequency of the major element to check its
		// frequency > n/2
	}
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
		System.out.println(BoyerMooreVotingAlgorithm(a));

	}

}
