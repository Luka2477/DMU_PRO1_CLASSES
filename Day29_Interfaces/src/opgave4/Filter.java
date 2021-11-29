package opgave4;

public interface Filter {

    static boolean accept(Measurable x) {
        return x.getMeasure() > 5000;
    }

}
