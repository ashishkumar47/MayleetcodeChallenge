package leetcodechallenge;

public class May4 {

	public static int bitwiseComplement(int N) {
		if (N == 0)
			return 1;
		int result = 0;
		int pow = 1;
		while (N > 0) {
			result += (N % 2 ^ 1) * pow;
			N = N / 2;
			pow = pow * 2;
		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(bitwiseComplement(5));
	}

}
