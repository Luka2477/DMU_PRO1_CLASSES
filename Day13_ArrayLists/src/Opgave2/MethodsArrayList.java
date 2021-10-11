package Opgave2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MethodsArrayList {
    
    /**
     *
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
        	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a forEach loop
    */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }
    
    /**
     *
     * @param list
     * @return index at the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
        
    }

    public int min(ArrayList<Integer> list) {
        return Collections.min(list);
    }

    public double average(ArrayList<Integer> list) {
        return (double) list.stream().mapToInt(Integer::intValue).sum() / list.toArray().length;
    }

    public int countZeros(ArrayList<Integer> list) {
        return Collections.frequency(list, 0);
    }

    public void swapEvenWithZero(ArrayList<Integer> list) {
        list.replaceAll(element -> (element % 2 == 0) ? 0 : element);
    }

    public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int num : list)
            if(num % 2 == 0)
                result.add(num);
        return result;
    }
}
