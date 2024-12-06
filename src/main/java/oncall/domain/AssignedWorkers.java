package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AssignedWorkers {
    private final List<Worker> workers = new ArrayList<>();

    public void add(Worker worker) {
        workers.add(worker);
    }

    public List<Worker> getWorkers() {
        return Collections.unmodifiableList(workers);
    }
}
