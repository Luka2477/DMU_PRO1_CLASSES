package opgave3;

public class App {

    public static boolean subsequentChars (String s, int k) {
        int count = 1;
        char character = s.charAt(0);
        int i = 1;

        while (i < s.length() && count != k) {
            if (character == s.charAt(i)) {
                count++;
            } else {
                character = s.charAt(i);
                count = 1;
            }

            i++;
        }

        return count == k;
    }

    public static void main(String[] args) {
        System.out.println("'Jubiiii', 4 | " + subsequentChars("Jubiiii", 4));
        System.out.println("'Jubiiii', 5 | " + subsequentChars("Jubiiii", 5));
    }

}
