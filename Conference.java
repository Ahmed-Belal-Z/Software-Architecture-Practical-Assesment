import java.io.*;
import java.util.*;

public class Conference {
    private String name;
    private String startDate;
    private String endDate;
    private List<Session> sessions;
    private List<Attendee> attendees;

    public Conference(String name, String startDate, String endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sessions = new ArrayList<>();
        this.attendees = new ArrayList<>();
    }

    public void addSession(Session session) {
        sessions.add(session);
    }

    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
    }

    public void saveSessionsToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Session session : sessions) {
                writer.write(session.toString());
                writer.newLine();
            }
        }
    }

    public void loadSessionsFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming you have a constructor to parse session data from string
                // Here I'm assuming a simple format; adjust as needed
                String[] sessionData = line.split(", ");
                Session session = new Session(sessionData[0], sessionData[1], sessionData[2], sessionData[3], sessionData[4]);
                sessions.add(session);
            }
        }
    }

    public void saveAttendeesToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Attendee attendee : attendees) {
                writer.write(attendee.toString());
                writer.newLine();
            }
        }
    }

    public void loadAttendeesFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attendeeData = line.split(", ");
                Attendee attendee = new Attendee(attendeeData[0], attendeeData[1], Integer.parseInt(attendeeData[2]));
                attendees.add(attendee);
            }
        }
    }
}
