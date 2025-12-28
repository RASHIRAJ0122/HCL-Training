import java.util.*;

class EmployeeManager implements EmployeeOperations {
    HashMap<Integer, String> hashMap = new HashMap<>();
    Hashtable<Integer, String> hashtable = new Hashtable<>();
    TreeMap<Integer, String> treeMap = new TreeMap<>();

    public void addEmployee(int id, String name) {
        hashMap.put(id, name);
        hashtable.put(id, name);
        treeMap.put(id, name);
    }

    public void displayEmployees() {
        System.out.println("HashMap: " + hashMap);
        System.out.println("Hashtable: " + hashtable);
        System.out.println("TreeMap: " + treeMap);
    }

    public void searchEmployee(int id) {
        System.out.println("Employee: " + hashMap.get(id));
    }

    public void removeEmployee(int id) {
        hashMap.remove(id);
        hashtable.remove(id);
        treeMap.remove(id);
    }

    public static void main(String[] args) {
        EmployeeManager em = new EmployeeManager();
        em.addEmployee(1, "Rashi");
        em.addEmployee(2, "Amit");
        em.displayEmployees();
    }
}