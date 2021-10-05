package opgave_5;

public class CopierTester {
    public static void main(String[] args) {
        Copier copier = new Copier();
        System.out.println(copier.getPaper());
        copier.makeCopy();
        copier.insertPaper(100);
        System.out.println(copier.getPaper());
        copier.makeCopy();
        System.out.println(copier.getPaper());

        copier.insertPaper(600);
        copier.makeCopy(200);
        copier.makePaperJam();
        copier.makeCopy();
        copier.fixJam();
        copier.makeCopy();
        System.out.println(copier.getPaper());
    }
}
