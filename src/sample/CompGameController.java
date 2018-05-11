package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.*;
//import
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static sample.Main.MainStage;

/**
 * Created by Regret on 18.02.2018.
 */
public class CompGameController {

    boolean flag = true, is_win = false;
    String figure;
    int count = 0;

    Random random = new Random();
    /*int setup = (random.nextInt(2));

    public int getSetup() {
        return setup;
    }*/

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

    public int checkChar(int find, Label point) {
        String check = point.getText();

        if (check != "X" && check != "O") {
            find = 1;
        }

        return find;
    }

    public void compTurn() {
        int check = (random.nextInt(9)), find = 0;//Рандомно генерируется значение от 0 до 8, для выбора клетки, find — проверка нахождения символа в выбранной клетке

        switch (check) {
            case 0: find = checkChar(find, p1);
                if (find  == 1){
                    draw(p1);
                }
                else compTurn();
                break;

            case 1: find = checkChar(find, p2);
                if (find  == 1){
                    draw(p2);
                }
                else compTurn();
                break;

            case 2: find = checkChar(find, p3);
                if (find  == 1){
                    draw(p3);
                }
                else compTurn();
                break;

            case 3: find = checkChar(find, p4);
                if (find  == 1){
                    draw(p4);
                }
                else compTurn();
                break;

            case 4: find = checkChar(find, p5);
                if (find  == 1){
                    draw(p5);
                }
                else compTurn();
                break;

            case 5: find = checkChar(find, p6);
                if (find  == 1){
                    draw(p6);
                }
                else compTurn();
                break;

            case 6: find = checkChar(find, p7);
                if (find  == 1){
                    draw(p7);
                }
                else compTurn();
                break;

            case 7: find = checkChar(find, p8);
                if (find  == 1){
                    draw(p8);
                }
                else compTurn();
                break;

            case 8: find = checkChar(find, p9);
                if (find  == 1){
                    draw(p9);
                }
                else compTurn();
                break;

        }
    }

    public void who_win (boolean flag) throws Exception {
        try {
            if (flag) {
                Parent pwins = FXMLLoader.load(getClass().getResource("pwins.fxml"));
                Scene pwins_screen = new Scene(pwins);
                MainStage.setScene(pwins_screen);
                MainStage.show();
            }
            else {
                Parent plost = FXMLLoader.load(getClass().getResource("plost.fxml"));
                Scene plost_screen = new Scene(plost);
                MainStage.setScene(plost_screen);
                MainStage.show();
            }

        }
        catch (Exception e) {

        }
    }

    public void draw(Label point){
        String check = point.getText();

        if (check != "X" && check != "O") {
            if (flag) {
                figure = "X";
            } else {
                figure = "O";
            }

            point.setText(figure);

            is_win = win_check(is_win);
            try {
                if (is_win) {
                    who_win(flag);
                    return;
                }
            }
            catch (Exception e) {

            }


            flag = !flag;
            count++;

            try {
                if (count == 9) {
                    Parent draw = FXMLLoader.load(getClass().getResource("draw.fxml"));
                    Scene draw_screen = new Scene(draw);
                    MainStage.setScene(draw_screen);
                    MainStage.show();
                    return;
                }
            }
            catch (Exception e) {

            }

            if (!flag) {
                MainStage.show();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                }
                catch (Exception e) {

                }
                compTurn();
            }
        }
    }

    public void draw1(ActionEvent click) throws Exception {
        draw(p1);
    }

    public void draw2(ActionEvent click) throws Exception {
        draw(p2);
    }

    public void draw3(ActionEvent click) throws Exception {
        draw(p3);
    }

    public void draw4(ActionEvent click) throws Exception {
        draw(p4);
    }

    public void draw5(ActionEvent click) throws Exception {
        draw(p5);
    }

    public void draw6(ActionEvent click) throws Exception {
        draw(p6);
    }

    public void draw7(ActionEvent click) throws Exception {
        draw(p7);
    }

    public void draw8(ActionEvent click) throws Exception {
        draw(p8);
    }

    public void draw9(ActionEvent click) throws Exception {
        draw(p9);
    }
}
