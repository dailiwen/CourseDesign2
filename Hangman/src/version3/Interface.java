package version3;

/**
 * 版本3
 * 刽子手游戏UI
 * 结合算法，利用javaFX，实现对刽子手游戏的界面化
 * 实现良好的交互性
 * @author 11603080209 代利文
 */

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import static javafx.scene.input.KeyCode.ENTER;

public class Interface extends Application{
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Arc arc = new Arc(150,400,70,20,0,180);     //底座
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        Line line1 = new Line(150,380,150,50);       //竖支架
        Line line2 = new Line(150,50,380,50);       //横支架
        Line line3 = new Line(380,50,380,80);      //挂头绳



        Circle circle = new Circle(380,115,35);     //头
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Line line4 = new Line(380,150,380,220);     //身体
        Line line5 = new Line(380,220,350,250);    //左腿
        Line line6 = new Line(380,220,410,250);    //右腿
        Line line7 = new Line(380,150,320,180);     //左手
        Line line8 = new Line(380,150,440,180);     //右手
        Text wrong = new Text(250,350,"");                            //按键错误提示
        wrong.setFont(Font.font(15));
        /**
        Line reline3 = new Line(380,50,345,85);      //新挂头绳
        Circle recircle = new Circle(330,100,35);       //新头
        recircle.setFill(Color.WHITE);
        recircle.setStroke(Color.BLACK);
        Line reline4 = new Line(305,125,255,175);     //新身体
        Line reline5 = new Line(255,175,215,190);     //新左腿
        Line reline6 = new Line(255,175,240,215);     //新右腿
        Line reline7 = new Line(305,125,245,95);     //新左手
        Line reline8 = new Line(305,125,335,185);     //新右手
        **/
        pane.getChildren().addAll(arc,line1,line2,line3,wrong);
        PalindromePane pane1 = new PalindromePane();

        Text guess = new Text(250,310,"Guess a word: ");            //猜单词显示
        guess.setFont(Font.font(15));
        pane.getChildren().add(guess);
        Text miss = new Text(250,330,"Missed letters:   ");         //猜错显示
        miss.setFont(Font.font(15));

        Algorithm algorithm = new Algorithm();

        String word = algorithm.chooseWords();
        guess.setText("Guess a word:   "+algorithm.creatStart(word));             //选择单词后加入面板

        final String[] start = {algorithm.creatStart(word)};
        final int[] count = {0};

        guess.setOnKeyPressed((KeyEvent event) -> {
            if (count[0]!=7) {
                if (event.getText().toLowerCase().charAt(0) >= 'a' && event.getText().toLowerCase().charAt(0) <= 'z'
                        && event.getText().toLowerCase().length()==1) {                //判断是否按键是否为字符，排除数字和字母
                    if (algorithm.guessWord(event.getText().toLowerCase(), word, start[0]).equals("1")) {
                        wrong.setText("");
                        count[0]++;
                        miss.setText(miss.getText() + event.getText().toLowerCase());     //猜错提示语句设置
                        switch (count[0]) {
                            case 1: {
                                pane.getChildren().addAll(circle, miss);                  //头，猜错提示加入面板
                                break;
                            }
                            case 2: {
                                pane.getChildren().add(line4);                           //身体加入面板
                                break;
                            }
                            case 3: {
                                pane.getChildren().add(line5);                           //左脚加入面板
                                break;
                            }
                            case 4: {
                                pane.getChildren().add(line6);                           //右脚加入面板
                                break;
                            }
                            case 5: {
                                pane.getChildren().add(line7);                           //左手加入面板
                                break;
                            }
                            case 6: {
                                pane.getChildren().add(line8);                           //右手加入面板
                                break;
                            }
                            case 7: {                                                  //利用动画实现刽子手游戏结束后，人物的摇晃
                                Timeline animation = new Timeline(new KeyFrame(Duration.millis(10), e -> {pane1.next(circle,line3,line4,line5,line6,line7,line8);}));
                                animation.setCycleCount(Timeline.INDEFINITE);
                                animation.play(); // Start animation
                                break;
                            }
                        }
                    } else {
                        wrong.setText("");
                        start[0] = algorithm.guessWord(event.getText(), word, start[0]);
                        guess.setText("Guess a word:   " + start[0]);
                    }
                }
                else {
                    wrong.setText("Please enter the correct characters");               //按键错误提示
                }
            }
            if (count[0]==7||start[0].equals(word)){
                wrong.setText("");
                miss.setText("To contiue the game,press ENTER");
                if (event.getCode()==ENTER){                                //利用跳转到一个舞台，再跳转回来实现，游戏在按ENTER键后重新开始
                    Platform.runLater(() -> {                                //跳转去跳转页面
                        new Jump().start(new Stage());
                        primaryStage.hide();
                    });
                }
            }
        });

