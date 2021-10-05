package p7_3;

import java.util.ArrayList;

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
        ArrayList<String> characters = new ArrayList<>();
        int longestRunStartIndex = 0;
        int longestRunEndIndex = 0;
        int tempLRSI = 0;
        int runLength = 0;

        for(int i=0; i<rolls.length-1; i++) {
            characters.add(Integer.toString(rolls[i]));

            if(rolls[i] == rolls[i+1]) {
                if(!inRun) {
                    tempLRSI = i;
                    inRun = true;
                }

                if(i == rolls.length-2) {
                    longestRunStartIndex = tempLRSI;
                    longestRunEndIndex = i+1;
                }

                runLength++;
            } else if(inRun) {
                if(runLength > longestRunEndIndex - longestRunStartIndex) {
                    longestRunStartIndex = tempLRSI;
                    longestRunEndIndex = i;
                }
                runLength = 0;
                inRun = false;
            }
        }
        characters.add(Integer.toString(rolls[rolls.length-1]));

        characters.add(longestRunStartIndex, "(");
        characters.add(longestRunEndIndex+2, ")");

        System.out.println(String.join(" ", characters));
        System.out.println("IT WORKS!");
    }
}
