package wg;

import org.json.JSONObject;

public class JsonResponse {

    public JSONObject getJsonResponse(String response){
        return new JSONObject(response);
    }
}
