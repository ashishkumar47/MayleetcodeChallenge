package leetcodechallenge;

class Treenode {
	int val;
	Treenode left;
	Treenode right;

	Treenode() {
	}

	Treenode(int val) {
		this.val = val;
	}

	Treenode(int val, Treenode left, Treenode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class May20 {
	public void helper(Treenode root, int k, int[] a) {
		if (root == null)
			return;
		helper(root.left, k, a);
		a[0]++;
		if (a[0] == k) {
			a[1] = root.val;
			return;
		}
		helper(root.right, k, a);
	}

	public int kthSmallest(Treenode root, int k) {
		if (root == null)
			return 0;
		int a[] = new int[2];
		helper(root, k, a);
		return a[1];
	}

	public static void main(String[] args) {

	}

}
