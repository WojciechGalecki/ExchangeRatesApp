package wg.services;

import org.json.JSONArray;

public class ResponseOperationServiceImpl implements ResponseOperationService {

    @Override
    public Double getAvg(JSONArray rates, Double sum) {

        return sum / rates.length();
    }

    @Override
    public Double getStandardDev(JSONArray rates, String typeOfCourse, Double average) {

        Double numerator = 0.0;

        for (int i = 0; i < rates.length() ; i++) {

            Double currencyCourse = (Double) rates.getJSONObject(i).get(typeOfCourse);

            numerator += Math.pow((currencyCourse - average), 2);
        }

        numerator /= rates.length();

        return Math.sqrt(numerator);
    }

    @Override
    public Double getSum(JSONArray rates, String typeOfCourse) {

        Double sum = 0.0;

        for (int i = 0; i < rates.length(); i++) {

            Double currencyCourse = (Double) rates.getJSONObject(i).get(typeOfCourse);
            sum += currencyCourse;
        }
        return sum;
    }
}
