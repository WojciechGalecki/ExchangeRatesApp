package wg.services;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;
import wg.connection.UrlConnection;
import wg.response.JsonArrayResponse;
import wg.response.JsonArrayResponseImpl;
import wg.response.Response;
import wg.response.ResponseImpl;

import java.net.HttpURLConnection;

import static org.junit.Assert.*;

public class ResponseOperationServiceImplTest {

    private ResponseOperationService service;
    private HttpURLConnection connection;
    private JsonArrayResponse jsonArrayResponse;
    private Response response;
    private JSONArray jsonArray;
    private final String URL = "http://api.nbp.pl/api/exchangerates/rates/c/EUR/2018-05-11/2018-05-12/";



    @Before
    public void setUp() throws Exception {
        service = new ResponseOperationServiceImpl();
        connection = UrlConnection.getConnection(URL);
        response = new ResponseImpl();
        jsonArrayResponse = new JsonArrayResponseImpl();

        jsonArray = jsonArrayResponse.getJsonArray(response.getResponse(connection).get(), "rates");
        System.out.println(jsonArray);
    }

    @Test
    public void getAvgTest() throws Exception {

        Double avg = service.getAvg(jsonArray, service.getSum(jsonArray, "ask"));

        assertNotNull(avg);
        assertTrue(avg == 4.2896);
    }

    @Test
    public void getStandardDevTest() throws Exception {

        Double sd = service.getStandardDev(jsonArray, "ask", 4.2896);

        assertNotNull(sd);
        assertEquals(0.0, sd, 0.0);
    }

    @Test
    public void getSumTest() throws Exception {

        Double sum = service.getSum(jsonArray, "bid");

        Double d = 4.2046;

        assertNotNull(sum);
        assertEquals(d, sum);
    }

}