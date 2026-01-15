package miniproject3;

import java.io.Serializable;

public class Student implements Serializable, Comparable<Student> {

    private int eno;
    private String name;
    private String sem;
    private String branch;
    private double percentage;

    public Student(int eno, String name, String sem, String branch, double percentage) {
        this.eno = eno;
        this.name = name;
        this.sem = sem;
        this.branch = branch;
        this.percentage = percentage;
    }

    public int getEno() {
        return eno;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    @Override
    public int compareTo(Student s) {
        return this.name.compareToIgnoreCase(s.name);
    }

    @Override
    public String toString() {
        return "Eno: " + eno +
               ", Name: " + name +
               ", Sem: " + sem +
               ", Branch: " + branch +
               ", Percentage: " + percentage;
    }
}
