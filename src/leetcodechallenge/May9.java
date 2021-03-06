package leetcodechallenge;

public class May9 {
	public static boolean isPerfectSquare(int num) {
		if (num == 1)
			return true;
		long start = 1, end = num;
		while (start <= end) {
			long mid = start + (end - start) / 2;
			if (mid * mid == num)
				return true;
			else if (mid * mid < num)
				start = mid + 1;
			else if (mid * mid > num)
				end = mid - 1;

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(144));
		System.out.println(isPerfectSquare(90));
	}

}
