package p3_8;

public class Student {
    final private String name;
    private int score;
    private int quizzsTaken;

    public Student(String name) {
        this.name = name;
        this.score = 0;
        this.quizzsTaken = 0;
    }

    public String getName() { return this.name; }

    public void addQuiz(int score) {
        this.score += score;
        this.quizzsTaken++;
    }

    public int getTotalScore() { return this.score; }

    public int getAverageScore() { return this.score / (this.quizzsTaken | 1); }
}
