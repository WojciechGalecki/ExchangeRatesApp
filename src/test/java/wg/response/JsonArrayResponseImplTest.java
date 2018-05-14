package wg.response;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import wg.connection.UrlConnection;

import static org.junit.Assert.*;

public class JsonArrayResponseImplTest {

    private JsonArrayResponse jsonArrayResponse;
    private Response response;
    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/EUR/2017-11-20/2017-11-24/";

    @Before
    public void setUp() throws Exception {
        jsonArrayResponse = new JsonArrayResponseImpl();
        response = new ResponseImpl();
    }

    @Test
    public void getJsonArrayTest() throws Exception {

        String resp = response.getResponse(UrlConnection.getConnection(URL)).get();

        JSONArray rates = jsonArrayResponse.getJsonArray(resp, "rates");

        assertNotNull(rates);
        assertNotNull(rates.getJSONObject(1));
    }

}