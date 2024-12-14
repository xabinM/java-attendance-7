package attendance.view;

import attendance.model.Crew;
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

    public static void printAttendanceInfo(Crew crew) {
        System.out.printf("12월 %d일 %s %s (%s)",
                DateTimes.now().getDayOfMonth(), crew.getDayOfWeek(), crew.getTime(), crew.getStatus());
    }

    public static void printEditMessage1() {
        System.out.println("출석을 수정하려는 크루의 닉네임을 입력해 주세요.");
    }

    public static void printEditMessage2() {
        System.out.println("수정하려는 날짜(일)를 입력해 주세요.");
    }

    public static void printEditMessage3(){
        System.out.println("언제로 변경하겠습니까?");
    }

    public static void printEditMessage4(Crew crew) {
        System.out.printf("12월 %d일 %s %s (%s) -> %s (%s) 수정 완료!", crew.getDay(), crew.getDayOfWeek(),
                crew.getPreTime(), crew.getPreStatus(), crew.getTime(), crew.getStatus());
    }
}
