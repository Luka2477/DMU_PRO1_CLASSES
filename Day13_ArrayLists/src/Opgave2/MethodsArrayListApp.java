package Opgave2;

import java.util.ArrayList;

public class MethodsArrayListApp {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(19);
		list.add(35);
		list.add(14);
		list.add(7);
		MethodsArrayList methods = new MethodsArrayList();
		System.out.println(list);
		System.out.println("Summen af tallene i listen med for "
				+ methods.sumListe(list));
		System.out.println("Summen af tallene i listen med forEach "
				+ methods.sumListe2(list));

		System.out.println("Indeks for det første lige tal: "
				+ methods.hasEvenAtIndex(list));

		System.out.println("Minimum af tallene i listen er "
				+ methods.min(list));

		System.out.println("Gennemsnit af tallene i listen er "
				+ methods.average(list));

		System.out.println("Antallet af 0er af tallene i listen er "
				+ methods.countZeros(list));

		methods.swapEvenWithZero(list);
		System.out.println("Erstat alle lige tal i listen "
				+ list);

		System.out.println("List med alle lige tal i listen "
				+ methods.aEvenList(list));
	}

}
