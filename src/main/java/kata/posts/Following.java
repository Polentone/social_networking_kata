package kata.posts;

public class Following {
    private final String follower;
    private final String user;

    public Following(String follower, String user) {
        this.follower = follower;
        this.user = user;
    }

    public String follower() {
        return follower;
    }

    public String user() {
        return user;
    }
}
