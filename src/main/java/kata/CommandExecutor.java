package kata;

import kata.posts.Posts;

public class CommandExecutor implements Executor {
    private final Posts posts;

    public CommandExecutor(Posts posts) {
        this.posts = posts;
    }

    @Override
    public void execute(String command) {
        if (isPostCommand(command)) {
            String[] split = command.split(" -> ");
            posts.post(split[0], split[1]);
        } else if (isFollowCommand(command)) {
            String[] split = command.split(" follows ");
            posts.follows(split[0], split[1]);
        } else if (isWallCommand(command)) {
            String[] split = command.split(" wall");
            posts.wall(split[0]);
        } else {
            posts.read(command);
        }
    }

    private boolean isWallCommand(String command) {
        return command.contains(" wall");
    }

    private boolean isFollowCommand(String command) {
        return command.contains(" follows ");
    }

    private boolean isPostCommand(String command) {
        return command.contains(" -> ");
    }
}
