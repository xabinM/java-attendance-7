package attendance.view;

import attendance.model.DayOfWeek;
import camp.nextstep.edu.missionutils.DateTimes;

public class OutputView {

    public static void printTodayAndRequestChoiceFunction() {
        System.out.printf("오늘은 %d월 %d일 %s입니다. 기능을 선택해주세요.\n",
                DateTimes.now().getMonthValue(), DateTimes.now().getDayOfMonth(),
                DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()));
    }

    public static void printFunctionList() {
        System.out.println("1. 출석 확인");
        System.out.println("2. 출석 수정");
        System.out.println("3. 크루별 출석 기록 확인");
        System.out.println("4. 제적 위험자 확인");
        System.out.println("Q. 종료");
    }

    public static void requestNickname() {
        System.out.println("닉네임을 입력해 주세요.");
    }

    public static void requestTime() {
        System.out.println("등교 시간을 입력해 주세요.");
    }

    public static void printAttendanceInfo() {
        System.out.println();
    }

    public static void validateHoliday() {
        String errorMessage = String.format("[ERROR] %d월 %d일 %s은 등교일이 아닙니다.", DateTimes.now().getMonthValue(), DateTimes.now().getDayOfMonth(),
                DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()));
        if (DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()).equals("토요일") ||
                DayOfWeek.getDayOfWeek(DateTimes.now().getDayOfWeek().getValue()).equals("일요일")) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
