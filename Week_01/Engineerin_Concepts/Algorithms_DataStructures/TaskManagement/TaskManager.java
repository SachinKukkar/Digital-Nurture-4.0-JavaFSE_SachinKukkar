package Week_01.Engineerin_Concepts.TaskManagement;


class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
    }
}

public class TaskManager {
    Task head = null;

    // Add task at the end
    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    // Search task by ID
    public Task searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id)
                return current;
            current = current.next;
        }
        return null;
    }

    // Delete task by ID
    public void deleteTask(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task with ID " + id + " deleted.");
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != id) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Task with ID " + id + " deleted.");
        } else {
            System.out.println("Task with ID " + id + " not found.");
        }
    }

    // Traverse and print all tasks
    public void listTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        manager.addTask(101, "Design module", "Pending");
        manager.addTask(102, "Develop module", "In Progress");
        manager.addTask(103, "Test module", "Pending");

        System.out.println("All Tasks:");
        manager.listTasks();

        System.out.println("\nSearching for Task ID 102:");
        Task task = manager.searchTask(102);
        System.out.println(task != null ? task : "Not found");

        System.out.println("\nDeleting Task ID 101:");
        manager.deleteTask(101);

        System.out.println("\nTasks after deletion:");
        manager.listTasks();
    }
}

