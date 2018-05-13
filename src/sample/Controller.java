package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static sample.Main.MainStage;

public class Controller {

    public void start (ActionEvent click) throws Exception {
        Parent game = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene game_screen = new Scene(game);
        MainStage.setScene(game_screen);
        MainStage.show();
    }

    public void compStart (ActionEvent click) throws Exception {
        Parent game = FXMLLoader.load(getClass().getResource("compgame.fxml"));
        Scene game_screen = new Scene(game);
        MainStage.setScene(game_screen);
        MainStage.show();
    }

    public void minimaxStart (ActionEvent click) throws Exception {
        Parent game = FXMLLoader.load(getClass().getResource("minimaxgame.fxml"));
        Scene game_screen = new Scene(game);
        MainStage.setScene(game_screen);
        MainStage.show();
    }

    public void exit () {
        Platform.exit();
        System.exit(0);
    }
}
