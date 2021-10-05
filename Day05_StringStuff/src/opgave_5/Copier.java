package opgave_5;

public class Copier {
    private int paper = 0;
    private boolean paperStuck = false;

    public Copier() {}

    public Copier(int paper) {
        this.paper = paper;
    }

    public void insertPaper(int paper) {
        if(this.paper + paper <= 500) this.paper += paper;
        else System.out.printf(
                "You tried to insert %d pieces of paper, but there is only room for %d!%n",
                paper,
                500 - this.paper
        );
    }

    public int getPaper() {
        return this.paper;
    }

    public void makeCopy() {
        if(this.paperStuck) {
            System.out.println("There is paper stuck in the machine!");
            return;
        }

        if(this.paper > 0) this.paper--;
        else System.out.println("There is no more paper!");
    }

    public void makeCopy(int copies) {
        if(this.paperStuck) {
            System.out.println("There is paper stuck in the machine!");
            return;
        }

        if(this.paper - copies > 0) this.paper -= copies;
        else System.out.printf(
                "You tried to print %d copies, but there is only %d pieces of paper left!%n",
                copies,
                this.paper
        );
    }

    public void makePaperJam() {
        this.paperStuck = true;
    }

    public void fixJam() {
        this.paperStuck = false;
    }
}
