package oncall.domain;

import java.util.List;

public class Workers {
    private final List<Worker> weekWorkers;
    private final List<Worker> weekendWorkers;

    public Workers(List<Worker> weekWorkers, List<Worker> weekendWorkers) {
        this.weekWorkers = weekWorkers;
        this.weekendWorkers = weekendWorkers;
    }

    public List<Worker> getWeekWorkers() {
        return weekWorkers;
    }

    public List<Worker> getWeekendWorkers() {
        return weekendWorkers;
    }
}
