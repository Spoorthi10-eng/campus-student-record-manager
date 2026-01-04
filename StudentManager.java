import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students;

    public StudentManager() {
        students = FileHandler.loadData();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }
        students.add(student);
        FileHandler.saveData(students);
        System.out.println("Student added successfully.");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }
        System.out.println("ID | Name | Age | Course");
        for (Student s : students) {
            s.display();
        }
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public void updateStudent(int id, String name, int age, String course) {
        Student s = searchStudent(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        s.setName(name);
        s.setAge(age);
        s.setCourse(course);
        FileHandler.saveData(students);
        System.out.println("Student updated successfully.");
    }

    public void deleteStudent(int id) {
        Student s = searchStudent(id);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        students.remove(s);
        FileHandler.saveData(students);
        System.out.println("Student deleted successfully.");
    }
}