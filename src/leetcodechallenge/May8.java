package leetcodechallenge;

public class May8 {

	public static boolean checkStraightLine(int[][] coordinates) {
		if (coordinates.length == 2)
			return true;
		int xOne = coordinates[0][0], yOne = coordinates[0][1], xTwo = coordinates[1][0], yTwo = coordinates[1][1];
		for (int i = 2; i < coordinates.length; i++) {
			int xThree = coordinates[i][0], yThree = coordinates[i][1];
			int a = (yThree - yTwo), b = (xThree - xTwo), c = (yThree - yOne), d = (xThree - xOne),
					m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
			if (b != 0)
				m1 = a / b;
			if (d != 0)
				m2 = c / d;
			if (m1 == Integer.MAX_VALUE || m2 == Integer.MAX_VALUE || m1 != m2)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		int[][] a = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
		int[][] b = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };

		System.out.println(checkStraightLine(a));
		System.out.println(checkStraightLine(b));
	}

}
