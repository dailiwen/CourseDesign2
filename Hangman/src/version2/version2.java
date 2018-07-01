package version2;

/**
 * 版本2
 * 利用javaFX，实现对刽子手界面的显示
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class version2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Arc arc = new Arc(80,200,50,10,0,180);     //底座
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);

        Line line1 = new Line(80,190,80,20);       //竖支架
        Line line2 = new Line(80,20,200,20);       //横支架
        Line line3 = new Line(200,20,200,40);      //挂头绳

        Circle circle = new Circle(200,60,20);     //头
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        Line line4 = new Line(200,80,200,130);     //身体
        Line line5 = new Line(200,130,165,150);    //左腿
        Line line6 = new Line(200,130,235,150);    //右腿
        Line line7 = new Line(190,77,130,110);     //左手
        Line line8 = new Line(210,77,270,110);     //右手

        pane.getChildren().addAll(arc,line1,line2,line3,circle,line4,line5,line6,line7,line8);

        Scene scene = new Scene(pane,300, 200);
        primaryStage.setTitle("version2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

}

