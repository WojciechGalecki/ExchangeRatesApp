package wg.response;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonResponse {

    public JSONObject getJsonResponse(String response){
        return new JSONObject(response);
    }

    public JSONArray getJsonArrayResponse(JSONObject jsonObject, String arrayName){

        return jsonObject.getJSONArray(arrayName);
    }
}
