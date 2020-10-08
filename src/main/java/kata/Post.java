package kata;

public class Post {
    private final String username;
    private final String message;

    public Post(String username, String message) {
        this.username = username;
        this.message = message;
    }

    public String username() {
        return username;
    }

    public String message() {
        return message;
    }
}
