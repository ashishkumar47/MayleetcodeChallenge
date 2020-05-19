package leetcodechallenge;

import java.util.ArrayList;
import java.util.List;

public class May19 {
	private class Stock {
		public List<Integer> list;
		public int lastDayStock;
		Stock() {
			list = new ArrayList<Integer>();
			lastDayStock = 1;
		}
	}

	private final Stock root;
	public May19() {
		root = new Stock();
	}

	public int next(int price) {
		List<Integer>list=root.list;
		list.add(price);
		int span = 1;
		if (list.size() == 1 || price < root.lastDayStock) {
			root.lastDayStock = price;
			return span;
		}
		for (int i = list.size() - 2; i >= 0; i--) {
			int stockPrice = list.get(i);
			if (stockPrice <= price)
				span++;
			else
				break;
		}
		root.lastDayStock = price;
		return span;
	}

	public static void main(String[] args) {
		int[] a = { 100, 80, 60, 70, 60, 75, 85 };
		May19 may19 = new May19();
		for (int i = 0; i < a.length; i++) {
			System.out.print(may19.next(a[i]) + " ");
		}
	}

}
