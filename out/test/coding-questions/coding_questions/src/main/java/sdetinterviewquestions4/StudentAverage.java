package sdetinterviewquestions4;

import java.util.Arrays;
import java.util.List;

public class StudentAverage {
    private String studentName;
    private List<Double> scores;
    private static final double PASSING_AVERAGE = 65.0;
    
    public StudentAverage(String studentName, List<Double> scores) {
        this.studentName = studentName;
        this.scores = scores;
    }
    
    /**
     * Calculates the average of the student's scores
     * @return the average score
     */
    public double calculateAverage() {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (double score : scores) {
            sum += score;
        }
        return sum / scores.size();
    }
    
    /**
     * Determines if the student is ready for the next level
     * @return true if the average score is passing, false otherwise
     */
    public boolean isReadyForNextLevel() {
        return calculateAverage() >= PASSING_AVERAGE;
    }
    
    // Getters and setters
    public String getStudentName() {
        return studentName;
    }
    
    public List<Double> getScores() {
        return scores;
    }
    
    public static void main(String[] args) {
        // Test case 1: Student with passing scores
        StudentAverage student1 = new StudentAverage("John Doe", Arrays.asList(85.5, 90.0, 78.5, 92.5));
        System.out.println("Student: " + student1.getStudentName());
        System.out.println("Scores: " + student1.getScores());
        System.out.printf("Average: %.2f\n", student1.calculateAverage());
        System.out.println("Ready for next level: " + student1.isReadyForNextLevel());
        
        // Test case 2: Student with failing scores
        StudentAverage student2 = new StudentAverage("Jane Smith", Arrays.asList(45.0, 60.5, 55.0, 62.0));
        System.out.println("\nStudent: " + student2.getStudentName());
        System.out.println("Scores: " + student2.getScores());
        System.out.printf("Average: %.2f\n", student2.calculateAverage());
        System.out.println("Ready for next level: " + student2.isReadyForNextLevel());
        
        // Test case 3: Student with no scores
        StudentAverage student3 = new StudentAverage("Alex Johnson", Arrays.asList());
        System.out.println("\nStudent: " + student3.getStudentName());
        System.out.println("Scores: " + student3.getScores());
        System.out.printf("Average: %.2f\n", student3.calculateAverage());
        System.out.println("Ready for next level: " + student3.isReadyForNextLevel());
    }
}
