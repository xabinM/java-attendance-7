package attendance.model;

public class Crew {
    private final String name;
    private final int year;
    private final int month;
    private final int day;
    private final String dayOfWeek;
    private String time;
    private String status;
    private String preTime;
    private String preStatus;

    public Crew(String name, int year, int month, int day, String dayOfWeek, String time) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.status = calculateStatus(time);
    }

    private String calculateStatus(String time) {
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
                System.out.println("타아임" + time);
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

    public void setTime(String targetTime) {
        this.preTime = time;
        this.preStatus = status;
        this.time = targetTime;
        this.status = calculateStatus(targetTime);
    }

    public String getStatus() {
        return status;
    }

    public String getPreTime() {
        return preTime;
    }

    public String getPreStatus() {
        return preStatus;
    }
}
