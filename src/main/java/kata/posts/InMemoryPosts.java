package kata.posts;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryPosts implements Posts {
    List<Following> followers = new ArrayList<>();
    List<Post> posts = new ArrayList<>();

    @Override
    public void post(String username, String message) {
        posts.add(0, new Post(username, message, new Date()));
    }

    @Override
    public List<String> read(String username) {
        return posts.stream()
                .filter(hasUserPostMessage(username))
                .map(Post::formatMessageForRead)
                .collect(Collectors.toList());
    }

    @Override
    public void follows(String follower, String user) {
        followers.add(new Following(follower, user));
    }

    @Override
    public List<String> wall(String user) {
        return posts.stream()
                .filter(hasUserPostMessageOrFollowsTheOneThatPostedIt(user))
                .map(Post::formatMessageForWall)
                .collect(Collectors.toList());
    }

    private Predicate<Post> hasUserPostMessage(String username) {
        return post -> username.equals(post.username());
    }

    private Predicate<Post> hasUserPostMessageOrFollowsTheOneThatPostedIt(String user) {
        return post -> user.equals(post.username()) ||
                followTheOneThatPostedIt(user, post);
    }

    private boolean followTheOneThatPostedIt(String user, Post post) {
        return followers.stream().filter(f -> f.follower().equals(user))
                .anyMatch(f -> post.username().equals(f.user()));
    }
}
