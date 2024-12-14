package attendance.view;

import attendance.repository.CrewNameRepository;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    public static String requestFunctionNumber() {
        String input =  Console.readLine().trim();
        validateFunctionNumber(input);
        return input;
    }

    public static String requestNickname() {
        String input = Console.readLine();
        validateRegisteredName(input);
        return input;
    }

    public static String requestTime() {
        String input = Console.readLine();
        String[] temp = input.split(":");
        validateTimeAndMinute(temp);
        return input;
    }

    private static void validateTimeAndMinute(String[] temp) {
        int time = parseInteger(temp[0]);
        int minute = parseInteger(temp[1]);
        if (time > 24 || time < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
        if (minute > 60 || minute < 0) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }

    private static void validateRegisteredName(String input) {
        if (!CrewNameRepository.getNames().contains(input)) {
            throw new IllegalArgumentException("[ERROR] 등록되지 않은 닉네임입니다.");
        }
    }

    private static void validateFunctionNumber(String input) {
        List<String> temp = List.of("1", "2", "3", "4", "Q");

        if (!temp.contains(input)) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식을 입력하였습니다.");
        }
    }


    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
    }
}
