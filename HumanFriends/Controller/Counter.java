package HumanFriends.Controller;

import java.io.File;

public class Counter implements AutoCloseable {
    private int count;
    private boolean closed;

    public Counter() {
        count = 0;
        closed = false;
    }

    @Override
    public void close() {
        closed = true;
        count = 0;
    }

    public void add() {
        if (closed) {
            throw new RuntimeException("Счетчик вышел из блока try_with_resources");
        }
        File file = new File("Counter.db");
        if (file.exists()) {
            String countStr = Controller.loadFromFile("Counter.db");
            if (!countStr.equals(null)) {
                count = Integer.parseInt(countStr);
            }
        }
        count++;
        Controller.saveFromFile(String.valueOf(count), "Counter.db", false);
        System.out.println("\nКоличество записей новых животных равно: " + count + "\n");
    }
}
