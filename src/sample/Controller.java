package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {


    public void start (ActionEvent click) throws Exception {
        Parent game = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene game_screen = new Scene(game);
        Stage game_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
        game_stage.setScene(game_screen);
        game_stage.show();
    }

    public void exit () {
        Platform.exit();
        System.exit(0);
    }
}