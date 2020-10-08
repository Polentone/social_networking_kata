package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.AnnotatedArrayType;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class InMemoryPostsTest {
    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "I love the weather today";
    public static final String ANOTHER_MESSAGE = "even though it's raining";

    @Test
    void when_user_post_a_message_then_is_present_when_reading() {
        Posts posts = new InMemoryPosts();
        posts.post(USERNAME, MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(1);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
    }


    @Test
    void when_user_post_two_messages_then_they_are_both_retrieved() {
        Posts posts = new InMemoryPosts();
        posts.post(USERNAME, MESSAGE);
        posts.post(USERNAME, ANOTHER_MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(2);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
        assertThat(messages.get(1)).isEqualTo(ANOTHER_MESSAGE);
    }
}