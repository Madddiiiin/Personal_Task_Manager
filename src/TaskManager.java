import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<Task> tasks;
    private List<Project> projects;

    public TaskManager () {
        tasks = new ArrayList<>();
        projects = new ArrayList<>();
    }

    public void addTask (Task task) {
        tasks.add(task);
    }

    public void deleteTask (Task task) {
        tasks.remove(task);
    }

    /*
    public void editTask (...) {
        Task.editTask(...);
    }
    */

    public void listAllTasks () {
        for (Task task : tasks) {
            listTask(task);
        }
    }

    public void listTasksByProject () {
        sortTasksByProject();

        for (int i = 0; i < tasks.size(); i++) {
            if (i != 0) {
                if (tasks.get(i).getProject() != tasks.get(i - 1).getProject()) {
                    System.out.println("-------------------------------------------");
                    System.out.println();
                }
            }
            listTask(tasks.get(i));
        }
    }

    //helper method
    public void listTask (Task task) {
        System.out.println("ID: " + task.getTaskId());
        System.out.println("Title: " + task.getTitle());
        System.out.println("Description: " + task.getDescription());
        System.out.println("Due Date: " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(task.getDueDate()));
        System.out.println("Priority: " + task.getPriority().toString());
        System.out.println("Project: " + task.getProject().getProjectName());
        System.out.println();
    }

    //helper method
    public void sortTasksByProject () {
        List<Task> sortedList = tasks;

        for (int i = 0; i < sortedList.size(); i++) {
            int index = i + 1;

            for (int j = i + 1; j < sortedList.size(); j++) {
                if (sortedList.get(j).getProject() == sortedList.get(i).getProject()) {
                    Task temp = sortedList.get(index);
                    sortedList.set(index, sortedList.get(j));
                    sortedList.set(j, temp);
                    index++;
                }
            }

            i = index - 1;
        }

        tasks = sortedList;
    }

    public void listTasksDueToday () {
        for (Task task : tasks) {
            if (task.getDueDate().toLocalDate().equals(LocalDate.now())) {
                listTask(task);
            }
        }
    }

    public void listOverdueTasks () {
        for (Task task : tasks) {
            if (task.getDueDate().isBefore(LocalDateTime.now())) {
                listTask(task);
            }
        }
    }

}
