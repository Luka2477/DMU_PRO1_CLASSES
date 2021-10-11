package opgave3Teater;

import java.awt.*;
import java.util.Scanner;

public class TheaterFloorApp {

	public static void main(String[] args) {
		TheaterFloor theater = new TheaterFloor();
		Scanner scanner = new Scanner(System.in);

		theater.printTheaterFloor();

		System.out.print("Vil du købe til en bestemt (pris) eller (plads)? ");
		String answer = scanner.nextLine();

		if(answer.equalsIgnoreCase("pris")) {
			System.out.print("Venligst indtaste prisen: ");
			int price = Integer.parseInt(scanner.nextLine());
			int result = theater.buySeat(price);
			System.out.println((result == 0) ? "Der er ingen pladser ledig til " + price + "kr." : "Du har reserveret en plads til " + price + "kr.");
		} else {
			System.out.print("Venligst indtaste rækken og sædet du vil side på (1,3): ");
			String[] seat = scanner.nextLine().split(",");
			int row = Integer.parseInt(seat[0]);
			int col = Integer.parseInt(seat[1]);
			int result = theater.buySeat(row, col);
			System.out.println((result == 0) ? "Pladsen på " + row + ", " + col + " er ikke ledig." : "Du har reserveret pladsen på " + row + ", " + col + " til " + result + "kr.");
		}

		theater.printTheaterFloor();
	}
}
