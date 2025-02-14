package exercise1;
import java.util.ArrayList;

abstract class Student {
    // field
    protected String name;
    protected ArrayList<Integer> quizScores;

    // constructor
    public Student(String name) {
        this.name = name;
        this.quizScores = new ArrayList<>();
    }
    // method
    public void addQuizScore(int score) {
        if (quizScores.size() < 15) {
            quizScores.add(score);
        } else {
            System.out.println(name + "There are already 15 test scores, no new ones can be added");
        }
    }

    public double getAvgQuizScore() {
        if (quizScores.isEmpty()) return 0;
        int sum = 0;
        for (int score: quizScores) {
            sum += score;
        }
        return sum / (double) quizScores.size();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getQuizScores() {
        return quizScores;
    }
}