        Scene scene = new Scene(pane,600,400);
        primaryStage.setTitle("version3");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

       guess.requestFocus();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

class PalindromePane extends Pane {
    private double pendulumRadius = 30;
    private double leftAngle = 160;
    private double rightAngle = 20;
    private double angle = leftAngle; // Start from leftAngle
    private double angleDelta = 1; // Swing interval

    public void next(Circle c,Line l1,Line l2,Line l3,Line l4,Line l5,Line l6) {
        double x1 = l1.getStartX();
        double y1 = l1.getStartY();

        if (angle < rightAngle)
            angleDelta = 1; // Swing to the left
        else if (angle > leftAngle)
            angleDelta = -1; // Swing to the right

        angle += angleDelta;
        double l1Rx = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));                      //挂头绳旋转设置
        double l1Ry = y1 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double rRx = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));                       //头旋转设置
        double rRy = y1 + 35 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l2RxS = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));                     //身体旋转设置（开始）
        double l2RyS = y1 + 70 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l2RxE = x1 + pendulumRadius * Math.cos(Math.toRadians(angle));                     //身体旋转设置（结束）
        double l2RyE = y1 + 140 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l3RxE = x1 - 30 + pendulumRadius * Math.cos(Math.toRadians(angle));                //左脚旋转设置（结束）
        double l3RyE = y1 + 30 + 140 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l4RxE = x1 + 30 + pendulumRadius * Math.cos(Math.toRadians(angle));                //右脚旋转设置（结束）
        double l4RyE = y1 + 30 + 140 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l5RxE = x1 - 60 + pendulumRadius * Math.cos(Math.toRadians(angle));               //左手旋转设置（结束）
        double l5RyE = y1 + 100 + pendulumRadius * Math.sin(Math.toRadians(angle));

        double l6RxE = x1 + 60 + pendulumRadius * Math.cos(Math.toRadians(angle));              //右手旋转设置（结束）
        double l6RyE = y1 + 100 + pendulumRadius * Math.sin(Math.toRadians(angle));

        l1.setEndX(l1Rx); l1.setEndY(l1Ry);

        c.setCenterX(rRx); c.setCenterY(rRy);

        l2.setStartX(l2RxS); l2.setStartY(l2RyS);
        l2.setEndX(l2RxE); l2.setEndY(l2RyE);

        l3.setStartX(l2RxE); l3.setStartY(l2RyE);
        l3.setEndX(l3RxE); l3.setEndY(l3RyE);

        l4.setStartX(l2RxE); l4.setStartY(l2RyE);
        l4.setEndX(l4RxE); l4.setEndY(l4RyE);

        l5.setStartX(l2RxS); l5.setStartY(l2RyS);
        l5.setEndX(l5RxE); l5.setEndY(l5RyE);

        l6.setStartX(l2RxS); l6.setStartY(l2RyS);
        l6.setEndX(l6RxE); l6.setEndY(l6RyE);

    }
}
