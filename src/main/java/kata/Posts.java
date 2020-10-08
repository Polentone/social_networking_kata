package kata;

import java.util.List;

public interface Posts {
    void post(String username, String message);

    List<String> read(String username);
}
