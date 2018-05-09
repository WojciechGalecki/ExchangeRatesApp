package wg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Optional;

public class ResponseImpl implements Response {

    @Override
    public Optional<String> getResponse(HttpURLConnection connection) throws IOException {

        Optional<String> optionalResponse = Optional.empty();

        int responseCode = connection.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK){

            BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = input.readLine()) != null) {
                response.append(inputLine);
            }

            String responseString = response.toString();
            optionalResponse = Optional.of(responseString);
        }
        return optionalResponse;
    }
}
