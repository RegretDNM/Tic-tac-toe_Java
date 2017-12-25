package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
//import javax.swing.text.html.ImageView;
//import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Regret on 23.12.2017.
 */
public class GameController {
    boolean flag = true, is_win = false;
    String figure;
    int count = 0;

    @FXML
    private Label p1;
    @FXML
    private Label p2;
    @FXML
    private Label p3;
    @FXML
    private Label p4;
    @FXML
    private Label p5;
    @FXML
    private Label p6;
    @FXML
    private Label p7;
    @FXML
    private Label p8;
    @FXML
    private Label p9;

    public boolean win_check (boolean win) {
        String check1 = p1.getText();
        String check2 = p2.getText();
        String check3 = p3.getText();
        String check4 = p4.getText();
        String check5 = p5.getText();
        String check6 = p6.getText();
        String check7 = p7.getText();
        String check8 = p8.getText();
        String check9 = p9.getText();

        go_on: while (1 > 0) {
            if (check1 != "" && check1 == check2 && check1 == check3) {
                    win = true;
                    break go_on;
            }

            if (check4 != "" && check4 == check5 && check4 == check6) {
                    win = true;
                    break go_on;
            }

            if (check7 != "" && check7 == check8 && check7 == check9) {
                    win = true;
                    break go_on;
            }

            if (check1 != "" && check1 == check4 && check1 == check7) {
                    win = true;
                    break go_on;
            }

            if (check2 != "" && check2 == check5 && check2 == check8) {
                    win = true;
                    break go_on;
            }

            if (check3 != "" && check3 == check6 && check3 == check9) {
                    win = true;
                    break go_on;
            }

            if (check1 != "" && check1 == check5 && check1 == check9) {
                    win = true;
                    break go_on;
            }

            if (check3 != "" && check3 == check5 && check3 == check7) {
                    win = true;
                    break go_on;
            }

            break;
        }

        return win;
    }

    public void draw1(ActionEvent click) throws Exception {
       String check = p1.getText();

       if (check != "X" && check != "O") {
           if (flag) {
               figure = "X";
           }
           else {
               figure = "O";
           }

           p1.setText(figure);

           is_win = win_check(is_win);
           if (is_win) {
               if (flag) {
                   Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                   Scene p1wins_screen = new Scene(p1wins);
                   Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                   p1wins_stage.setScene(p1wins_screen);
                   p1wins_stage.show();
               }
               else {
                   Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                   Scene p2wins_screen = new Scene(p2wins);
                   Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                   p2wins_stage.setScene(p2wins_screen);
                   p2wins_stage.show();
               }
               count--;
           }

           flag = !flag;


           count++;
           if (count > 8) {
               Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
               Scene draw_screen = new Scene(draw);
               Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
               draw_stage.setScene(draw_screen);
               draw_stage.show();
           }
       }
    }

    public void draw2(ActionEvent click) throws Exception {
        String check = p2.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p2.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw3(ActionEvent click) throws Exception {
        String check = p3.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p3.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw4(ActionEvent click) throws Exception {
        String check = p4.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p4.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw5(ActionEvent click) throws Exception {
        String check = p5.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p5.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw6(ActionEvent click) throws Exception {
        String check = p6.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p6.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw7(ActionEvent click) throws Exception {
        String check = p7.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p7.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw8(ActionEvent click) throws Exception {
        String check = p8.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p8.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }

    public void draw9(ActionEvent click) throws Exception {
        String check = p9.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            }
            else {
                figure = "O";
            }

            p9.setText(figure);

            is_win = win_check(is_win);
            if (is_win) {
                if (flag) {
                    Parent p1wins = FXMLLoader.load(getClass().getResource("p1wins.fxml"));
                    Scene p1wins_screen = new Scene(p1wins);
                    Stage p1wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p1wins_stage.setScene(p1wins_screen);
                    p1wins_stage.show();
                }
                else {
                    Parent p2wins = FXMLLoader.load(getClass().getResource("p2wins.fxml"));
                    Scene p2wins_screen = new Scene(p2wins);
                    Stage p2wins_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                    p2wins_stage.setScene(p2wins_screen);
                    p2wins_stage.show();
                }
                count--;
            }

            flag = !flag;

            count++;
            if (count > 8) {
                Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                Scene draw_screen = new Scene(draw);
                Stage draw_stage = (Stage) ((Node) click.getSource()).getScene().getWindow();
                draw_stage.setScene(draw_screen);
                draw_stage.show();
            }
        }
    }


}
