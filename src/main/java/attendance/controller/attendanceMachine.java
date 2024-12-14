package attendance.controller;

import attendance.view.InputView;
import attendance.view.OutputView;

public class attendanceMachine {

    public void attendanceRun() {
        processRequestFunctionInput();
    }

    private void processRequestFunctionInput() {
        while (true){
            try {
                OutputView.printTodayAndRequestChoiceFunction();
                OutputView.printFunctionList();
                String input = InputView.requestFunctionNumber();
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processSortInput(String input) {
        if (input.equals("1")) {
            processCheckAttendance();
        } else if (input.equals("2")) {

        } else if (input.equals("3")) {

        } else if (input.equals("4")) {

        } else if (input.equals("Q")) {

        }
    }

    private void processCheckAttendance() {

    }
}
