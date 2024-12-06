package oncall.domain.constant;

import java.util.Arrays;
import oncall.exception.CustomException;
import oncall.exception.ErrorMessage;

public enum Day {
    MONDAY("월", "평일"),
    TUESDAY("화", "평일"),
    WEDNESDAY("수", "평일"),
    THURSDAY("목", "평일"),
    FRIDAY("금", "평일"),
    SATURDAY("토", "주말"),
    SUNDAY("일", "주말");
    private final String name;
    private final String day;

    Day(final String name, final String day) {
        this.name = name;
        this.day = day;
    }

    public static Day from(String input) {
        return Arrays.stream(Day.values())
                .filter(day -> day.name.equals(input))
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT_ERROR));
    }

    public String getName() {
        return name;
    }

    public String getDay() {
        return day;
    }
}
