package kata;

import kata.posts.Posts;

public class CommandExecutor implements Executor {
    private final Posts posts;

    public CommandExecutor(Posts posts) {
        this.posts = posts;
    }

    @Override
    public void execute(String command) {
        posts.read(command);
    }
}
