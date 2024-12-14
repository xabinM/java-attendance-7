package attendance.repository;

import java.util.List;

public class CrewNameRepository {
    private static final List<String> names = List.of("빙티", "이든", "빙봉", "쿠키", "짱수");

    public static List<String> getNames() {
        return names;
    }
}
