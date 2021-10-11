package opgave3Teater;

public class TheaterFloor {
	int[][] seats = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
			{ 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
			{ 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
			{ 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };

	/**
	 * Hvis plads seat på række row er ledig reserveres pladsen og prisen på pladsen
	 * returneres. Der returneres 0 hvis pladsen er optaget.
	 *
	 * @param row something
	 * @param seat something
	 * @return something
	 */

	public int buySeat(int row, int seat) {
		int price = 0;

		if(this.seats[row][seat] != 0) {
			price = this.seats[row][seat];
			this.seats[row][seat] = 0;
		}

		return price;
	}

	/**
	 * Hvis der er en plads ledig med den pågældende pris, reserveres pladsen og
	 * prisen returneres. Der returneres 0, hvis der ikke er nogen pladser ledige
	 * til den pågældende pris.
	 *
	 * @param price something
	 * @return something
	 */
	public int buySeat(int price) {
		for(int i=0; i<this.seats.length; i++)
			for(int j=0; j<this.seats[i].length; j++)
				if(this.seats[i][j] == price) {
					this.seats[i][j] = 0;
					return price;
				}
		return 0;
	}

	public void printTheaterFloor() {
		System.out.print("   Sæde : ");
		for (int i = 1; i <= this.seats[0].length; i++)
			System.out.print(((i > 9) ? Integer.toString(i) : " " + i) + "  ");
		System.out.println();

		for (int i = 0; i < this.seats.length; i++) {
			System.out.print("Række " + i + " : ");
			for (int j = 0; j < this.seats[i].length; j++)
				System.out.print(this.seats[i][j] + ((j != this.seats[i].length - 1) ? ", " : ""));
			System.out.println();
		}
	}
}
