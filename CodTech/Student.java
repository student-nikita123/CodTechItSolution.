import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String rollNumber;
    private Map<String, Integer> marks; // Subject, Mark

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = new HashMap<>();
    }

    // Add or update a mark for a subject
    public void addOrUpdateMark(String subject, int mark) {
        marks.put(subject, mark);
    }

    // Remove a subject mark
    public boolean removeMark(String subject) {
        if (marks.containsKey(subject)) {
            marks.remove(subject);
            return true;
        }
        return false;
    }

    // Calculate overall percentage
    public double calculatePercentage() {
        if (marks.isEmpty()) {
            return 0;
        }
        int total = marks.values().stream().mapToInt(Integer::intValue).sum();
        return (double) total / marks.size();
    }

    // Calculate grade
    public char calculateGrade() {
        double percentage = calculatePercentage();
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }
}
