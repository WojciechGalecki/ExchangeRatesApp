package wg.services;

import org.json.JSONArray;

public interface AverageOfExchangeRates {

    Double getAvg(JSONArray rates, Double sum);
}
