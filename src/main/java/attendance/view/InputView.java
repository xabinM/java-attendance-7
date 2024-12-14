package attendance.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String requestFunctionNumber() {
        return Console.readLine().trim();
    }


    private int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("");
        }
    }
}
