import java.util.*;
import java.util.regex.Pattern;

class StudentManager implements StudentOperations{
    List<Student> students = new ArrayList<>();

    public void addStudent(Student s){
        students.add(s);
    }

    public void displayStudents() {
        students.forEach(s -> System.out.println(s.roll + " " + s.name));
    }

    public void searchStudent(int roll){
        students.stream().filter(s -> s.roll == roll).forEach(s -> System.out.println("Found: " + s.name));
    }

    public void removeStudent(int roll){
        students.removeIf(s -> s.roll == roll);
    }

    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        sm.addStudent(new Student(1, "Rashi"));
        sm.addStudent(new Student(2, "Aman"));
        sm.displayStudents();
        sm.searchStudent(1);
        sm.removeStudent(2);
    }
}