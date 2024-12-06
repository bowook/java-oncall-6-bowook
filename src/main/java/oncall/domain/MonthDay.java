package oncall.domain;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.constant.Day;
import oncall.domain.constant.Month;

public class MonthDay {
    private final Month month;
    private final List<Integer> days;
    private final List<Day> dayList;

    private MonthDay(Month month, List<Integer> days, final List<Day> dayList) {
        this.month = month;
        this.days = days;
        this.dayList = dayList;
    }

    public Month getMonth() {
        return month;
    }

    public List<Integer> getDays() {
        return days;
    }

    public List<Day> getDayList() {
        return dayList;
    }

    public static MonthDay of(Month month, Day startDay) {
        int maxDays = getMaxDays(month);
        List<Integer> days = new ArrayList<>();
        for (int i = 1; i <= maxDays; i++) {
            days.add(i);
        }
        List<Day> dayList = generateDayList(maxDays, startDay);
        return new MonthDay(month, days, dayList);
    }

    private static List<Day> generateDayList(int maxDays, Day startDay) {
        List<Day> dayList = new ArrayList<>();
        Day[] days = Day.values();
        int startIndex = startDay.ordinal();
        for (int i = 0; i < maxDays; i++) {
            dayList.add(days[(startIndex + i) % days.length]);
        }
        return dayList;
    }

    private static int getMaxDays(Month month) {
        if (month.equals(Month.FEBRUARY)) {
            return 28;
        }
        if (month.equals(Month.APRIL) || month.equals(Month.JUNE) || month.equals(Month.SEPTEMBER) || month.equals(
                Month.NOVEMBER)) {
            return 30;
        }
        return 31;
    }
}
