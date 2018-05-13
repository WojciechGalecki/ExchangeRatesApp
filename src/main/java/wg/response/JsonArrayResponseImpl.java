package wg.response;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrayResponseImpl implements JsonArrayResponse {

    @Override
    public JSONArray getJsonArray(String response, String arrayName) {

        JSONObject jsonObject = new JSONObject(response);

        return jsonObject.getJSONArray(arrayName);
    }
}
