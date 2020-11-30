package data;

import ValidationUtil.InputValidation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import models.Schoolcourse;
import models.Student;
import models.Trainer;


public class Database {

    private static List<Course> courselist = new ArrayList<Course>();
    private static List<Student> studentlist = new ArrayList<Student>();
    private static List<Trainer> trainerlist = new ArrayList<Trainer>();
    private static List<Assignment> assignmentlist = new ArrayList<Assignment>();
    private static List<Schoolcourse> schoolcourselist = new ArrayList<Schoolcourse>();

    public static List<Schoolcourse> getSchoolcourselist() {
        return schoolcourselist;
    }

    public static void setSchoolcourselist(List<Schoolcourse> schoolcourselist) {
        Database.schoolcourselist = schoolcourselist;
    }
    
    public static List<Course> getCourselist() {
        return courselist;
    }

    public static void setCourselist(List<Course> courselist) {
        Database.courselist = courselist;
    }

    public static List<Student> getStudentlist() {
        return studentlist;
    }

    public static void setStudentlist(List<Student> studentlist) {
        Database.studentlist = studentlist;
    }

    public static List<Trainer> getTrainerlist() {
        return trainerlist;
    }

    public static void setTrainerlist(List<Trainer> trainerlist) {
        Database.trainerlist = trainerlist;
    }

    public static List<Assignment> getAssignmentlist() {
        return assignmentlist;
    }

    public static void setAssignmentlist(List<Assignment> assignmentlist) {
        Database.assignmentlist = assignmentlist;
    }
    
    
    public static void printAllStudents(){
     for(Student st: studentlist){
         System.out.println(st.toString());
     }
    }
    
    public static void printAllTrainers(){
     for(Trainer tr: trainerlist){
         System.out.println(tr.toString());
     }
    }
    
    public static void printAllAssignments(){
     for(Assignment ass: assignmentlist){
         System.out.println(ass.toString());
     }
    }
    
    public static void printAllCourses(){
    for(Course c: courselist){
        System.out.println(c.toString());
    }
    }
    
    public static void printAllSchoolcourses(){
    for(Schoolcourse sh: schoolcourselist){
        System.out.println(sh.toString());}
    }
    public static void printStudentsPerSchoolcourse(Schoolcourse s){
        System.out.println("Students for this Course: ");
        for(Student st: s.getStudents()){
            System.out.println(st.toString());
        }
    }
    
    public static void printTrainersPerSchoolcourse(Schoolcourse s){
        System.out.println("Trainers for this Course: ");
        for(Trainer t: s.getTrainers()){
        System.out.println(t.toString());
    }
    }
    
    public static void printAssignmentsPerSchoolcourse(Schoolcourse s){
        System.out.println("Assignments for this Course: ");   
        for(Assignment ass: s.getAssignments()){
        System.out.println(ass.toString());
    }
    } 

    //Takes a student as input and prints the Assignments of the Schoolcourses that the Stundent belongs to
    public static void printAssignmentsPerStudent(Student st){
        System.out.println("Assignments for this Student: ");
        for(Schoolcourse s : schoolcourselist){
            for(Student st2: s.getStudents()){
            if(st.equals(st2)){
                System.out.println(s.getAssignments().toString());
            }
               
                } 
        }
    }
    /*
    Adds all Students per Schoolcourse to a Set.
    If a Student can't be added it means that it already exists.
    Adds duplicates to a List. 
    */
    public static void printStudentsInMultiCourse(){
     HashSet<Student> set = new HashSet();
     List<Student> multist = new ArrayList<Student>();
     for(Schoolcourse s: schoolcourselist){
       for(Student st: s.getStudents()){
       if(!set.add(st)){
           multist.add(st);
       }
       }
     }
        System.out.println("The list of Students that belong to more than one Courses: ");
        for(Student sst: multist){
        System.out.println(sst.toString());}
    }
    
    /*
    Finds the day of the week represented by the date entered by the user.
    Checks the difference needed to get the needed week.
    Checks all Assignments per Schoolcourse for that week.
    If it finds one or more, adds all Students for that Schoolcourse in a Set(for uniqueness). 
    */
    public static void findStudentsWithPendingAssByDate(){
     Scanner sc = new Scanner(System.in);
     HashSet<Student> set = new HashSet();   
     System.out.println("Please enter the date (yyyy-mm-dd): ");
        String input = sc.nextLine();
         LocalDate ld = InputValidation.validateDate(input);
       
        int inputValue = ld.getDayOfWeek().getValue();
        
        switch(inputValue){
         case 1:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=0 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=4){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
             break;
         
         case 2:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-1 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=3){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
             break;
        
         case 3:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-2 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=2){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
        
         case 4:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-3 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=1){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
         case 5:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-4 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=0){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
         case 6:
             for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-5 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=-1){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
         case 7:
              for(Schoolcourse sch: schoolcourselist){
               for(Assignment ass: sch.getAssignments()){
                   if((ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))>=-6 && (ChronoUnit.DAYS.between(ld, ass.getSubDateTime()))<=-2){
                       for(Student st: sch.getStudents()){
                        set.add(st);
                       }
                    }
                 }
               }
        }
       //Convert Set to ArrayList for better output
        ArrayList<Student> studar = new ArrayList<Student>(set);
        System.out.println("Students who need to submit one or more assignments in that week: ");
        for(Student s: studar){
            System.out.println(s.toString());
        }
   
            
        
    }
 }
