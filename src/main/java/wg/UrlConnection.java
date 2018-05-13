package wg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {

    public static HttpURLConnection getConnection(String url) throws IOException {

        URL obj = new URL(url);
        return (HttpURLConnection) obj.openConnection();
    }
}
