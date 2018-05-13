package wg.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import wg.parsers.CurrencyCodeParser;

public class MainController {

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


   public void getData(){

        String code = codeTxt.getText();
        String start = startDate.getValue().toString();
        String end = endDate.getValue().toString();

       /* if(!parser.isParseValue(code)){
            errorLabel.setText(parser.getErrorMessage());
        }*/
    }


    }

