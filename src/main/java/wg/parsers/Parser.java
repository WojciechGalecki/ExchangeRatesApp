package wg.parsers;

import java.util.Optional;

public interface Parser {
    boolean  isParseValue(Optional<String> optionalParameter);
    String getErrorMessage();
}
