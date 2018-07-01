package version3.UI;

/**
 * 版本3
 * ATM UI - 余额查询
 * 实现ATM查询余额功能
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.entity.Account2;

import java.io.*;
import java.util.ArrayList;

public class BalanceQuery extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Account2 balance = Login.login1;                                //静态变量引用
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);

        Text text1 = new Text("您的账户余额为：");
        text1.setFont(Font.font(25));
        Text text2 = new Text(balance.getBalance()+"");                 //余额显示
        text2.setFont(Font.font(25));
        Button two = new Button("返回");                          //返回按钮
        two.setPrefSize(50,30);
        two.setFont(Font.font(15));

        pane.addRow(1,text1);
        pane.addRow(2,text2);
        pane.addRow(3,two);

        two.setOnAction(e -> {                                          //跳转主界面
            Platform.runLater(() -> {
                new Interface().start(new Stage());
                primaryStage.hide();
            });
        });

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("余额查询");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);                               //锁定窗口
        primaryStage.show();
    }
}
