package attendance.model;

public class Crew {
    private final String name;
    private final int year;
    private final int month;
    private final int day;
    private final String dayOfWeek;
    private String time;
    private String status;
    private int preTime;
    private String preStatus;

    public Crew(String name, int year, int month, int day, String dayOfWeek, String time) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
    }
}
