package oncall.utils;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.MonthDay;
import oncall.domain.Worker;
import oncall.domain.constant.Day;
import oncall.domain.constant.Month;
import oncall.exception.CustomException;
import oncall.exception.ErrorMessage;

public class Parser {
    private final static String COMMA = ",";

    public static List<Worker> checkDuplicateWorker(String input) {
        List<String> tempWorkers = List.of(input.split(COMMA));
        List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < tempWorkers.size() - 1; i++) {
            if (tempWorkers.get(i).equals(tempWorkers.get(i + 1))) {
                throw CustomException.from(ErrorMessage.INVALID_INPUT_ERROR);
            }
            workers.add(new Worker(tempWorkers.get(i)));
        }
        workers.add(new Worker(tempWorkers.get(tempWorkers.size() - 1)));
        return workers;
    }

    public static MonthDay dateToMonth(String input) {
        List<String> inputs = List.of(input.split(COMMA));
        if (inputs.size() != 2) {
            throw CustomException.from(ErrorMessage.INVALID_INPUT_ERROR);
        }
        Month month = Month.from(checkNumber(inputs.get(0)));
        Day day = Day.from(inputs.get(1));
        return MonthDay.of(month, day);
    }

    private static int checkNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw CustomException.from(ErrorMessage.INVALID_INPUT_ERROR);
        }
    }
}
