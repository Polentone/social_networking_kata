package kata.posts;

import java.util.List;

public interface Posts {
    void post(String username, String message);

    List<String> read(String username);

    void follows(String follower, String user);

    List<String> wall(String user);
}
