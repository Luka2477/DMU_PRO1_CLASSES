package p7_2;

public class Main {
    private int roll() {
        return (int)(1 + Math.round(Math.random() * 5));
    }

    public int[] generateRolls(int amount) {
        int[] rolls = new int[amount];

        for(int i=0; i<amount; i++)
            rolls[i] = this.roll();

        return rolls;
    }

    public static void main(String[] args) {
        int[] rolls = new Main().generateRolls(20);
        boolean inRun = false;

        for(int i=1; i<rolls.length-1; i++) {
            if(inRun) {
                if(rolls[i] != rolls[i-1]) {
                    System.out.print(") ");
                    inRun = false;
                }
            } else {
                if (rolls[i] == rolls[i + 1]) {
                    System.out.print("( ");
                    inRun = true;
                }
            }

            System.out.print(rolls[i] + " ");
        }

        if(inRun)
            System.out.println(")");
    }
}
