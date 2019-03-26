import java.util.Scanner;
import java.util.LinkedList;

public class StudentManagement {

    /** Method used to determine whether a student ID is in a Linked List of Student objects
     * Returns index of matching Student object if there is a match
     * Returns -1 if there is no match*/
    private static int studentInList(String id, LinkedList<Student> list){
        int index = 0;
        for (Student s : list){     // iterates through Student elements in LinkedList
            if (id.equals(s.getID())){
                return index;    // returns index of student if there is a matching ID
            }
            index++;
        }
        return -1;           // returns -1 to indicate that there was no matching ID
    }

    /** Prints the name, ID, and GPA of a student on 3 lines. */
    private static void displayStudentInfo(Student s){
        System.out.println("\nName: " + s.getName());
        System.out.println("Student ID: " + s.getID());
        System.out.println("GPA: " + s.getGPA());
    }

    public static void main(String[] args) {

        boolean done = false;
        Scanner input = new Scanner(System.in);

        /* Linked List Declaration (elements are Student objects) */
        LinkedList<Student> studentList = new LinkedList<>();

        // loop continues until user chooses to exit
        while ( !done ){
            System.out.println("\nChoose an option: \n");
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
                continue;
            }

            // check valid selection
            if (selection < 1 || selection > 6){
                System.out.println("Please select a number between 1 and 6, inclusive.");
                continue;
            }

            if (selection == 1){
                System.out.println("(Add Student) Please enter a student ID: ");
                String newID = input.next();

                // gets LinkedList index of Student w/ matching ID (or -1 if no matching ID)
                int studentIndex = studentInList(newID, studentList);

                if (studentIndex == -1){    // if there is no matching student ID in the list
                    // prompts new student's name and GPA
                    System.out.println("Please enter the student's name: ");
                    String newName = input.next();
                    System.out.println("Please enter the student's GPA: ");
                    double newGPA = input.nextDouble();

                    // creates a student object with input ID, Name, and GPA; adds it to studentList
                    Student newStudent = new Student(newID, newName, newGPA);
                    studentList.add(newStudent);
                    System.out.println("Student successfully added to list.");
                }else{      // if there is a matching student ID in the list
                    System.out.println("A student with ID " + newID + " is already in the list.");
                }
                continue;       // returns to main menu

            }


            if (selection == 2){
                System.out.println("(Remove Student) Please enter a student ID: ");
                String inputID = input.next();

                // gets LinkedList index of Student w/ matching ID (or -1 if no matching ID)
                int studentIndex = studentInList(inputID, studentList);

                if (studentIndex == -1){        // if there is no matching student ID in the list
                    System.out.println("Student identified by ID " + inputID + " is not in the list.");
                }else{      // if there is a matching ID in the list
                    studentList.remove(studentIndex);       // removes student at index with matching ID
                    System.out.println("Student successfully removed from list.");
                }
                continue;       // returns to main menu
            }


            if (selection == 3){
                System.out.println("(Update GPA) Please enter a student ID: ");
                String inputID = input.next();

                boolean duplicate = false;
                for (Student s : studentList){              // loops through Students in studentList
                    if (inputID.equals(s.getID())){         // if user input ID is equal to the Student ID
                        duplicate = true;
                        System.out.println("Please enter the student's new GPA: ");
                        s.setGPA(input.nextDouble());       // GPA of student s set to double input by user
                        System.out.println("Successfully updated GPA.");
                        break;      // exit for loop after matching ID is found
                    }
                }

                if (!duplicate){        // if no matching ID was found
                    System.out.println("Student identified by ID " + inputID + " is not in the list.");
                }
                continue;       // returns to main menu
            }


            if (selection == 4){
                System.out.println("(Display Student Info) Please enter a student ID: ");
                String inputID = input.next();

                boolean duplicate = false;
                for (Student s : studentList){              // loops through Students in studentList
                    if (inputID.equals(s.getID())){
                        duplicate = true;
                        displayStudentInfo(s);              // displays name, id, and GPA of matching student
                        break;                              // exit for loop
                    }
                }
                if (!duplicate){        // if no matching ID was found
                    System.out.println("Student identified by ID " + inputID + " is not in the list.");
                }
                continue;       // returns to main menu
            }


            if (selection == 5){
                for (Student s : studentList){              // loops through Students in studentList
                    displayStudentInfo(s);                  // displays name, id, and GPA of each student
                }
            }


            if (selection == 6){  // exit
                System.out.println("Bye.");
                done = true;

            }
        }
        input.close();
    }
}
