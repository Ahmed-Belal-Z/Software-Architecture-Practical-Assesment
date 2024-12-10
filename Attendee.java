import java.io.*;
import java.util.*;

public class Attendee {
    private String name;
    private String email;
    private int attendeeId;
    private List<Session> schedule;

    public Attendee(String name, String email, int attendeeId) {
        this.name = name;
        this.email = email;
        this.attendeeId = attendeeId;
        this.schedule = new ArrayList<>();
    }

    public void addSession(Session session) {
        schedule.add(session);
    }

    public void saveScheduleToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Session session : schedule) {
                writer.write(session.toString());
                writer.newLine();
            }
        }
    }

    public void loadScheduleFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] sessionData = line.split(", ");
                // Assuming you create sessions from loaded data
                Session session = new Session(sessionData[0], sessionData[1], sessionData[2], sessionData[3], sessionData[4]);
                schedule.add(session);
            }
        }
    }

    @Override
    public String toString() {
        return name + ", " + email + ", " + attendeeId;
    }
}


