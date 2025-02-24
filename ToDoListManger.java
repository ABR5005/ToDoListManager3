import java.util.ArrayList; 
import java.util.Scanner; 
class Task { 
private String description; 
private boolean isCompleted; 
public Task(String description) { 
this.description = description; 
this.isCompleted = false; 
} 
public String getDescription() { 
return description; 
} 
public boolean isCompleted() { 
return isCompleted; 
} 
public void markCompleted() { 
this.isCompleted = true; 
} 
} 
class ToDoList { 
private ArrayList<Task> tasks; 
public ToDoList() { 
tasks = new ArrayList<>(); 
} 
public void addTask(String description) { 
if (description == null || description.trim().isEmpty()) { 
System.out.println("Task description cannot be empty!"); 
return; 
} 
tasks.add(new Task(description)); 
System.out.println("Task added: " + description); 
} 
    public void markTaskComplete(int index) { 
        if (index >= 0 && index < tasks.size()) { 
            tasks.get(index).markCompleted(); 
            System.out.println("Task " + (index + 1) + " marked as 
complete!"); 
        } else { 
            System.out.println("Invalid task index!"); 
        } 
    } 
 
    public void displayTasks() { 
        if (tasks.isEmpty()) { 
            System.out.println("No tasks in the list!"); 
            return; 
        } 
        System.out.println("\nTo-Do List:"); 
        for (int i = 0; i < tasks.size(); i++) { 
            Task task = tasks.get(i); 
            String status = task.isCompleted() ? "✔" : "✘"; 
            System.out.println((i + 1) + ". " + task.getDescription() + " [" 
+ status + "]"); 
        } 
    } 
} 
 
public class ToDoListManager { 
    public static void main(String[] args) { 
        ToDoList toDoList = new ToDoList(); 
        Scanner scanner = new Scanner(System.in); 
 
        while (true) 
            System.out.println("\nMenu:"); 
            System.out.println("1. Add Task"); 
            System.out.println("2. Mark Task Complete"); 
            System.out.println("3. Display Tasks"); 
            System.out.println("4. Exit"); 
            System.out.print("Choose an option: "); 
 
            String choice = scanner.nextLine(); 
 
            switch (choice) { 
                case "1": 
                    System.out.print("Enter the task description: "); 
                    String taskDescription = scanner.nextLine(); 
                    toDoList.addTask(taskDescription); 
                    break; 
                case "2": 
                    System.out.print("Enter the task number to mark complete: 
"); 
                    try { 
                        int taskIndex = Integer.parseInt(scanner.nextLine()) - 1; 
                        toDoList.markTaskComplete(taskIndex); 
                    } catch (NumberFormatException e) { 
                        System.out.println("Please enter a valid number!"); 
                    } 
break;
case "3": 
toDoList.displayTasks(); 
break; 
case "4": 
System.out.println("Goodbye!"); 
scanner.close(); 
return; 
default: 
System.out.println("Invalid choice! Please try again."); 
} 
} 
} 
} 