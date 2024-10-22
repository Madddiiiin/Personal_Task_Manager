import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReminderService {

    private Map<Task, ScheduledExecutorService> scheduledTasks;

    public ReminderService () {
        scheduledTasks = new HashMap<>();
    }

    //booleans determine, which reminders are turned on (72 hours, 24 hours, 6 hours, 1 hour)
    public void scheduleReminder (Task task,boolean threeDayReminder, boolean oneDayReminder,
                                  boolean sixHoursReminder, boolean oneHourReminder) {
        ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);

        LocalDateTime current = LocalDateTime.now();

        //72 hour reminder
        if (threeDayReminder) {
            LocalDateTime threeDayReminderTime = task.getDueDate().minusHours(72);
            long threeDayDelay = Duration.between(current, threeDayReminderTime).getSeconds();

            scheduler.schedule(() -> {
                System.out.println("You have 3 days left to do task " + task.getTaskId()
                        + ": " + task.getDescription());
            }, threeDayDelay, TimeUnit.SECONDS);
        }

        //24 hour reminder
        if (oneDayReminder) {
            LocalDateTime oneDayReminderTime = task.getDueDate().minusHours(24);
            long oneDayDelay = Duration.between(current, oneDayReminderTime).getSeconds();

            scheduler.schedule(() -> {
                System.out.println("You have 24 hours left to do task " + task.getTaskId()
                        + ": " + task.getDescription());
            }, oneDayDelay, TimeUnit.SECONDS);
        }

        //6 hour reminder
        if (sixHoursReminder) {
            LocalDateTime sixHourReminderTime = task.getDueDate().minusHours(6);
            long sixHourDelay = Duration.between(current, sixHourReminderTime).getSeconds();

            scheduler.schedule(() -> {
                System.out.println("You have 6 hours left to do task " + task.getTaskId()
                        + ": " + task.getDescription());
            }, sixHourDelay, TimeUnit.SECONDS);
        }

        //1 hour reminder
        if (oneHourReminder) {
            LocalDateTime oneHourReminderTime = task.getDueDate().minusHours(1);
            long oneHourDelay = Duration.between(current, oneHourReminderTime).getSeconds();

            scheduler.schedule(() -> {
                System.out.println("You have 1 hour left to do task " + task.getTaskId()
                        + ": " + task.getDescription());
            }, oneHourDelay, TimeUnit.SECONDS);
        }

        scheduledTasks.put(task, scheduler);

        scheduler.shutdown();
    }

}
