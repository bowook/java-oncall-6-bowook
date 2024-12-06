package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import oncall.domain.MonthDay;
import oncall.domain.Worker;
import oncall.domain.Workers;
import oncall.utils.Parser;

public class InputView {
    private final static String INPUT_MONTH_DAY = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private final static String INPUT_WEEK_DAY = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private final static String INPUT_WEEKEND = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public Workers readWorker() {
        System.out.println(INPUT_WEEK_DAY);
        List<Worker> weekDayWorkers = Parser.checkDuplicateWorker(readConsole());
        System.out.println(INPUT_WEEKEND);
        List<Worker> weekendWorkers = Parser.checkDuplicateWorker(readConsole());
        return new Workers(weekDayWorkers, weekendWorkers);
    }

    public MonthDay readDate() {
        System.out.println(INPUT_MONTH_DAY);
        return Parser.dateToMonth(readConsole());
    }

    public void closeConsole() {
        Console.close();
    }

    private String readConsole() {
        return Console.readLine();
    }
}
