package opgave1;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        String[] s = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        System.out.println(Arrays.toString(s));
        BubbleSort.sort(s);
        System.out.println(Arrays.toString(s));
    }

}
