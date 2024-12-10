import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            // Create directories if they don't exist
            File sessionsDir = new File("sessions");
            if (!sessionsDir.exists()) {
                sessionsDir.mkdirs();
            }

            File attendeesDir = new File("attendees");
            if (!attendeesDir.exists()) {
                attendeesDir.mkdirs();
            }

            File feedbackDir = new File("feedback");
            if (!feedbackDir.exists()) {
                feedbackDir.mkdirs();
            }

            // Create some sample sessions and attendees
            Speaker speaker = new Speaker("Dr. John Smith", "AI Specialist");
            Session session1 = new Session("Introduction to AI", speaker.getName(), "2025-06-01", "10:00 AM", "Room 101");
            Attendee attendee1 = new Attendee("Dr. Abram", "abram@example.com", 1001);

            // Add session and attendee to the conference
            Conference conference = new Conference("GAF-AI 2025", "2025-06-01", "2025-06-07");
            conference.addSession(session1);
            conference.addAttendee(attendee1);

            // Save the data to files
            conference.saveSessionsToFile("sessions/sessions.txt");
            conference.saveAttendeesToFile("attendees/attendees.txt");

            // Load data from files
            conference.loadSessionsFromFile("sessions/sessions.txt");
            conference.loadAttendeesFromFile("attendees/attendees.txt");

            // Attendee selects a session and adds it to their schedule
            attendee1.addSession(session1);
            attendee1.saveScheduleToFile("attendees/schedule_1001.txt");

            // Save and load feedback
            Feedback feedback = new Feedback(1001, 5, "Great session!");
            feedback.saveFeedbackToFile("feedback/feedback.txt");

        } catch (IOException e) {
            e.printStackTrace(); // Print the error for debugging
        }
    }
}
