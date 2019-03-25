import java.util.Scanner;

public class StudentManagement {

    public static void main(String[] args) {

        boolean done = false;
        Scanner input = new Scanner(System.in);

        // loop continues until user chooses to exit
        while ( !done ){
            System.out.println("Choose an option: \n");
            System.out.println("1. Add a student");
            System.out.println("2. Remove a student");
            System.out.println("3. Update student GPA");
            System.out.println("4. Display student information");
            System.out.println("5. Display all students");
            System.out.println("6. Exit");

            int selection;

            // check integer is entered
            if (input.hasNextInt()){
                selection = input.nextInt();
            }else{
                System.out.println("Number not entered, try again.");
                input.next();  // bad input must be discarded
                continue
            }

            // check valid selection
            if (selection < 1 || selection > 6){
                System.out.println("Please select a number between 1 and 6, inclusive.");
                continue;
            }

            if (selection == 1){
                //add code here
            }

            if (selection == 2){
                //add code here
            }

            if (selection == 3){
                //add code here
            }

            if (selection == 4){
                //add code here
            }

            if (selection == 5){
                //add code here
            }

            if (selection == 6){  // exit
                System.out.println("Goodbye.");
                done = true;
            }
        }
    }
}
