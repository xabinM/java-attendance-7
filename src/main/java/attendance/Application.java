package attendance;

import attendance.controller.AttendanceMachine;
import attendance.repository.AttendanceRepository;

public class Application {
    public static void main(String[] args) {
        new AttendanceMachine(new AttendanceRepository()).attendanceRun();
    }
}
