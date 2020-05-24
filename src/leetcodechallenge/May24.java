package leetcodechallenge;

public class May24 {
	public class TreeNode {
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

	public TreeNode helper(int[] a, int start, int end) {
		if (start > end)
			return null;
		TreeNode root = new TreeNode(a[start]);
		int i = start + 1, compare = a[start];
		while (i <= end) {
			if (a[i] > compare)
				break;
			i++;
		}
		int prels = start + 1;
		int prele = i - 1;
		int prers = i;
		int prere = end;
		root.left = helper(a, prels, prele);
		root.right = helper(a, prers, prere);
		return root;
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		return helper(preorder, 0, preorder.length - 1);
	}

	public void print(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		print(root.left);
		print(root.right);
	}
	public static void main(String[] args) {
		int[] a = { 8, 5, 1, 7, 10, 12 };
		May24 may24 = new May24();
		TreeNode treeNode = may24.bstFromPreorder(a);
		may24.print(treeNode);
	}

}
