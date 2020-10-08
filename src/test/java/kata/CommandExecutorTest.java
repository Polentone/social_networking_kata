package kata;

import kata.posts.Posts;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CommandExecutorTest {
    private Posts posts = mock(Posts.class);

    @Test
    void when_requesting_read_operation_then_read_is_called() {
        Executor executor = new CommandExecutor(posts);
        executor.execute("Alice");
        verify(posts).read("Alice");
    }
}