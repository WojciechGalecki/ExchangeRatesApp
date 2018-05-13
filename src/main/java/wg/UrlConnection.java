package wg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {

    public HttpURLConnection getConnection(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        return connection;
    }
}
