package oncall.view;

import java.util.List;
import oncall.domain.AssignedWorkers;
import oncall.domain.MonthDay;
import oncall.domain.Worker;
import oncall.domain.constant.Day;
import oncall.domain.constant.Month;

public class OutputView {
    private final static String FORMAT = "%d월 %d일 %s %s%n";

    public void writeResult(MonthDay monthDay, AssignedWorkers assignedWorkers) {
        Month month = monthDay.getMonth();
        List<Integer> holidays = month.getHoliday().getDate();
        List<Integer> days = monthDay.getDays();
        List<Day> dayList = monthDay.getDayList();
        List<Worker> assignedWorker = assignedWorkers.getWorkers();
        for (int day : days) {
            if (holidays.contains(day)) {
                System.out.printf(FORMAT, month.getMonth(), day, dayList.get(day - 1).getName() + "(휴일)",
                        assignedWorker.get(day - 1).getName());
                continue;
            }
            System.out.printf(FORMAT, month.getMonth(), day, dayList.get(day - 1).getName(),
                    assignedWorker.get(day - 1).getName());
        }
    }

    public void writeErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
