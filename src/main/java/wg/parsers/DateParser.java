package wg.parsers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateParser implements Parser {

    @Override
    public boolean isParseValue(String parameter) {
        boolean condition = true;

        try {
            LocalDate testDate = LocalDate.parse(parameter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return condition;
    }

    @Override
    public String getErrorMessage() {
        return "Invalid date format!";
    }
}
