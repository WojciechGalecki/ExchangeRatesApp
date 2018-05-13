package wg.parsers;

public interface Parser {
    boolean  isParseValue(String parameter);
    String getErrorMessage();
}
