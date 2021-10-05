package studerende;

public class StuderendeApp {

    public static void main(String[] args) {
        Studerende s1 = new Studerende("Jens", 19, true);
        System.out.println(s1.getAlder() + " : " + s1.arbejde());
        s1.foedselsdag();
        System.out.println(s1.getAlder() + " : " + s1.arbejde());
        s1.foedselsdag();
        s1.foedselsdag();
        s1.foedselsdag();
        System.out.println(s1.getAlder() + " : " + s1.arbejde());

    }

}
