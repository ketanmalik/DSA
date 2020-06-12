
public class MatrixMultiplication {

	// Square Matrix (n x n). Time Complexity - O(n^3)
	public static int[][] bruteMatrixMultiplication(int[][] A, int[][] B) {
		int n = A.length;
		int[][] C = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				C[i][j] = 0;
				for (int k = 0; k < n; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		return C;
	}
}
