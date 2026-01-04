import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n--- Campus Student Record Manager ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();
                    manager.addStudent(new Student(id, name, age, course));
                    break;

                case 2:
                    manager.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    Student s = manager.searchStudent(sc.nextInt());
                    if (s != null)
                        s.display();
                    else
                        System.out.println("Student not found.");
                    break;

                case 4:
                    System.out.print("ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Name: ");
                    String uname = sc.nextLine();
                    System.out.print("New Age: ");
                    int uage = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Course: ");
                    String ucourse = sc.nextLine();
                    manager.updateStudent(uid, uname, uage, ucourse);
                    break;

                case 5:
                    System.out.print("ID to delete: ");
                    manager.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}