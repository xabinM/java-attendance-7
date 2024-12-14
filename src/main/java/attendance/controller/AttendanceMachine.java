package attendance.controller;

import attendance.model.Crew;
import attendance.model.DayOfWeek;
import attendance.repository.AttendanceRepository;
import attendance.view.InputView;
import attendance.view.OutputView;
import camp.nextstep.edu.missionutils.DateTimes;

public class AttendanceMachine {
    private final AttendanceRepository attendanceRepository;

    public AttendanceMachine(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }


    public void attendanceRun() {
        String input = processRequestFunctionInput();
        processSortInput(input);
    }

    private String processRequestFunctionInput() {
        while (true){
            try {
                OutputView.printTodayAndRequestChoiceFunction();
                OutputView.printFunctionList();
                return InputView.requestFunctionNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void processSortInput(String input) {
        if (input.equals("1")) {
            try {
                OutputView.validateHoliday();
                processCheckAttendance();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                processRequestFunctionInput();
            }
        }
    }

    private void processCheckAttendance() {
        try {
            OutputView.requestNickname();
            String name = InputView.requestNickname();
            OutputView.requestTime();
            String time = InputView.requestTime();
            Crew crew = new Crew(name, 2024, 12, DateTimes.now().getDayOfMonth(),
                    DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()), time);
            attendanceRepository.saveCrewInRepository(crew);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
