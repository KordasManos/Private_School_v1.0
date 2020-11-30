package data;

import java.time.LocalDate;
import java.util.ArrayList;
import models.Assignment;
import models.Course;
import models.Schoolcourse;
import models.Student;
import models.Trainer;


public class SyntheticData extends Database{

    public static void addCourseFromSynthetic(){
      Course c1 = new Course("CB12","Java","Full Time",LocalDate.parse("2020-01-01"),LocalDate.parse("2020-07-01"));
      Course c2 = new Course("CB12","C#","Full Time",LocalDate.parse("2020-01-15"),LocalDate.parse("2020-07-15"));
      Course c3 = new Course("CB12","Python","Full Time",LocalDate.parse("2020-02-01"),LocalDate.parse("2020-08-01"));
      getCourselist().add(c1);
      getCourselist().add(c2);
      getCourselist().add(c3);
    }
    
    public static void addTrainerFromSynthetic(){
    Trainer t1 = new Trainer("Panagiwths","Magkas","Java");
    Trainer t2 = new Trainer("Mixalis","Papadopoulos","C#");
    Trainer t3 = new Trainer("Maria","Spyropoulou","Python");
    getTrainerlist().add(t1);
    getTrainerlist().add(t2);
    getTrainerlist().add(t3);
    }

    public static void addStudentFromSynthetic(){
    Student s1 = new Student("George", "Tsoupis", LocalDate.parse("1999-10-08"), 2500);
    Student s2 = new Student("Katerina", "Kabalou", LocalDate.parse("2000-07-17"), 1700);
    Student s3 = new Student("Lefteris", "Lolos", LocalDate.parse("1996-12-29"), 1850);
    Student s4 = new Student("Xristina", "Mpellou", LocalDate.parse("1998-10-06"), 2500);
    Student s5 = new Student("Tasos", "Tsantas", LocalDate.parse("1999-09-22"), 2500);
    Student s6 = new Student("Maria", "Mpakogianni", LocalDate.parse("1991-08-19"), 1850);
    getStudentlist().add(s1);
    getStudentlist().add(s2);
    getStudentlist().add(s3);
    getStudentlist().add(s4);
    getStudentlist().add(s5);
    getStudentlist().add(s6);
    }
    
    public static void addAssignmentFromSynthetic(){
    Assignment a1 = new Assignment("Java Project A Part A", "Foundation", LocalDate.parse("2020-02-21"), 20.0f, 80.0f);
    Assignment a2 = new Assignment("C# Project A Part A", "Foundation", LocalDate.parse("2020-03-16"), 20.0f, 80.0f);
    Assignment a3 = new Assignment("Python Project A Part A", "Foundation", LocalDate.parse("2020-03-18"), 20.0f, 80.0f);
    Assignment a4 = new Assignment("Java Project A Part B", "Advanced", LocalDate.parse("2020-06-11"), 20.0f, 80.0f);
    Assignment a5 = new Assignment("C# Project A Part B", "Advanced", LocalDate.parse("2020-05-09"), 20.0f, 80.0f);
    Assignment a6 = new Assignment("Python Project A Part B", "Advanced", LocalDate.parse("2020-07-27"), 20.0f, 80.0f);
    getAssignmentlist().add(a1);
    getAssignmentlist().add(a2);
    getAssignmentlist().add(a3);
    getAssignmentlist().add(a4);
    getAssignmentlist().add(a5);
    getAssignmentlist().add(a6);
    }
    
    public static void addSchoolcourseFromSynthetic(){
    
        Schoolcourse sc1 = new Schoolcourse();
        sc1.setCourse(getCourselist().get(0));
        sc1.setTrainers(getTrainerlist().subList(0, 1));
        sc1.setStudents(getStudentlist().subList(0, 2));
        ArrayList<Assignment> ass1 = new ArrayList<>(); 
        ass1.add(getAssignmentlist().get(0));
        ass1.add(getAssignmentlist().get(3));
        sc1.setAssignments(ass1);
        getSchoolcourselist().add(sc1);
        
        Schoolcourse sc2 = new Schoolcourse();
        sc2.setCourse(getCourselist().get(1));
        sc2.setTrainers(getTrainerlist().subList(1, 2));
        sc2.setStudents(getStudentlist().subList(2, 5));
        ArrayList<Assignment> ass2 = new ArrayList<>();
        ass2.add(getAssignmentlist().get(1));
        ass2.add(getAssignmentlist().get(4));
        sc2.setAssignments(ass2);
        getSchoolcourselist().add(sc2);
        
        Schoolcourse sc3 = new Schoolcourse();
        sc3.setCourse(getCourselist().get(2));
        sc3.setTrainers(getTrainerlist().subList(2, 3));
        sc3.setStudents(getStudentlist().subList(3, 6));
        ArrayList<Assignment> ass3 = new ArrayList<>();
        ass3.add(getAssignmentlist().get(2));
        ass3.add(getAssignmentlist().get(5));
        sc3.setAssignments(ass3);
        getSchoolcourselist().add(sc3);
    }
    
    public static void FillDataFromSynthetic(){
    
    addCourseFromSynthetic();
    addTrainerFromSynthetic();
    addStudentFromSynthetic();
    addAssignmentFromSynthetic();
    addSchoolcourseFromSynthetic();
    }
}
