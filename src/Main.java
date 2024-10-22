import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {

        Project project = new Project("0", "project0");
        Project project1 = new Project("0", "project1");

        Task task0 = new Task("0", "task0", "test0",
                LocalDateTime.of(2024, 10, 22, 23, 34), Priority.LOW, project);
        Task task1 = new Task("1", "task1", "test1",
                LocalDateTime.of(2024, 12, 15, 12, 15), Priority.HIGH, project1);
        Task task2 = new Task("2", "task2", "test2",
                LocalDateTime.of(2024, 11, 30, 12, 15), Priority.MEDIUM, project);

        project.addTask(task0);
        project.addTask(task1);
        project.addTask(task2);

        ReminderService reminderService = new ReminderService();
        reminderService.scheduleReminder(task0, true, true, true, true);

    }

}
