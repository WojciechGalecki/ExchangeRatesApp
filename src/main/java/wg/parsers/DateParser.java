package wg.parsers;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class DateParser implements Parser {

    @Override
    public boolean isParseValue(Optional<String> optionalParameter) {
        boolean condition = true;

        if (optionalParameter.isPresent()) {
            try {
                LocalDate testDate = LocalDate.parse(optionalParameter.get());
            } catch (DateTimeParseException e) {
                return false;
            }
        }
        return condition;
    }

    @Override
    public String getErrorMessage() {
        return "Invalid date format!";
    }
}
