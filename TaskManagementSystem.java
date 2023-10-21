import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManagementSystem {

    private List<Task> tasks;
    private File taskFile;

    public TaskManagementSystem() {
        tasks = new ArrayList<>();
        taskFile = new File("tasks.txt");
        loadTasksFromDisk();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(int taskId) {
        Task taskToRemove = findTaskById(taskId);
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
        } else {
            throw new TaskNotFoundException("Task not found.");
        }
    }

    public Task findTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void saveTasksToDisk() {
        try (FileOutputStream fos = new FileOutputStream(taskFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            System.err.println("Error saving tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTasksFromDisk() {
        if (taskFile.exists()) {
            try (FileInputStream fis = new FileInputStream(taskFile);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
                tasks = (List<Task>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading tasks: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        TaskManagementSystem taskSystem = new TaskManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Task Management System");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. List Tasks");
            System.out.println("4. Save and Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            switch (choice) {
                case 1:
                    System.out.print("Enter Task ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.print("Enter Task Description: ");
                    String description = scanner.nextLine();
                    Task newTask = new Task(id, description);
                    taskSystem.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter Task ID to Remove: ");
                    int removeId = scanner.nextInt();
                    taskSystem.removeTask(removeId);
                    break;
                case 3:
                    taskSystem.listTasks();
                    break;
                case 4:
                    taskSystem.saveTasksToDisk();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
class Task implements Serializable {
    private int id;
    private String description;
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return "Task ID: " + id + ", Description: " + description;
    }
}
class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String message) {
        super(message);
    }
}