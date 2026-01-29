import java.util.*;
public class StudentManagementpp {
    private static List<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int choice;
        do{
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }while(choice != 5);
    }
    private static void addStudent() {
        // TODO Auto-generated method stub
        System.out.println("enter id");
        int id =scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Name" );
        String name = scanner.nextLine();
        System.out.println("Enter Age");
        int age = scanner.nextInt();
        System.out.println("Enter Course");
        scanner.nextLine();
        String course = scanner.nextLine();
        students.add(new Student(id, name, age, course));
    }
    private static void viewStudent() {
        if(students.isEmpty()){
            System.out.println("No students available.");
        } else {
            for(Student student : students){
                System.out.println(student);
            }
        }
        
        
    }
    private static void updateStudent() {
        System.out.println("Update Student");
        int id = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            if(student.getId() == id){
                System.out.println("Enter new name:");
                String name = scanner.nextLine();
                System.out.println("Enter new age:");
                int age = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter new course:");
                String course = scanner.nextLine();
                students.set(i, new Student(id, name, age, course));
                return;
            }
        }
        System.out.println("Student not found.");
        
    }
    private static void deleteStudent() {
        System.out.println("Delete Student");
        int id = scanner.nextInt();
        for(int i = 0; i < students.size(); i++){
            Student student = students.get(i);
            if(student.getId() == id){
                students.remove(i);
                System.out.println("Student deleted.");
                return;
            }
        }
        ;
    }

}
