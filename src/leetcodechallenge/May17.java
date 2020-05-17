package leetcodechallenge;

import java.util.ArrayList;
import java.util.List;

public class May17 {
	public static boolean matchArray(int[] a, int[] b) {
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] != b[j])
				return false;
			i++;
			j++;
		}
		return true;
	}

	public static List<Integer> findAnagrams(String s, String p) {
		int n = s.length();
		int m = p.length();
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		if (m > n)
			return list;
		int[] a = new int[26];
		int[] b = new int[26];
		for (int i = 0; i < m; i++) {
			a[p.charAt(i) - 'a']++;
			if (i < m - 1) {
				b[s.charAt(i) - 'a']++;
				count++;
			}

		}
		for (int j = count; j < n; j++) {
			b[s.charAt(j) - 'a']++;
			if (matchArray(a, b))
				list.add(j - (m - 1));
			b[s.charAt(j - (m - 1)) - 'a']--;
		}
		return list;
	}
	public static void main(String[] args) {
		List<Integer> list = findAnagrams("cbaebabacd", "abc");
		System.out.println(list);
	}

}
