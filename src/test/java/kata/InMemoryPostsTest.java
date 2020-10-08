package kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryPostsTest {
    public static final String USERNAME = "Alice";
    public static final String ANOTHER_USERNAME = "Bobby";
    public static final String MESSAGE = "I love the weather today";
    public static final String ANOTHER_MESSAGE = "even though it's raining";

    private Posts posts;

    @BeforeEach
    void setUp() {
        posts = new InMemoryPosts();
    }

    @Test
    void when_user_post_a_message_then_is_present_when_reading() {
        posts.post(USERNAME, MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(1);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
    }

    @Test
    void when_user_post_two_messages_then_they_are_both_retrieved() {
        posts.post(USERNAME, MESSAGE);
        posts.post(USERNAME, ANOTHER_MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(2);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
        assertThat(messages.get(1)).isEqualTo(ANOTHER_MESSAGE);
    }

    @Test
    void when_two_users_post_a_message_then_the_correct_one_is_retrieved() {
        posts.post(USERNAME, MESSAGE);
        posts.post(ANOTHER_USERNAME, ANOTHER_MESSAGE);

        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(1);
        assertThat(messages.get(0)).isEqualTo(MESSAGE);
    }

    @Test
    void if_a_user_has_no_messages_then_an_empty_list_is_returned() {
        List<String> messages = posts.read(USERNAME);

        assertThat(messages).hasSize(0);
    }
}