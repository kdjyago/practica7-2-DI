package Controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class controladorCALCU {

    @FXML
    private TextField displayField;

    private double num1 = 0;
    private String operator = "";
    private boolean start = true;

    public void addToDisplay(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        displayField.setText(displayField.getText() + value);
    }

    @FXML
    public void reset(ActionEvent event) {
        displayField.setText("");
        operator = "";
        start = true;
    }

    @FXML
    public void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            num1 = Double.parseDouble(displayField.getText());
            displayField.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            double num2 = Double.parseDouble(displayField.getText());
            double result = calculate(num1, num2, operator);
            displayField.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}