package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Main.MainStage;

//Controller for all winscreens (p1/p2/comp wins, draw)


/**
 * Created by Regret on 24.12.2017.
 */
public class DrawController {
    public void exit() {
        Platform.exit();
        System.exit(0);
    }

    public void back(ActionEvent click) throws Exception {
        Parent back = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene back_screen = new Scene(back);
        MainStage.setScene(back_screen);
        MainStage.show();
    }
}
