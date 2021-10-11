package eksempeldobbelarray;

/**
 * @author mad
 *
 */
public class DobbelArray {
	public void udskrivArray(int[] array) {
		for (int j : array) {
			System.out.print(j + " ");
		}

	}

	public void udskrivArray(int[][] array) {
		for (int[] ints : array) {
			for (int anInt : ints) {
				System.out.print(anInt + "  ");
			}
			System.out.println();
		}
	}

	public void udskrivArray2(int[][] array) {
		int row = 0;
		while (row < array.length) {
			int col = 0;
			while (col < array[row].length) {
				System.out.print(array[row][col] + "  ");
				col++;
			}
			System.out.println();
			row++;
		}

	}

}
