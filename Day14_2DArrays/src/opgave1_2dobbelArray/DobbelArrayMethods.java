package opgave1_2dobbelArray;

import java.util.Arrays;

/**
 * @author mad
 *
 */
public class DobbelArrayMethods {

	public void udskrivArray(int[][] array) {
		for (int[] ints : array) {
			for (int anInt : ints) {
				System.out.print(anInt + "  ");
			}
			System.out.println();
		}
	}

	// Opgave 1.1
	public  int getValueAt(int[][] numbers, int row, int col){
		// returner værdien på plads (row,col) i numbers
		return numbers[row][col];
	}

	// Opgave 1.2
	public  void setValueAt(int[][] numbers, int row, int col, int value){
		// opdater pladsen (row,col) i numbers til value
		numbers[row][col] = value;
	}

	// Opgave 1.3
	public  int sumRow(int[][] numbers, int row) {
		// returner summen af tallene i rækken row
		return Arrays.stream(numbers[row]).sum();
	}

	// Opgave 1.4
	public  int sumCol(int[][] numbers, int col) {
		// returner summen af tallene i kolonnen col
		int sum = 0;
		for(int[] row : numbers)
			sum += row[col];
		return sum;
	}

	// Opgave 1.5
	public  int sum(int[][] numbers) {
		// returnerer summen af alle tallene i numbers
		int sum = 0;
		for(int[] row : numbers)
			sum += Arrays.stream(row).sum();
		return sum;
	}

}
