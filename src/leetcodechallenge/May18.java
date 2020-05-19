package leetcodechallenge;

public class May18 {
	public static boolean checkArrays(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] != b[j])
				return false;
			i++;
			j++;
		}
		return true;
	}

	public static boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		if (n > m)
			return false;
		int a[] = new int[26];
		int b[] = new int[26];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[s1.charAt(i) - 'a']++;
			if (i < n - 1) {
				b[s2.charAt(i) - 'a']++;
				count++;
			}
		}
		for (int j = count; j < m; j++) {
			b[s2.charAt(j) - 'a']++;
			if (checkArrays(a, b))
				return true;
			b[s2.charAt(j - (n - 1)) - 'a']--;

		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaooo"));
	}

}
