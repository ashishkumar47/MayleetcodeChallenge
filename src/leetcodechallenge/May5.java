package leetcodechallenge;

public class May5 {
	public static int firstUniqChar(String s) {
		int a[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int t = s.charAt(i) - 97;
			a[t]++;
		}
		for (int j = 0; j < s.length(); j++) {
			int t = s.charAt(j) - 97;
			if (a[t] == 1)
				return j;
		}
		return -1;
	}

	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstUniqChar(s));
	}

}
