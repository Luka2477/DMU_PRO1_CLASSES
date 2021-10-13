package opgave5barchart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BarChart {
    private final ArrayList<String> nameList = new ArrayList<>();
    private final ArrayList<Integer> list = new ArrayList<>();

    public void readValues() {
        System.out.println("Indtast navn samt nogle positive tal.  " + "Indtast et negativt tal for at afslutte: ");

        Scanner in = new Scanner(System.in);

        String name = in.nextLine();
        int n = Integer.parseInt(in.nextLine());
        while (n >= 0 && !name.isEmpty()) {
            this.nameList.add(name);
            this.list.add(n);
            name = in.nextLine();
            n = Integer.parseInt(in.nextLine());
        }
    }

    /**
     * Finds and returns the max value in the list.
     *
     * @param list
     *            the list with values.
     * @return the max value found.
     */
    public int findMax(ArrayList<Integer> list) {
        // find max in list
        return Collections.max(list);
    }


    public String findLongest(ArrayList<String> nameList) {
        return Collections.max(nameList, Comparator.comparing(String::length));
    }

    /**
     * Prints out a BarChart of the values using the System.out.println method.
     */
    public void printBarChart() {
        int max = this.findMax(this.list);
        String maxName = this.findLongest(this.nameList);
        // print out bar chart
        for(int i=0; i<this.list.size(); i++)
            System.out.println(
                    this.nameList.get(i)
                    + " ".repeat(maxName.length() - this.nameList.get(i).length() + 5)
                    + "*".repeat(40 * this.list.get(i) / max)
            );
    }
}
