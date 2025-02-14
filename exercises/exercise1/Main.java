package exercise1;
import exercise1.Session;
// Create an instance of Session, populate it with 20 students and dummy scores.
// Call all public methods of Session and capture the output of those methods on console.
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Create a session object
        Session session = new Session();
        Random rand = new Random();

        // Create 10 part-time and 10 full-time students
        for (int i = 1; i <= 10; i++) {
            // Create a part-time student
            PartTimeStudent pStudent = new PartTimeStudent("Part-Time Student " + i);
            // Create a full-time student
            FullTimeStudent fStudent = new FullTimeStudent("Full-Time Student " + i);

            // Assign 15 random quiz scores to both pt and ft students
            for (int j = 0; j < 15; j++) {
                pStudent.addQuizScore(rand.nextInt(100) + 1);
                fStudent.addQuizScore(rand.nextInt(100) + 1);
            }

            // Assign 2 random exam scores to the ft students
            fStudent.addExamScores(rand.nextInt(100) + 1);
            fStudent.addExamScores(rand.nextInt(100) + 1);

            // Add both students to the session
            session.addStudents(pStudent);
            session.addStudents(fStudent);
        }
        // call all methods
        session.getAverageQuizScorePerStudent();
        session.printQuizScoresSorted();
        session.printPartTimeStudents();
        session.printFullTimeStudentExamScores();
    }
}