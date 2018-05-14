package wg.connection;

import org.junit.Test;

import java.net.HttpURLConnection;
import static org.junit.Assert.*;


public class UrlConnectionTest {

    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/EUR/2017-11-20/2017-11-24/";

    @Test
    public void getConnectionTest() throws Exception {

        HttpURLConnection connection = UrlConnection.getConnection(URL);

        assertTrue(connection.getResponseCode() == HttpURLConnection.HTTP_OK);

    }

}