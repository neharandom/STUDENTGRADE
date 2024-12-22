import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentGradeManager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> grades = new HashMap<>();
        
        boolean continueInput = true;

        // Input grades for different subjects or assignments
        while (continueInput) {
            System.out.print("Enter subject/assignment name (or type 'done' to finish): ");
            String subject = scanner.nextLine();
            if (subject.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter grade for " + subject + ": ");
            double grade;
            try {
                grade = Double.parseDouble(scanner.nextLine());
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
                continue;
            }

            grades.put(subject, grade);
        }

        // Calculate average grade
        double total = 0;
        for (double grade : grades.values()) {
            total += grade;
        }
        double average = grades.size() > 0 ? total / grades.size() : 0;

        // Display overall grade information
        System.out.println("\nGrade Summary:");
        for (Map.Entry<String, Double> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f\n", convertToGPA(average));

        scanner.close();
    }

    // Convert average grade to a letter grade
    private static String getLetterGrade(double grade) {
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

    // Convert average grade to GPA
    private static double convertToGPA(double grade) {
        if (grade >= 90) {
            return 4.0;
        } else if (grade >= 80) {
            return 3.0;
        } else if (grade >= 70) {
            return 2.0;
        } else if (grade >= 60) {
            return 1.0;
        } else {
            return 0.0;
        }
    }
}
