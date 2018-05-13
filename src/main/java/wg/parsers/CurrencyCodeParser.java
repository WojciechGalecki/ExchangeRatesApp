package wg.parsers;

import java.util.Optional;

public class CurrencyCodeParser implements Parser {

    @Override
    public boolean isParseValue(Optional<String> optionalParameter) {
        boolean condition = true;

        if(optionalParameter.isPresent() && optionalParameter.get().length() != 3){
            condition = false;
        }

        return condition;
    }

    @Override
    public String getErrorMessage() {
        return "The code must consist of three characters!";
    }
}
