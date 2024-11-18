import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define weights for each grade component
        final double ASSIGNMENT_WEIGHT = 0.3;
        final double QUIZ_WEIGHT = 0.2;
        final double MIDTERM_WEIGHT = 0.2;
        final double FINAL_EXAM_WEIGHT = 0.3;

        // Collect grades for different components
        double assignmentGrade = collectGrades(scanner, "assignment", 5);
        double quizGrade = collectGrades(scanner, "quiz", 3);
        double midtermGrade = collectSingleGrade(scanner, "midterm exam");
        double finalExamGrade = collectSingleGrade(scanner, "final exam");

        // Calculate the final grade
        double finalGrade = (assignmentGrade * ASSIGNMENT_WEIGHT) +
                (quizGrade * QUIZ_WEIGHT) +
                (midtermGrade * MIDTERM_WEIGHT) +
                (finalExamGrade * FINAL_EXAM_WEIGHT);

        // Display the final grade and letter grade
        System.out.printf("Your final grade is: %.2f\n", finalGrade);
        System.out.println("Letter Grade: " + getLetterGrade(finalGrade));

        scanner.close();
    }


    public static double collectGrades(Scanner scanner, String component, int count) {
        double total = 0.0;

        System.out.println("Enter your grades for " + count + " " + component + "(s):");
        for (int i = 1; i <= count; i++) {
            System.out.print(component + " " + i + " grade (0-100): ");
            double grade = scanner.nextDouble();
            total += grade;
        }

        // Calculate and return the average grade for the component
        return total / count;
    }


    public static double collectSingleGrade(Scanner scanner, String component) {
        System.out.print("Enter your " + component + " grade (0-100): ");
        return scanner.nextDouble();
    }


    public static String getLetterGrade(double grade) {
        if (grade >= 90) {
            return "A";
        } else if (grade >= 80) {
            return "B";
        } else if (grade >= 70) {
            return "C";
        } else if (grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
