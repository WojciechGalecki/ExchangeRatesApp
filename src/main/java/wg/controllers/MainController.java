package wg.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.json.JSONArray;
import wg.UrlConnection;
import wg.response.JsonArrayResponse;
import wg.response.JsonArrayResponseImpl;
import wg.response.Response;
import wg.response.ResponseImpl;
import wg.services.UserQueryService;
import wg.services.UserQueryServiceImpl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.time.LocalDate;
import java.util.Optional;

public class MainController {

    private String url = "";
    private final String ERROR = "Invalid Query Format!";
    private final String BAD_REQUEST = "Bad Request or Not Found!";
    private HttpURLConnection httpURLConnection;
    private Optional<String> optionalResponse;
    private JSONArray rates;

    private UserQueryService userQueryService;
    private Response response;
    private JsonArrayResponse jsonArrayResponse;


    @FXML
    private TextField codeTxt;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField avgBuyingRate;
    @FXML
    private TextField SD_ofSalesRates;

    public void initialize() {
        userQueryService = new UserQueryServiceImpl();
        response = new ResponseImpl();
        jsonArrayResponse = new JsonArrayResponseImpl();
    }


    public void getData() throws IOException {

        if (validInputData()) {
            httpURLConnection = UrlConnection.getConnection(url);
            optionalResponse = response.getResponse(httpURLConnection);
            if (validResponse(optionalResponse)) {
                rates = jsonArrayResponse.getJsonArray(optionalResponse.get(), "rates");
            }
        }
        if(rates != null){
            System.out.println("OK");
        }

    }

    private boolean validInputData() {

        boolean isValid = true;

        errorLabel.setText("");

        String code = codeTxt.getText();

        String start;
        String end;

        LocalDate startDateValue = startDate.getValue();
        LocalDate endDateValue = endDate.getValue();

        if (startDateValue != null && endDateValue != null && !code.isEmpty()) {
            start = startDateValue.toString();
            end = endDateValue.toString();
            url = userQueryService.getUrl(code, start, end);
        } else {
            errorLabel.setText(ERROR);
            isValid = false;
        }

        return isValid;
    }

    private boolean validResponse(Optional<String> optionalResponse) {

        boolean isValid = true;

        errorLabel.setText("");

        if (!optionalResponse.isPresent()) {
            errorLabel.setText(BAD_REQUEST);
            isValid = false;
        }
        return isValid;
    }
}




