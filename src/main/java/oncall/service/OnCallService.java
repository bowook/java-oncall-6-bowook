package oncall.service;

import java.util.List;
import oncall.domain.AssignedWorkers;
import oncall.domain.MonthDay;
import oncall.domain.Workers;
import oncall.domain.constant.Day;

public class OnCallService {
    private final AssignedWorkers assignedWorkers = new AssignedWorkers();

    public AssignedWorkers assignWorkers(MonthDay monthDay, Workers workers) {
        List<Integer> holidays = monthDay.getMonth().getHoliday().getDate();
        List<Integer> days = monthDay.getDays();
        List<Day> dayList = monthDay.getDayList();
        assign(dayList, days, holidays, workers);
        //리턴하기전에 연속 근무 확인하는 과정이 필요함
        return assignedWorkers;
    }

    private void assign(List<Day> dayList, List<Integer> days, List<Integer> holidays, Workers workers) {
        int weekWorker = 0;
        int weekendWorker = 0;
        for (int i = 0; i < dayList.size(); i++) {
            if (dayList.get(i).getDay().equals("평일") && !holidays.contains(days.get(i))) {
                assignedWorkers.add(workers.getWeekWorkers().get(weekWorker));
                weekWorker += 1;
            }
            if (dayList.get(i).getDay().equals("평일") && holidays.contains(days.get(i))) {
                assignedWorkers.add(workers.getWeekendWorkers().get(weekendWorker));
                weekendWorker += 1;
            }
            if (dayList.get(i).getDay().equals("주말")) {
                assignedWorkers.add(workers.getWeekendWorkers().get(weekendWorker));
                weekendWorker += 1;
            }
        }
    }
}
