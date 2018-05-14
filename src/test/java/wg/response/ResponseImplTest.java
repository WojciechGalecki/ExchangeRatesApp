package wg.response;

import org.junit.Before;
import org.junit.Test;
import wg.connection.UrlConnection;

import java.net.HttpURLConnection;
import java.util.Optional;

import static org.junit.Assert.*;

public class ResponseImplTest {

    private Response response;
    private HttpURLConnection connection, connection2;
    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/EUR/2017-11-20/2017-11-24/";
    private final String BAD_URL = "http://api.nbp.pl/api/exchangerates/rates/c/EURRRRRRRR/2017-12-20/2017-11-24/";

    @Before
    public void setUp() throws Exception {
        response = new ResponseImpl();
        connection = UrlConnection.getConnection(URL);
        connection2 = UrlConnection.getConnection(BAD_URL);
    }

    @Test
    public void response_will_return_the_present_optional() throws Exception {

        Optional<String> optional = response.getResponse(connection);

        assertTrue(optional.isPresent());
    }

    @Test
    public void response_will_return_the_empty_optional() throws Exception {

        Optional<String> optional = response.getResponse(connection2);

        Optional<String> empty = Optional.empty();

        assertEquals(empty, optional);
    }


}