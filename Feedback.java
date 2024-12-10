import java.io.*;

public class Feedback {
    private int attendeeId;
    private int rating;
    private String comments;

    public Feedback(int attendeeId, int rating, String comments) {
        this.attendeeId = attendeeId;
        this.rating = rating;
        this.comments = comments;
    }

    public void saveFeedbackToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Attendee ID: " + attendeeId + ", Rating: " + rating + ", Comments: " + comments);
            writer.newLine();
        }
    }
}
