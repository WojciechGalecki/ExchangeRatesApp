package wg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Optional;

public interface Response {

    Optional<String> getResponse(HttpURLConnection connection) throws IOException;
}
