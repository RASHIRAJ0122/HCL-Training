package miniproject2;

import java.io.Serializable;

public class Employee implements Serializable, Comparable<Employee> {

    private int id;
    private String name;
    private double salary;
    private String department;

    public Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareToIgnoreCase(e.name);
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Salary: " + salary +
               ", Department: " + department;
    }
}
