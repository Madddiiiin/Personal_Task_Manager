import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Project {

    private String projectId;
    private String projectName;
    private List<Task> tasks;

    public Project (String projectId, String projectName) {
        this.projectId = projectId;
        this.projectName = projectName;
        tasks = new ArrayList<>();
    }

    public void addTask (Task task) {
        tasks.add(task);
    }

    public void removeTask (Task task) {
        tasks.remove(task);
    }

    public void clearTasks () {
        this.tasks = new ArrayList<>();
    }

    public void listTasksByPriority () {
        List<Task> sortedList = new ArrayList<>();

        for (Task task : tasks) {
            if (task.getPriority() == Priority.HIGH) {
                sortedList.add(task);
            }
        }

        for (Task task : tasks) {
            if (task.getPriority() == Priority.MEDIUM) {
                sortedList.add(task);
            }
        }

        for (Task task : tasks) {
            if (task.getPriority() == Priority.LOW) {
                sortedList.add(task);
            }
        }

        tasks = sortedList;
    }

    public void listTasksByDueDate () {
        List<Task> sortedList = tasks;

        for (int i = 0; i < sortedList.size(); i++) {
            int minIndex = i;

            for (int j = i + 1; j < sortedList.size(); j++) {

                if (sortedList.get(j).getDueDate().isBefore(sortedList.get(minIndex).getDueDate())) {
                    minIndex = j;
                }

            }

            Task temp = sortedList.get(i);
            sortedList.set(i, sortedList.get(minIndex));
            sortedList.set(minIndex, temp);
        }

        tasks = sortedList;
    }

    public String getProjectId () {
        return projectId;
    }

    public void setProjectId (String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName () {
        return projectName;
    }

    public void setProjectName (String projectName) {
        this.projectName = projectName;
    }

    public List<Task> getTasks () {
        return tasks;
    }

}
