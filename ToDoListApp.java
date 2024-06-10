import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ToDoListApp {
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> toDoList = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("Choose an option: (1) Add Task (2) Edit Task (3) Remove Task (4) List Tasks (5) Exit");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    listTasks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Option. Please Choose Again.");
            }
        } while (option != 5);
    }

    private static void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        toDoList.add(task);
        System.out.println("Task added.");
    }

    private static void editTask() {
        listTasks();
        System.out.print("Enter the task number you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < toDoList.size()) {
            System.out.print("Enter the new task: ");
            String newTask = scanner.nextLine();
            toDoList.set(index, newTask);
            System.out.println("Task updated.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void removeTask() {
        listTasks();
        System.out.print("Enter the task number you want to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        if (index >= 0 && index < toDoList.size()) {
            toDoList.remove(index);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void listTasks() {
        if (toDoList.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("Your to-do list:");
            for (int i = 0; i < toDoList.size(); i++) {
                System.out.println((i + 1) + ". " + toDoList.get(i));
            }
        }
    }
}