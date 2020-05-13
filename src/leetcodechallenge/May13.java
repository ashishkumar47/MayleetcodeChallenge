package leetcodechallenge;

import java.util.Stack;

public class May13 {
//	public static String[] helper(String s) {
//		if (s.length() == 0) {
//			String[] a = { "" };
//			return a;
//		}
//		String[] small = helper(s.substring(1));
//		String[] result = new String[small.length * 2];
//		int z = 0;
//		for (int j = 0; j < small.length; j++) {
//			result[z] = small[j];
//			z++;
//		}
//		for (int i = 0; i < small.length; i++) {
//			result[z] = s.charAt(0) + small[i];
//			z++;
//		}
//		return result;
//
//	}
//
//	public static String removeKdigits(String num, int k) {
//		if (k > num.length())
//			return "0";
//		String[] s = helper(num);
//		String smallest = s[0];
//		for (int i = 1; i < s.length; i++) {
//			if (s[i].length() == num.length() - k) {
//				System.out.println(s[i]);
//			}
//		}
//
//		return smallest;
//	}
	public static String removeKdigits(String num, int k) {
		if (k >= num.length())
			return "0";
		Stack<Character> s = new Stack<>();
		int i = 0;
		while (i < num.length()) {
			while (!s.empty() && s.peek() > num.charAt(i) && k > 0) {
				k--;
				s.pop();
			}
			s.push(num.charAt(i));
			i++;
		}
		while (k > 0) {
			s.pop();
			k--;
		}
		String newString = "";
		while (!s.empty()) {
			char ch = s.peek();
			s.pop();
			newString = ch + newString;
		}
		int countLeadingZeros = 0;
		for (int j = 0; j < newString.length(); j++) {
			if (newString.charAt(j) == '0' && newString.length() - 1 > 0)
				countLeadingZeros++;
			else
				break;
		}
		if (countLeadingZeros == newString.length())
			return "0";
		return newString.substring(countLeadingZeros);
	}

	public static void main(String[] args) {

		System.out.println(removeKdigits("1432219", 3));
		System.out.println(removeKdigits("10200", 1));
	}

}
