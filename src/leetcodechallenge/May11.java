package leetcodechallenge;

public class May11 {
	public static void helper(int[][] image, int start, int end, int newColor, int oldColor, int row, int col) {
		if (start > row - 1 || start < 0 || end < 0 || end > col - 1 || image[start][end] != oldColor)
			return;
		if (image[start][end] == oldColor)
			image[start][end] = newColor;
		helper(image, start, end + 1, newColor, oldColor, row, col);
		helper(image, start, end - 1, newColor, oldColor, row, col);
		helper(image, start + 1, end, newColor, oldColor, row, col);
		helper(image, start - 1, end, newColor, oldColor, row, col);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor)
			return image;
		int row = image.length;
		int col = image[0].length;
		helper(image, sr, sc, newColor, image[sr][sc], row, col);
		return image;
	}

	public static void main(String[] args) {
		int[][] a = { { 8 }, { 5 }, { 6 }, { 6 }, { 2 }, { 2 }, { 0 }, { 3 }, { 3 }, { 7 }, { 7 }, { 0 }, { 1 },
				{ 1 } };
		int sr = 11, sc = 0, newColor = 48;
		int[][] b = floodFill(a, sr, sc, newColor);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
	}

}
