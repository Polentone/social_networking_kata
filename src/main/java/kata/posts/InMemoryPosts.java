package kata.posts;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryPosts implements Posts {
    Map<String, String> followers = new HashMap<>();
    List<Post> posts = new ArrayList<>();

    @Override
    public void post(String username, String message) {
        posts.add(new Post(username, message));
    }

    @Override
    public List<String> read(String username) {
        return posts.stream()
                .filter(p -> username.equals(p.username()))
                .map(Post::message)
                .collect(Collectors.toList());
    }

    @Override
    public void follows(String follower, String user) {
        followers.put(follower, user);
    }

    @Override
    public List<String> wall(String user) {
        return posts.stream().filter(p -> user.equals(p.username()) || p.username().equals(followers.get(user)))
                .map(Post::message)
                .collect(Collectors.toList());
    }
}
