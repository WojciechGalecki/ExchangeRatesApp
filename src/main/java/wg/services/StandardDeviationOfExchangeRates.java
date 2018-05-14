package wg.services;

import org.json.JSONArray;

public interface StandardDeviationOfExchangeRates {

    Double getStandardDev(JSONArray rates, String typeOfCourse, Double average);
}
