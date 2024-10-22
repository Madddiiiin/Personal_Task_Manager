import java.time.LocalDateTime;

public class Task {

    private String taskId;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
    private TaskStatus status;
    private Project project;

    public Task (String taskId, String title, String description, LocalDateTime dueDate,
                 Priority priority, Project project) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        status = TaskStatus.PENDING;
        this.project = project;
    }

    /*
    public void editTask (String newTitle, String newDescription, LocalDateTime newDueDate,
                          Priority newPriority, String newProject) {

    }
    */

    public void markInProgress () {
        status = TaskStatus.IN_PROGRESS;
    }

    public void markCompleted () {
        status = TaskStatus.COMPLETED;
    }

    public String getTaskId () {
        return taskId;
    }

    public void setTaskId (String taskId) {
        this.taskId = taskId;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate () {
        return dueDate;
    }

    public void setDueDate (LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Priority getPriority () {
        return priority;
    }

    public void setPriority (Priority priority) {
        this.priority = priority;
    }

    public Project getProject () {
        return project;
    }

    public void setProject (Project project) {
        this.project = project;
    }

}
