package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class IncrementUIController implements Initializable {

    @FXML
    private Text txtOutput;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private void icrementValue(){
        int num=Integer.parseInt(txtOutput.getText());
        num++;
        txtOutput.setText(String.valueOf(num));
    }
}
