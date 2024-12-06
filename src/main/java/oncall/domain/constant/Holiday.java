package oncall.domain.constant;

import java.util.ArrayList;
import java.util.List;

public enum Holiday {
    JANUARY(1, 0),
    MARCH(1, 0),
    MAY(5, 0),
    JUNE(6, 0),
    AUGUST(15, 0),
    OCTOBER(3, 9),
    DECEMBER(25, 0),
    NONE(0, 0);
    private final int dateOne;
    private final int dateTwo;

    Holiday(final int dateOne, final int dateTwo) {
        this.dateOne = dateOne;
        this.dateTwo = dateTwo;
    }

    public List<Integer> getDate() {
        List<Integer> dates = new ArrayList<>();
        dates.add(dateOne);
        dates.add(dateTwo);
        return dates;
    }
}
