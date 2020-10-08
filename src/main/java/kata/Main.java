package kata;

import kata.posts.InMemoryPosts;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final Executor executor = new CommandExecutor(new InMemoryPosts());

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = reader.readLine();
            if (command.equals("exit"))
                return;
            else
                executor.execute(command);
        }
    }
}
