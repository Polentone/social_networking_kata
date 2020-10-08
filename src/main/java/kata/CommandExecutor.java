package kata;

import kata.posts.Posts;

public class CommandExecutor implements Executor {
    private final Posts posts;

    public CommandExecutor(Posts posts) {
        this.posts = posts;
    }

    @Override
    public void execute(String command) {
        if (command.contains(" -> ")) {
            String[] split = command.split(" -> ");
            posts.post(split[0], split[1]);
        } else if (command.contains(" follows ")) {
            String[] split = command.split(" follows ");
            posts.follows(split[0], split[1]);
        } else if (command.contains(" wall")) {
            String[] split = command.split(" wall");
            posts.wall(split[0]);
        } else {
            posts.read(command);
        }
    }
}
