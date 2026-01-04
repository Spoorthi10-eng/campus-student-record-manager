
import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.dat";

    public static void saveData(ArrayList<Student> students) {
        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(students);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving student data.");
        }
    }

    public static ArrayList<Student> loadData() {
        try {
            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(FILE_NAME));
            return (ArrayList<Student>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}