package leetcodechallenge;

import java.util.ArrayList;
import java.util.List;

public class May22 {
	public static String frequencySortApproach3(String s) {
		int[] a = new int[123];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 0]++;
		}
		String str = "";
		List<Character>[] b = new List[s.length() + 1];
		for (int j = 0; j < a.length; j++) {
			if (a[j] != 0) {
				int frequency = a[j];
				char ch = (char) j;
				if (b[frequency] == null) {
					b[frequency] = new ArrayList<>();
				}
				b[frequency].add(ch);
			}
		}
		for (int k = b.length - 1; k >= 0; k--) {
			List<Character> list = b[k];
			if (list != null) {
				for (int q = 0; q < list.size(); q++) {
					char character = list.get(q);
					for (int w = 0; w < k; w++) {
						str += character;
					}
				}
			}
		}
		return str;
	}

	public static String frequencySortApproach2(String s) {
		int[] a = new int[123];
		for (int i = 0; i < s.length(); i++) {
			a[s.charAt(i) - 0]++;
		}
		String str = "";
		int m = 0;
		for (int j = 0; j < s.length(); j++) {
			int max = Integer.MIN_VALUE;
			for (int k = 0; k < a.length; k++) {
				if (a[k] > max && a[k] > 0) {
					max = a[k];
					m = k;
				}
			}
			int n = a[m];
			char ch = (char) m;
			while (n > 0) {
				str += "" + ch;
				n--;
			}
			a[m] = 0;
		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(frequencySortApproach2("Aabb"));
		System.out.println(frequencySortApproach3("Aabb"));
	}

}
