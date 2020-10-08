package kata;

import kata.posts.Posts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CommandExecutorTest {
    public static final String READ_COMMAND = "Alice";
    private final Posts posts = mock(Posts.class);

    @Test
    void when_requesting_read_operation_then_read_is_called() {
        Executor executor = new CommandExecutor(posts);

        executor.execute(READ_COMMAND);

        verify(posts).read(READ_COMMAND);
    }

    @Test
    void when_requesting_posting_operation_then_post_is_called() {
        Executor executor = new CommandExecutor(posts);

        executor.execute("Alice -> I love the weather today");

        verify(posts).post("Alice", "I love the weather today");
    }
}