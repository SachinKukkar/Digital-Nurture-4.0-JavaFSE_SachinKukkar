package Week_01.Engineerin_Concepts.EmployeeManagement;

class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: ₹" + salary;
    }
}

public class EmployeeManager {
    Employee[] employees = new Employee[100]; // Fixed size array
    int count = 0;

    // Add employee
    public void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Employee array is full.");
        }
    }

    // Search employee by ID
    public Employee searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                return employees[i];
            }
        }
        return null;
    }

    // Delete employee by ID
    public void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                System.out.println("Employee with ID " + id + " deleted.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    // Traverse employees
    public void listEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager();

        manager.addEmployee(new Employee(1, "Raj", "Developer", 50000));
        manager.addEmployee(new Employee(2, "Simran", "Manager", 70000));
        manager.addEmployee(new Employee(3, "Aman", "Analyst", 45000));

        System.out.println("All Employees:");
        manager.listEmployees();

        System.out.println("\nSearching for Employee ID 2:");
        Employee emp = manager.searchEmployee(2);
        System.out.println(emp != null ? emp : "Not found");

        System.out.println("\nDeleting Employee ID 1:");
        manager.deleteEmployee(1);

        System.out.println("\nEmployees after deletion:");
        manager.listEmployees();
    }
}
