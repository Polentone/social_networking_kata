package kata.posts;

import java.util.Date;

public class Post {
    private final String username;
    private final String message;
    private final Date date;

    public Post(String username, String message, Date date) {
        this.username = username;
        this.message = message;
        this.date = date;
    }

    public String username() {
        return username;
    }

    public String message() {
        return message;
    }

    public String formatMessageForWall() {
        return username + " - " + message + " " + timeSincePost();
    }

    public String formatMessageForRead() {
        return message + timeSincePost();
    }

    private String timeSincePost() {
        if (new Date().getTime() - date.getTime() < 59999) {
            return "(" + (new Date().getTime() - date.getTime()) / 1000 + " seconds ago)";
        } else {
            return "(" + (new Date().getTime() - date.getTime()) / 60000 + " minutes ago)";
        }
    }
}
