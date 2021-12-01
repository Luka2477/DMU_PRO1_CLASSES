package opgave1_2_3_5_6_7;

import java.util.ArrayList;
import java.util.Arrays;

public class SoegningApp {

	 
	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		System.out.println();

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7

		int[] talArray2 = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println("Er der et tal mellem 10 - 15 ? " + s.findiInterval(talArray2, 10, 15));
		System.out.println("Er der et tal mellem 15 - 20 ? " + s.findiInterval(talArray2, 15, 20));
		System.out.println();

		int[] talArray3 = {7, 9, 13, 7, 9, 13};
		System.out.println("Er der to tal ved siden af hinanden ? " + s.findToSammen(talArray3));
		talArray3[2] = 9;
		System.out.println("Er der to tal ved siden af hinanden ? " + s.findToSammen(talArray3));
		System.out.println();

		System.out.println("Største heltal af kvadratrod for 15 linær: " + s.beregnKvadratrodLinær(15));
		System.out.println("Største heltal af kvadratrod for 16 linær: " + s.beregnKvadratrodLinær(16));
		System.out.println("Største heltal af kvadratrod for 35 linær: " + s.beregnKvadratrodLinær(35));
		System.out.println();

		System.out.println("Største heltal af kvadratrod for 15 binær: " + s.beregnKvadratrodBinær(15));
		System.out.println("Største heltal af kvadratrod for 16 binær: " + s.beregnKvadratrodBinær(16));
		System.out.println("Største heltal af kvadratrod for 35 binær: " + s.beregnKvadratrodBinær(35));
		System.out.println();

		ArrayList<Integer> talList = new ArrayList<>(Arrays.asList(6, 4, 8, 13, 2));
		System.out.println("Listen før søgning efter 13:");
		System.out.println(talList);
		System.out.println("Listen efter søgning efter 13:");
		int index = s.find(talList, 13);
		System.out.println(talList);
		System.out.println("Index for 13 er: " + index);
	}

}
