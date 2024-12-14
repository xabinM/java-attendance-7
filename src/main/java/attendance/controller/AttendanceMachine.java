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
        try {
            OutputView.printTodayAndRequestChoiceFunction();
            OutputView.printFunctionList();
            return InputView.requestFunctionNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    private void processSortInput(String input) {
        if (input.equals("1")) {
            try {
//                validateHoliday();
                processCheckAttendance();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else if (input.equals("2")) {
            processEdit();
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
            OutputView.printAttendanceInfo(crew);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void processEdit() {
        OutputView.printEditMessage1();
        String name = InputView.requestNickname();
        OutputView.printEditMessage2();
        int day = InputView.requestEditDay();
        OutputView.printEditMessage3();
        String time = InputView.requestTime();
        Crew crew = attendanceRepository.findCrew(name, day);
        crew.setTime(time);
        OutputView.printEditMessage4(crew);
    }

    private static void validateHoliday() {
        String errorMessage = String.format("[ERROR] %d월 %d일 %s은 등교일이 아닙니다.", DateTimes.now().getMonthValue(), DateTimes.now().getDayOfMonth(),
                DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()));
        if (DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()).equals("토요일") ||
                DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()).equals("일요일")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
