package HumanFriends;

import java.time.DateTimeException;

public class DateTimeParseException extends DateTimeException {
    public DateTimeParseException(String message, Throwable cause) {
        super(message, cause);
    }

}
