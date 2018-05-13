package wg.services;

import java.io.IOException;

public interface Connection {

    boolean isValidConnection(String url) throws IOException;
}
