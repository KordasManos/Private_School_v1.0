package ValidationUtil;

import static data.Database.getSchoolcourselist;
import static data.Database.getStudentlist;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputValidation {

    static Scanner sc = new Scanner(System.in);

    //Validates a Date to the format yyyy-MM-dd
    public static LocalDate validateDate(String s) {
        try {
            LocalDate ld = LocalDate.parse(s);

        } catch (DateTimeParseException e) {
            System.out.println("Invalid Date.Try again.");
            return validateDate(sc.nextLine());
        }
        return LocalDate.parse(s);
    }

    public static int validateInt(String s) {
        try {
            int x = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.Try again.");
            return validateInt(sc.next());
        }
        return Integer.parseInt(s);
    }

    public static float validateFloat(String s) {
        try {
            float f = Float.parseFloat(s);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number.Try again.");
            return validateFloat(sc.next());
        }
        return Float.parseFloat(s);
    }
    
    //Validates a String to "yes" or "no"
    public static String validateYesOrNo(String s){
          if(s.toLowerCase().equals("yes")){
          }else if(s.toLowerCase().equals("no")){
          }else{
              System.out.println("Invalid option.Enter \"Yes\" or \"No\"");
              return validateYesOrNo(sc.nextLine());
          }
          return s.toLowerCase();
    }
    

    
    public static int compareIntToSchListSize(int s){
       if((s>getSchoolcourselist().size()) || (s<1)){
           System.out.println("Invalid Number!!!Try again.");
           return compareIntToSchListSize(validateInt(sc.next()));
       }
       return s;
    }
    
    public static int compareIntToStudListSize(int s){
      if((s>getStudentlist().size()) || (s<1)){
           System.out.println("Invalid Number!!!Try again.");
           return compareIntToStudListSize(validateInt(sc.next()));
       }
      return s; 
    }
}
