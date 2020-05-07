package leetcodechallenge;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Pair {
	int parent;
	int level;

	Pair(int parent, int level) {
		this.parent = parent;
		this.level = level;
	}
}

//First approach
public class May7 {
	public static void getData(TreeNode root, int x, int[] a, int l) {
		if (root == null)
			return;
		if (root.val == x) {
			a[0] = root.val;
			a[1] = l;
			return;
		} else if (root.left != null && root.left.val == x) {
			a[0] = root.val;
			a[1] = l;
			return;
		} else if (root.right != null && root.right.val == x) {
			a[0] = root.val;
			a[1] = l;
			return;
		}
		getData(root.left, x, a, l + 1);
		getData(root.right, x, a, l + 1);

	}

	// Second Approach
	public static Pair helper(TreeNode root, int data, int parent, int level) {
		if (root == null)
			return null;
		if (root.val == data) {
			return new Pair(parent, level);
		}
		Pair left = helper(root.left, data, root.val, level + 1);
		Pair right = helper(root.right, data, root.val, level + 1);
		if (left == null)
			return right;
		return left;
	}

	public static boolean isCousins(TreeNode root, int x, int y) {

		// Using first Approach
		int[] a1 = new int[2];
		int[] a2 = new int[2];
		getData(root, x, a1, 0);
		getData(root, y, a2, 0);
		if (a1[1] == a2[1] && a1[0] != a2[0])
			return true;
		return false;

		// Using Second Approach
//		Pair left = helper(root, x, Integer.MAX_VALUE, 0);
//		Pair right = helper(root, y, Integer.MAX_VALUE, 0);
//
//		if (left.level == right.level && left.parent != right.parent)
//			return true;
//		return false;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode();
		// First Node
		int x = 0;
		// Second Node
		int y = 0;
		System.out.println(isCousins(root, x, y));
	}

}
