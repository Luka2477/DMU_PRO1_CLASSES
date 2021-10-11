package opgave1_2dobbelArray;

public class Opgave2DobbelArray {

    public static void main(String[] args) {
        final int ROW = 8;
        final int COL = 8;
        int[][] values = new int[ROW][COL];
        DobbelArrayMethods da = new DobbelArrayMethods();

        //Udskriv values på tabel form
        da.udskrivArray(values);
        

        // Opgave 2.1  lav ændringer i values så der står 5 på alle pladser
        for(int i=0; i<values.length; i++)
            for(int j=0; j<values[i].length; j++)
                da.setValueAt(values, i, j, 5);
        
        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 på alle pladser");
        System.out.println();
        da.udskrivArray(values);
        
        // Opgave 2.2  lav ændringer i values så der står 2 i lige rækker og 3 i ulige
        for(int i=0; i<values.length; i++)
            for(int j=0; j<values[i].length; j++)
                da.setValueAt(values, i, j, (i % 2 == 0) ? 2 : 3);

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden række");
        System.out.println();
        da.udskrivArray(values);
        
        // Opgave 2.3  lav ændringer i values så der står 2 i lige søjler og 3 i ulige
        for(int i=0; i<values.length; i++)
            for(int j=0; j<values[i].length; j++)
                da.setValueAt(values, i, j, (j % 2 == 0) ? 2 : 3);

        System.out.println();
        System.out.println("Nedenfor skulle der stå 2 og 3 på hver anden søjle");
        System.out.println();
        da.udskrivArray(values);
        
        
        // Opgave 2.4 lav ændringer i values så den har skiftende 0'er og 1'er som på et skakbræt
        for(int i=0; i<values.length; i++)
            for(int j=0; j<values[i].length; j++)
                da.setValueAt(values, i, j, (i % 2 == 0) ? j % 2 : (j + 1) % 2);

        System.out.println();
        System.out.println("Nedenfor skulle der stå 0 og 1 på alle pladser som på skakbræt");
        System.out.println();
        da.udskrivArray(values);

        // Opgave 2.5 lav ændringer så alle elementer i nederste og øverste række samt første
        // og sidste søjle er 5 og resten skal være 2.
        for(int i=0; i<values.length; i++)
            for(int j=0; j<values[i].length; j++)
                da.setValueAt(values, i, j, (i == 0 || i == values.length - 1 || j == 0 || j == values[i].length - 1) ? 5 : 2);

        System.out.println();
        System.out.println("Nedenfor skulle der stå 5 i kanten og 2 ellers");
        System.out.println();
        da.udskrivArray(values);


    }



}
