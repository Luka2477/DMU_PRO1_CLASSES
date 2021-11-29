package opgave4;

public abstract class Data {

    public static Measurable max (Measurable[] objects) {
        double max = 0.0;
        Measurable maxMeasurable = null;
        for (Measurable measurable : objects) {
            if (Filter.accept(measurable)) {
                if (measurable.getMeasure() > max) {
                    max = measurable.getMeasure();
                    maxMeasurable = measurable;
                }
            }
        }
        return maxMeasurable;
    }

    public static double avg (Measurable[] objects) {
        double sum = 0.0;
        for (Measurable measurable : objects) {
            if (Filter.accept(measurable)) {
                sum += measurable.getMeasure();
            }
        }
        return sum / objects.length;
    }

}
