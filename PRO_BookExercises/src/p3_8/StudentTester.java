package p3_8;

public class StudentTester {
    public static void main(String[] args) {
        Student student = new Student("Lukas");
        System.out.printf("Name: %s | Total score: %d | Average score: %d%n", student.getName(), student.getTotalScore(), student.getAverageScore());

        student.addQuiz(10);
        System.out.printf("Name: %s | Total score: %d | Average score: %d%n", student.getName(), student.getTotalScore(), student.getAverageScore());

        student.addQuiz(30);
        System.out.printf("Name: %s | Total score: %d | Average score: %d%n", student.getName(), student.getTotalScore(), student.getAverageScore());
    }
}
