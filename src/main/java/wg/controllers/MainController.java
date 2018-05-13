package wg.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import wg.services.Connection;
import wg.services.ConnectionImpl;
import wg.services.UserQuery;
import wg.services.UserQueryImpl;

import java.io.IOException;
import java.time.LocalDate;

public class MainController {

    private String url = "";
    private final String ERROR = "Invalid query format!";

    private UserQuery userQuery;
    private Connection connection;

    @FXML
    private TextField codeTxt;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    private Button submit;
    @FXML
    private Label errorLabel;
    @FXML
    private TextField avgBuyingRate;
    @FXML
    private TextField SD_ofSalesRates;

    public void initialize(){
        userQuery = new UserQueryImpl();
        connection = new ConnectionImpl();
    }


   public void getData() throws IOException {

       errorLabel.setText("");

       String code = codeTxt.getText();

       String start;
       String end;

       LocalDate startDateValue= startDate.getValue();
       LocalDate endDateValue = endDate.getValue();

       if(startDateValue !=null && endDateValue != null && !code.isEmpty()){
           start = startDateValue.toString();
           end = endDateValue.toString();

           url = userQuery.getUrl(code, start, end);

           validConnection();


       } else {
           errorLabel.setText(ERROR);
       }


   }

   private void validConnection() throws IOException {

       if(!connection.isValidConnection(url)){
           errorLabel.setText(ERROR);
       }

   }


    }

