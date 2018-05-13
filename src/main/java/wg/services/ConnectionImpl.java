package wg.services;

import wg.UrlConnection;

import java.io.IOException;
import java.net.HttpURLConnection;

public class ConnectionImpl implements Connection{

    private UrlConnection urlConnection;

    public ConnectionImpl() {
        this.urlConnection = new UrlConnection();
    }

    @Override
    public boolean isValidConnection(String url) throws IOException {
        boolean condition = true;

        HttpURLConnection connection = urlConnection.getConnection(url);
        int responseCode = connection.getResponseCode();

        if(responseCode != HttpURLConnection.HTTP_OK){
            condition = false;
        }
        return condition;
    }
}
