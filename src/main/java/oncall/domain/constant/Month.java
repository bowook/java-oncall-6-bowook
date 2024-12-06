package oncall.domain.constant;

import java.util.Arrays;
import oncall.exception.CustomException;
import oncall.exception.ErrorMessage;

public enum Month {
    JANUARY(1, Holiday.JANUARY),
    FEBRUARY(2, Holiday.NONE),
    MARCH(3, Holiday.MARCH),
    APRIL(4, Holiday.NONE),
    MAY(5, Holiday.MAY),
    JUNE(6, Holiday.JUNE),
    JULY(7, Holiday.NONE),
    AUGUST(8, Holiday.AUGUST),
    SEPTEMBER(9, Holiday.NONE),
    OCTOBER(10, Holiday.OCTOBER),
    NOVEMBER(11, Holiday.NONE),
    DECEMBER(12, Holiday.DECEMBER);

    private final int month;
    private final Holiday holiday;

    Month(final int month, final Holiday holiday) {
        this.month = month;
        this.holiday = holiday;
    }

    public int getMonth() {
        return month;
    }

    public Holiday getHoliday() {
        return holiday;
    }

    public static Month from(int input) {
        return Arrays.stream(Month.values())
                .filter(number -> number.month == input)
                .findFirst()
                .orElseThrow(() -> CustomException.from(ErrorMessage.INVALID_INPUT_ERROR));
    }
}
