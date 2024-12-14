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
        this.status = calculateStatus(dayOfWeek, time);
    }

    private String calculateStatus(String dayOfWeek, String time) {
        String temp = time.replace(":", "");
        if (dayOfWeek.equals("월요일")) {
            if (Integer.parseInt(temp) <= 1305) {
                return "출석";
            } else if (Integer.parseInt(temp) > 1305) {
                return "지각";
            } else if (Integer.parseInt(temp) > 1330) {
                return "결석";
            }
        } else {
            if (Integer.parseInt(temp) <= 1005) {
                return "출석";
            } else if (Integer.parseInt(temp) > 1005) {
                return "지각";
            } else if (Integer.parseInt(temp) > 1030) {
                return "결석";
            }
        }
        return "";
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }
}
