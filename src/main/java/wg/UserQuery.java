package wg;

public class UserQuery {

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/";
    private final String S = "/";

    private StringBuilder stringBuilder = new StringBuilder();

    public String getUrl(String currencyCode, String startDate, String endDate){

        stringBuilder.append(URL)
                .append(currencyCode).append(S)
                .append(startDate).append(S)
                .append(endDate);

        return stringBuilder.toString();
    }
}
