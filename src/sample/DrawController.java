package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Regret on 24.12.2017.
 */
public class DrawController {
    public void exit() {
        Platform.exit();
        System.exit(0);
    }

    public void back(ActionEvent click) throws Exception {
        Parent main = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene main_screen = new Scene(main);
        Stage main_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
        main_stage.setScene(main_screen);
        main_stage.show();
    }
}
