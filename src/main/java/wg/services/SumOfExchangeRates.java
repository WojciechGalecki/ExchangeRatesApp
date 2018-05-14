package wg.services;

import org.json.JSONArray;

public interface SumOfExchangeRates {

    Double getSum(JSONArray rates, String typeOfCourse);

}
