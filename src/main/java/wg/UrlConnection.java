package wg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {

    private HttpURLConnection connection;

    public HttpURLConnection getConnection(String url) throws IOException {

        URL obj = new URL(url);
        this.connection = (HttpURLConnection) obj.openConnection();

        return connection;
    }

    public int getResponseCode() throws IOException {
        return this.connection.getResponseCode();
    }
}
