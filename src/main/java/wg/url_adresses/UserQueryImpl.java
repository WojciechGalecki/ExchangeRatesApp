package wg.url_adresses;

public class UserQueryImpl implements UserQuery{

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/";
    private final String S = "/";

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    /**
     * @param parameters must includes 3 Strings:
     *                   [0] - currency code (EUR)
     *                   [1] - start date (RRRR-MM-DD)
     *                   [2] - end date (RRRR-MM-DD)
     */
    public String getUrl(String... parameters) {

        stringBuilder.append(URL)
                .append(parameters[0]).append(S)
                .append(parameters[1]).append(S)
                .append(parameters[2]);

        return stringBuilder.toString();
    }
}
