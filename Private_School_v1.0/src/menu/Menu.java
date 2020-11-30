package menu;

import ValidationUtil.InputValidation;
import static ValidationUtil.InputValidation.compareIntToSchListSize;
import static ValidationUtil.InputValidation.compareIntToStudListSize;
import static ValidationUtil.InputValidation.validateYesOrNo;
import data.Database;
import static data.Database.getSchoolcourselist;
import static data.Database.getStudentlist;
import data.SyntheticData;
import data.UserInputData;
import java.util.Scanner;

public class Menu {

    public static Scanner sc = new Scanner(System.in);

    public static void menuDisplay() {
        System.out.println("Welcome to our private school app. Do you want to input manually all the data?:     Yes or No");

        if (validateYesOrNo(sc.nextLine()).equals("no")) {
            SyntheticData.FillDataFromSynthetic();
        } else {
            UserInputData.fillDataFromUserInput();

        }
        System.out.println("Database is complete.");
        int option;
        do {
            allFunctions();
         

            
            option = InputValidation.validateInt(sc.next());
            switch (option) {
                case 1:
                    Database.printAllStudents();
                    break;
                case 2:
                    Database.printAllTrainers();
                    break;
                case 3:
                    Database.printAllAssignments();
                    break;
                case 4:
                    Database.printAllCourses();
                    break;
                case 5:
                    System.out.println("Choose a Course from the list by pressing the matching number(1 for the 1st course ...etc):");
                    Database.printAllCourses();
                    int xl = compareIntToSchListSize(InputValidation.validateInt(sc.next()));
                    Database.printStudentsPerSchoolcourse(getSchoolcourselist().get(xl - 1));
                    break;
                case 6:
                    System.out.println("Choose a Course from the list by pressing the matching number(1 for the 1st course ...etc):");
                    Database.printAllCourses();
                    int x2 = compareIntToSchListSize(InputValidation.validateInt(sc.next()));
                    Database.printTrainersPerSchoolcourse(getSchoolcourselist().get(x2- 1));
                    break;
                case 7:
                    System.out.println("Choose a Course from the list by pressing the matching number(1 for the 1st course ...etc):");
                    Database.printAllCourses();
                    int x3 = compareIntToSchListSize(InputValidation.validateInt(sc.next()));
                    Database.printAssignmentsPerSchoolcourse(getSchoolcourselist().get(x3 - 1));
                    break;
                case 8:
                    System.out.println("Choose a Student from the list by pressing the matching number(1 for the 1st student ...etc):");
                    Database.printAllStudents();
                    int x4 = compareIntToStudListSize(InputValidation.validateInt(sc.next()));
                    Database.printAssignmentsPerStudent(getStudentlist().get(x4 - 1));
                    break;
                case 9:
                    Database.printStudentsInMultiCourse();
                    break;
                case 10:
                    Database.findStudentsWithPendingAssByDate();
                    break;
                default:
                    System.out.println("Invalid Number! Please try again.");
                    break;
            }
        } while (option != 0);

    }

    public static void allFunctions() {

        System.out.println("\n");
        System.out.println("\nPress 1 to display the Student list");
        System.out.println("\nPress 2 to display the Trainer list");
        System.out.println("\nPress 3 to display the Assignment list");
        System.out.println("\nPress 4 to display the Course list");
        System.out.println("\nPress 5 to display all the Students for a Course");
        System.out.println("\nPress 6 to display all the Trainers for a Course");
        System.out.println("\nPress 7 to display all the Assignments for a Course");
        System.out.println("\nPress 8 to display all the Assignments for a Student");
        System.out.println("\nPress 9 to display all the Students that belong to more than one Courses");
        System.out.println("\nPress 10 to display all the Students who need to submit one or more assignments on the same calendar week as the given date");
        System.out.println("\nPress 0 to Exit");
    }
}
