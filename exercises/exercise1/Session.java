package exercise1;
// hold 20 students in a Session, some are part-time, some are full-time
import java.util.ArrayList;
import java.util.Collections;

class Session {
    private ArrayList<Student> students; // store student's Arraylist

    // constructor
    public Session() {
        this.students = new ArrayList<>();
    }

    // method -> add student to session, no more than 20 students, no return
    public void addStudents(Student student) { // PartTimeStudent or FullTimeStudent
        if (students.size() < 20) {
            students.add(student);
        } else {
            System.out.println("The student limit of 20 has been reached, no new students can be added" + student.getName());
        }
    }

    // method
    public void getAverageQuizScorePerStudent() {
        System.out.println("\nAverage quiz scores of students: ");
        for (Student student : students) {
            System.out.println(student.getName() + "'s average quiz score: " + student.getAvgQuizScore());
        }
    }

    // method -> print quiz socre in ascending order
    public void printQuizScoresSorted() {
        System.out.println("\nquiz score： ");
        for (Student student : students) {
            ArrayList<Integer> sortedScores = new ArrayList<>(student.getQuizScores());
            Collections.sort(sortedScores); // 升序排列
            System.out.println(student.getName() + "'s quiz score: " + sortedScores);
        }
    }

    // method -> print part-time students name
    public void printPartTimeStudents() {
        System.out.println("\nPart-time Students:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.getName());
            }
        }
    }

    // method -> print the exam scroe of full time students
    public void printFullTimeStudentExamScores() {
        System.out.println("\nFull-time Students' Exam Scores:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                // Type cast the student to FullTimeStudent to access examScores method
                FullTimeStudent fullTimeStudent = (FullTimeStudent) student;
                System.out.println(fullTimeStudent.getName() + "'s exam scores: " + fullTimeStudent.getExamScores());
            }
        }
    }

}