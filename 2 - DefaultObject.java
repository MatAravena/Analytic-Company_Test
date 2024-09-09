import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    String studentId;
    String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " (" + studentId + ")";
    }
}

public class DefaultObject {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String line;
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                students.add(new Student(values[0], values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(students, Comparator.comparing(student -> student.name));

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println(students);
    }
}
