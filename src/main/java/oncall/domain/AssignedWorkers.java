package oncall.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AssignedWorkers {
    private final List<Worker> workers = new ArrayList<>();
    private final Random random = new Random();

    public void add(Worker worker) {
        workers.add(worker);
    }

    public List<Worker> getWorkers() {
        ensureNoContinuousWorkers();
        return Collections.unmodifiableList(workers);
    }

    private void ensureNoContinuousWorkers() {
        while (hasContinuousWorkers()) {
            Collections.shuffle(workers, random);
        }
    }

    private boolean hasContinuousWorkers() {
        for (int i = 0; i < workers.size() - 1; i++) {
            if (workers.get(i).getName().equals(workers.get(i + 1).getName())) {
                return true;
            }
        }
        return false;
    }
}
