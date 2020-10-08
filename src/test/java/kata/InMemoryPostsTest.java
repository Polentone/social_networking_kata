package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InMemoryPostsTest {
    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "I love the weather today";

    @Test
    void when_user_post_a_message_then_is_present_when_reading() {
        Posts posts = new InMemoryPosts();
        posts.post(USERNAME, MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(1);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
    }
}