package wg.response;

import org.json.JSONArray;

public interface JsonArrayResponse {

    JSONArray getJsonArray(String response, String arrayName);
}
