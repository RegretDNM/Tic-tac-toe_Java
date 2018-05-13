package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.util.*;

import static sample.Main.MainStage;

/**
 * Created by Regret on 12.05.2018.
 */
public class MiniMaxController {

    boolean flag = true, is_win = false;
    String figure;
    int count = 0;
    List<PointsAndScores> rootsChildrenScores;
    List<Point> availablePoints;
    int[][] board = new int[3][3];

    Random random = new Random();

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

    public List<Point> getAvailableStates() {
        availablePoints = new ArrayList<>();
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[i][j] == 0) {
                    availablePoints.add(new Point(i, j));
                }
            }
        }
        return availablePoints;
    }

    public void placeAMove(Point point, int player) {
        board[point.x][point.y] = player;   //player = 1 for X, 2 for O
    }

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

    public void callMinimax(int depth, int turn){
        rootsChildrenScores = new ArrayList<>();
        minimax(depth, turn);
        placeBestMove(returnBestMove(), 1);
    }

    private void placeBestMove(Point point, int i) {
        board[point.x][point.y] = i;

        if (point.x == 2) {
            if (point.y == 0) {
                draw(p1);
            }
            else if (point.y == 1) {
                draw(p2);
            }
            else if (point.y == 2) {
                draw(p3);
            }
        }
        else if (point.x == 1) {
            if (point.y == 0) {
                draw(p4);
            }
            else if (point.y == 1) {
                draw(p5);
            }
            else if (point.y == 2) {
                draw(p6);
            }
        }
        else if (point.x == 0) {
            if (point.y == 0) {
                draw(p7);
            }
            else if (point.y == 1) {
                draw(p8);
            }
            else if (point.y == 2) {
                draw(p9);
            }
        }
    }

    public Point returnBestMove() {
        int MAX = -100000;
        int best = -1;

        for (int i = 0; i < rootsChildrenScores.size(); ++i) {
            if (MAX < rootsChildrenScores.get(i).score) {
                MAX = rootsChildrenScores.get(i).score;
                best = i;
            }
        }

        return rootsChildrenScores.get(best).point;
    }

    public int minimax (int depth, int turn) {
        if (winnerPlayer()) {
            return +1;
        }

        if (winnerComp()) {
            return -1;
        }

        List<Point> pointsAvailable = getAvailableStates();
        if (pointsAvailable.isEmpty()) {
            return 0;
        }

        List<Integer> scores = new ArrayList<>();

        for (int i = 0; i < pointsAvailable.size(); ++i) {
            Point point = pointsAvailable.get(i);

            if (turn == 1) { //X's turn select the highest from below minimax() call
                placeAMove(point, 1);
                int currentScore = minimax(depth + 1, 2);
                scores.add(currentScore);

                if (depth == 0) {
                    rootsChildrenScores.add(new PointsAndScores(currentScore, point));
                }
            }
            else if (turn == 2) {//O's turn select the lowest from below minimax() call
                placeAMove(point, 2);
                scores.add(minimax(depth + 1, 1));
            }
            board[point.x][point.y] = 0; //Reset this point
        }
        return turn == 1 ? returnMax(scores) : returnMin(scores);
    }

    public int returnMin(List<Integer> list) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) < min) {
                min = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public int returnMax(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i) > max) {
                max = list.get(i);
                index = i;
            }
        }
        return list.get(index);
    }

    public boolean winnerPlayer () {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 1) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 1)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if (((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 1) || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 1))) {
                return true;
            }
        }
        return false;
    }

    public boolean winnerComp () {
        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == 2) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == 2)) {
            return true;
        }
        for (int i = 0; i < 3; ++i) {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == 2) || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == 2)) {
                return true;
            }
        }

        return false;
    }

    public void draw (Label point) {
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
                callMinimax(0, 1);
            }
        }
    }

    public void draw1(ActionEvent click) throws Exception {
        if (board[2][0] == 0) {
            if (flag) {
                board[2][0] = 2;
            }
            else {
                board[2][0] = 1;
            }
        }

        draw(p1);
    }

    public void draw2(ActionEvent click) throws Exception {
        if (board[2][1] == 0) {
            if (flag) {
                board[2][1] = 2;
            }
            else {
                board[2][1] = 1;
            }
        }

        draw(p2);
    }

    public void draw3(ActionEvent click) throws Exception {
        if (board[2][2] == 0) {
            if (flag) {
                board[2][2] = 2;
            }
            else {
                board[2][2] = 1;
            }
        }

        draw(p3);
    }

    public void draw4(ActionEvent click) throws Exception {
        if (board[1][0] == 0) {
            if (flag) {
                board[1][0] = 2;
            }
            else {
                board[1][0] = 1;
            }
        }

        draw(p4);
    }

    public void draw5(ActionEvent click) throws Exception {
        if (board[1][1] == 0) {
            if (flag) {
                board[1][1] = 2;
            }
            else {
                board[1][1] = 1;
            }
        }

        draw(p5);
    }

    public void draw6(ActionEvent click) throws Exception {
        if (board[1][2] == 0) {
            if (flag) {
                board[1][2] = 2;
            }
            else {
                board[1][2] = 1;
            }
        }

        draw(p6);
    }

    public void draw7(ActionEvent click) throws Exception {
        if (board[0][0] == 0) {
            if (flag) {
                board[0][0] = 2;
            }
            else {
                board[0][0] = 1;
            }
        }

        draw(p7);
    }

    public void draw8(ActionEvent click) throws Exception {
        if (board[0][1] == 0) {
            if (flag) {
                board[0][1] = 2;
            }
            else {
                board[0][1] = 1;
            }
        }

        draw(p8);
    }

    public void draw9(ActionEvent click) throws Exception {
        if (board[0][2] == 0) {
            if (flag) {
                board[0][2] = 2;
            }
            else {
                board[0][2] = 1;
            }
        }

        draw(p9);
    }


    /*boolean flag = true, is_win = false;
    String figure;
    int count = 0;

    Random random = new Random();

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

    public void draw (Label point) {
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
*/
}
