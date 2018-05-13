package wg.parsers;

public class CurrencyCodeParser implements Parser {

    @Override
    public boolean isParseValue(String parameter) {
        boolean condition = true;

        if(parameter.length() != 3){
            condition = false;
        }

        return condition;
    }

    @Override
    public String getErrorMessage() {
        return "The code must consist of three characters!";
    }
}
