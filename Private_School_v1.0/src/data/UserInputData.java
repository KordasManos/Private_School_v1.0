package data;


import static ValidationUtil.InputValidation.validateDate;
import static ValidationUtil.InputValidation.validateFloat;
import static ValidationUtil.InputValidation.validateInt;
import static ValidationUtil.InputValidation.validateYesOrNo;
import java.util.ArrayList;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import models.Schoolcourse;
import models.Student;
import models.Trainer;


public class UserInputData extends Database{

    public static Scanner sc = new Scanner(System.in);
    
    
    public static void fillDataFromUserInput(){
        do{
            System.out.println("Create a Course!");
        Schoolcourse sh = new Schoolcourse();
        ArrayList<Trainer> trainers = new ArrayList<Trainer>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();
              sh.setCourse(addCourseFromUserInput());
            
        do{
            System.out.println("Add a Trainer to this Course!");
             trainers.add(addTrainerFromUserInput());
        System.out.println("Do you want to add more Trainers? (Yes or No)");
        
        }while(validateYesOrNo(sc.nextLine()).equals("yes"));
        
        do{
            System.out.println("Add a Student to this Course!");
            students.add(addStudentFromUserInput());
            System.out.println("Do you want to add more Students? (Yes or No)"); 
        
        }while(validateYesOrNo(sc.nextLine()).equals("yes"));
        
        
        do{
            System.out.println("Add an Assignment to this Course!");
            assignments.add(addAssignmentFromUserInput());
            System.out.println("Do you want to add more Assignments? (Yes or No)");
            
        }while(validateYesOrNo(sc.nextLine()).equals("yes"));
         sh.setTrainers(trainers);
         sh.setStudents(students);
         sh.setAssignments(assignments);
         getSchoolcourselist().add(sh);
        System.out.println("Do you want to add more Courses? (Yes or No)");
        }while(validateYesOrNo(sc.nextLine()).equals("yes"));  
    }
    
    public static Course addCourseFromUserInput(){
        System.out.println("Enter Course's details (title,stream,type,start_date(yyyy-MM-dd),end_date(yyyy-MM-dd)): ");
        String[] values = sc.nextLine().split(",");
        Course c = new Course();
        c.setTitle(values[0].trim());
        c.setStream(values[1].trim());
        c.setType(values[2].trim());
        c.setStart_date(validateDate(values[3].trim()));
        c.setEnd_date(validateDate(values[4].trim()));
        getCourselist().add(c);
        return c;
        
    }
    
    public static Trainer addTrainerFromUserInput(){
        System.out.println("Enter Trainer's details (firstName,lastName,subject)");
        String[] values = sc.nextLine().split(",");
        Trainer t = new Trainer();
        t.setFirstName(values[0].trim());
        t.setLastName(values[1].trim());
        t.setSubject(values[2].trim());
        getTrainerlist().add(t);
        return t;
    }
    
    public static Student addStudentFromUserInput(){
        System.out.println("Enter Student's details (firstName,lastName,dateOfBirth(yyyy-MM-dd),tuitionFees)");
        String[] values = sc.nextLine().split(",");
        Student st = new Student();
        st.setFirstName(values[0].trim());
        st.setLastName(values[1].trim());
        st.setDateOfBirth(validateDate(values[2].trim()));
        st.setTuitionFees(validateInt(values[3].trim()));
        getStudentlist().add(st);
        return st;
    }
    
    public static Assignment addAssignmentFromUserInput(){
        System.out.println("Enter Assignment's details (title,description,subDateTime,oralMark(##.##(f.e 19.99)),totalMark(##.##(f.e 19.99)))");
        String[] values = sc.nextLine().split(",");
        Assignment a = new Assignment();
        a.setTitle(values[0].trim());
        a.setDescription(values[1].trim());
        a.setSubDateTime(validateDate(values[2].trim()));
        a.setOralMark(validateFloat(values[3].trim()));
        a.setTotalMark(validateFloat(values[4].trim()));
        getAssignmentlist().add(a);
        return a;
    }
}
