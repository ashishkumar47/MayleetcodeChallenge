package leetcodechallenge;

public class May16 {
	Node head = null;
	private static class Node {
		int data;
		Node next;

		Node(int d) {
			next = null;
			data = d;
		}
	}

	private static May16 insert(int[] a, May16 may16) {
		for (int i = 0; i < a.length; i++) {
			int key = a[i];
			Node node = new Node(key);
			if (may16.head == null) {
				may16.head = node;
			} else {
				Node trav = may16.head;
				while (trav.next != null) {
					trav = trav.next;
				}
				trav.next = node;
			}
		}
		return may16;
	}

	public static void print(May16 head) {
		Node trav = head.head;
		while (trav != null) {
			System.out.print(trav.data + "->");
			trav = trav.next;
		}
	}

	public static Node oddEvenList(Node head) {
		if (head == null)
			return null;
		Node oddHead = null;
		Node oddTail = null;
		Node evenHead = null;
		Node evenTail = null;
		Node trav = head;
		int i = 1;
		while (trav != null) {
			if (i % 2 == 0) {
				if (evenHead == null) {
					evenHead = trav;
					evenTail = trav;
				} else {
					evenTail.next = trav;
					evenTail = evenTail.next;
				}
			} else {
				if (oddHead == null) {
					oddHead = trav;
					oddTail = trav;
				} else {
					oddTail.next = trav;
					oddTail = oddTail.next;
				}
			}
			trav = trav.next;
			i++;
		}
		if (evenHead == null) {
			oddTail.next = null;
			return oddHead;
		}
		oddTail.next = evenHead;
		evenTail.next = null;
		return oddHead;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 9 };
		May16 may16 = new May16();
		May16 list = insert(a, may16);
		print(list);
		System.out.println();
		Node newHead = oddEvenList(list.head);
		list.head = newHead;
		print(list);

	}

}
