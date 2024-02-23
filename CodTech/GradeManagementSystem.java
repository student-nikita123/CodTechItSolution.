import java.util.HashMap;
import java.util.Map;

public class GradeManagementSystem {
    private Map<String, Student> students; 

    public GradeManagementSystem() {
        students = new HashMap<>();
    }

    // Add a new student
    public void addStudent(Student student) {
        students.put(student.getRollNumber(), student);
    }

    // Update a student's information
    public boolean updateStudentMarks(String rollNumber, String subject, int mark) {
        if (students.containsKey(rollNumber)) {
            students.get(rollNumber).addOrUpdateMark(subject, mark);
            return true;
        }
        return false;
    }

    // Delete a student
    public boolean deleteStudent(String rollNumber) {
        if (students.containsKey(rollNumber)) {
            students.remove(rollNumber);
            return true;
        }
        return false;
    }

    // Print student grades and percentages
    public void printStudentGrades() {
        students.forEach((rollNumber, student) -> {
            System.out.println("Student Roll Number: " + rollNumber + ", Name: " + student.getName() +
                    ", Percentage: " + student.calculatePercentage() + "%, Grade: " + student.calculateGrade());
        });
    }

    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();

        // Sample students
        Student alice = new Student("Alice", "1");
        alice.addOrUpdateMark("Math", 92);
        alice.addOrUpdateMark("Science", 88);

        Student bob = new Student("Bob", "2");
        bob.addOrUpdateMark("Math", 76);
        bob.addOrUpdateMark("Science", 85);

        // Adding students to the system
        system.addStudent(alice);
        system.addStudent(bob);

        // Updating a student's mark
        system.updateStudentMarks("1", "Math", 95);

        // Deleting a student
        // system.deleteStudent("2");

        // Printing student grades
        system.printStudentGrades();
    }
}


