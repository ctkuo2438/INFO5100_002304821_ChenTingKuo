package exercise1;
import java.util.ArrayList;
class FullTimeStudent extends Student {
    private ArrayList<Integer> examScores; // save 2 exam scores, Field

    // constructor
    public FullTimeStudent(String name) {
        super(name); // call student consturctor
        this.examScores = new ArrayList<>();
    }

    // method -> add two exam scores, no return
    public void addExamScores(int score) {
        if (examScores.size() < 2) {
            examScores.add(score);
        } else {
            System.out.println(name + "There are already 2 exam scores, cannot add new ones!");
        }
    }

    // method -> get exam score
    public ArrayList<Integer> getExamScores() {
        return examScores;
    }
}