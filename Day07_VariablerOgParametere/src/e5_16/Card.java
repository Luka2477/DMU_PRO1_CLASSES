package e5_16;

import java.util.Arrays;

public class Card {
    private final String notation;

    public Card(String notation) {
        this.notation = notation;
    }

    public String getDescription() {
        String[] notationList = "A,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
        String[] notationsExpandedList = "Ace,2,3,4,5,6,7,8,9,10,_,Jack,Queen,King".split(",");
        String[] typeList = "D,H,S,C".split(",");
        String[] typesExpandedList = "Diamonds,Hearts,Spades,Clubs".split(",");
        String[] notation = this.notation.split(" ");

        if(Arrays.asList(notationList).contains(notation[0]) && Arrays.asList(typeList).contains(notation[1]))
            return notationsExpandedList[String.join("", notationList).indexOf(notation[0])] + " of " + typesExpandedList[String.join("", typeList).indexOf(notation[1])];

        return "Unknown";
    }
}
