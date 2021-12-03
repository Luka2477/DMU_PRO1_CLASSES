package opgave5;

import java.util.ArrayList;

public class Measurement {

    private long testSize;

    private ArrayList<String> measurementNames = new ArrayList<>();
    private ArrayList<Long> measurements = new ArrayList<>();

    public Measurement(long testSize) {
        this.testSize = testSize;
    }

    public void addMeasurement (String name, long measurement) {
        this.measurementNames.add(name);
        this.measurements.add(measurement);
    }

    @Override
    public String toString () {
        StringBuilder returnStr = new StringBuilder(String.format("Test size: %d%n", this.testSize));
        for (int i = 0; i < this.measurementNames.size(); i++) {
            returnStr.append(String.format("%15s -- Total time in milliseconds: %4d | Milliseconds per element: %.4f%n",
                    this.measurementNames.get(i).toUpperCase(),
                    this.measurements.get(i),
                    (double) this.measurements.get(i) / this.testSize));
        }
        return returnStr.toString();
    }
}
