package opgave5;

import java.util.ArrayList;
import java.util.Collections;

public class SortTester {

    public static void main(String[] args) {

        ArrayList<Measurement> measurements = new ArrayList<>();

        int testSize = 25000;
        ArrayList<String> bigList = ListGenerator.generateString(testSize, 15);
        String[] bigArray1 = bigList.toArray(new String[0]);
        String[] bigArray2 = bigList.toArray(new String[0]);
        String[] bigArray3 = bigList.toArray(new String[0]);

        Measurement m1 = new Measurement(testSize);
        measurements.add(m1);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        m1.addMeasurement("bubbleSort", Measurer.durationMilliSeconds());

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        m1.addMeasurement("insertionSort", Measurer.durationMilliSeconds());

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        m1.addMeasurement("selectionSort", Measurer.durationMilliSeconds());

        // Collections.sort Test
        Measurer.start();
        Collections.sort(bigList);
        Measurer.stop();
        m1.addMeasurement("collectionSort", Measurer.durationMilliSeconds());

        testSize = 15000;
        bigList = ListGenerator.generateString(testSize, 15);
        bigArray1 = bigList.toArray(new String[0]);
        bigArray2 = bigList.toArray(new String[0]);
        bigArray3 = bigList.toArray(new String[0]);

        Measurement m2 = new Measurement(testSize);
        measurements.add(m2);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        m2.addMeasurement("bubbleSort", Measurer.durationMilliSeconds());

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        m2.addMeasurement("insertionSort", Measurer.durationMilliSeconds());

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        m2.addMeasurement("selectionSort", Measurer.durationMilliSeconds());

        // Collections.sort Test
        Measurer.start();
        Collections.sort(bigList);
        Measurer.stop();
        m2.addMeasurement("collectionSort", Measurer.durationMilliSeconds());

        testSize = 5000;
        bigList = ListGenerator.generateString(testSize, 15);
        bigArray1 = bigList.toArray(new String[0]);
        bigArray2 = bigList.toArray(new String[0]);
        bigArray3 = bigList.toArray(new String[0]);

        Measurement m3 = new Measurement(testSize);
        measurements.add(m3);

        // Bubble Sort Test
        Measurer.start();
        SortMethods.bubbleSort(bigArray1);
        Measurer.stop();
        m3.addMeasurement("bubbleSort", Measurer.durationMilliSeconds());

        // Insertion Sort Test
        Measurer.start();
        SortMethods.insertionSort(bigArray2);
        Measurer.stop();
        m3.addMeasurement("insertionSort", Measurer.durationMilliSeconds());

        // Selection Sort Test
        Measurer.start();
        SortMethods.selectionSort(bigArray3);
        Measurer.stop();
        m3.addMeasurement("selectionSort", Measurer.durationMilliSeconds());

        // Collections.sort Test
        Measurer.start();
        Collections.sort(bigList);
        Measurer.stop();
        m3.addMeasurement("collectionSort", Measurer.durationMilliSeconds());

        for (Measurement measurement : measurements) {
            System.out.println(measurement);
        }

    }

}
