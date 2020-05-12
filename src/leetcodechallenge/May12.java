package leetcodechallenge;

public class May12 {
	public static int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid % 2 == 0) {
				if (mid - 1 >= l && nums[mid] == nums[mid - 1])
					r = mid - 2;
				else if (mid + 1 <= r && nums[mid] == nums[mid + 1])
					l = mid + 2;
				else
					return nums[mid];
			} else {
				if (mid + 1 <= r && nums[mid] == nums[mid + 1])
					r = mid - 1;
				else if (mid - 1 >= l && nums[mid] == nums[mid - 1])
					l = mid + 1;
				else
					return nums[mid];
			}
		}
		return -1;

	}

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
		int[] b = { 3, 3, 7, 7, 10, 11, 11 };
		System.out.println(singleNonDuplicate(a));
		System.out.println(singleNonDuplicate(b));
	}

}
