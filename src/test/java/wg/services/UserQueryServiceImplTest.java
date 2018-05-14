package wg.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserQueryServiceImplTest {

    private UserQueryService service;

    @Before
    public void setUp() throws Exception {
        service = new UserQueryServiceImpl();
    }

    @Test
    public void url_address_is_correctly_build() throws Exception {

        String urlTest = "http://api.nbp.pl/api/exchangerates/rates/c/EUR/2017-11-20/2017-11-24";

        String url = service.getUrl("EUR", "2017-11-20", "2017-11-24");

        assertEquals(urlTest, url);
    }

}