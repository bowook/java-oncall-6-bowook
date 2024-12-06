package oncall.controller;

import oncall.domain.AssignedWorkers;
import oncall.domain.MonthDay;
import oncall.domain.Workers;
import oncall.exception.CustomException;
import oncall.service.OnCallService;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {
    private final InputView inputView;
    private final OutputView outputView;
    private final OnCallService onCallService;

    public OnCallController(final InputView inputView, final OutputView outputView, final OnCallService onCallService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.onCallService = onCallService;
    }

    public void start() {
        MonthDay monthDay = readMonthDay();
        Workers workers = readWorkers();
        AssignedWorkers assignedWorkers = onCallService.assignWorkers(monthDay, workers);
        outputView.writeResult(monthDay, assignedWorkers);
        inputView.closeConsole();
    }

    private Workers readWorkers() {
        while (true) {
            try {
                return inputView.readWorker();
            } catch (CustomException customException) {
                outputView.writeErrorMessage(customException.getMessage());
            }
        }
    }

    private MonthDay readMonthDay() {
        while (true) {
            try {
                return inputView.readDate();
            } catch (CustomException customException) {
                outputView.writeErrorMessage(customException.getMessage());
            }
        }
    }
}
