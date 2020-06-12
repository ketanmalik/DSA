
public class Driver {
	public static void main(String[] args) {
		int[][] A = { { 2, 4, 1 }, { 6, 3, 2 }, { 4, 1, 2 } };
		int[][] B = { { 5, 2, 10 }, { 3, 1, 4 }, { 2, 5, 2 } };
		int[][] res = MatrixMultiplication.bruteMatrixMultiplication(A, B);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res.length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
