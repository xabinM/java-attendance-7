package attendance.repository;

import attendance.model.Crew;
import attendance.model.DayOfWeek;
import attendance.service.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {
    private final List<Crew> repository = new ArrayList<>();

    public AttendanceRepository(){
        readAttendanceInfo();
    }


    private void readAttendanceInfo(){
        List<String> info = null;
        try {
            info = FileReader.readFilePath("src/main/resources/attendances.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 1; i < info.size(); i++) {
            String[] temp = info.get(i).split("[, ]");
            String name = temp[0];
            String[] date = dateSplit(temp[1]);
            String time = temp[2];

            Crew crew = new Crew(name, Integer.parseInt(date[0]), Integer.parseInt(date[1]),
                    Integer.parseInt(date[2]), calculateDayOfWeek(Integer.parseInt(date[2])), time);
            repository.add(crew);
        }
    }

    private String[] dateSplit(String date) {
        return date.split("-");
    }

    private String calculateDayOfWeek(int day) {
        return DayOfWeek.getDayOfWeek((day + 6) % 7);
    }

    public void saveCrewInRepository(Crew crew) {
        repository.add(crew);
    }

    public Crew findCrew(String targetName, int targetDay) {
        return repository.stream()
                .filter(crew -> crew.getName().equals(targetName))
                .filter(crew -> crew.getDay() == targetDay)
                .findFirst()
                .get();
    }
}
