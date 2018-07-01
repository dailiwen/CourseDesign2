package version3.UI;

/**
 * 版本3
 * ATM UI - 存款
 * 实现ATM存款功能
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.alert.DepositSuccess;
import version3.entity.Account2;

import java.io.IOException;

public class Deposit extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Account2 account = Login.login1;
    @Override
    public void start(Stage primaryStage) {


        BorderPane pane = new BorderPane();
        GridPane pane1 = new GridPane();
        GridPane pane2 = new GridPane();
        GridPane pane3 = new GridPane();
        GridPane pane4 = new GridPane();

        Button one = new Button("100");                                 //100元
        one.setPrefSize(100,60);
        one.setFont(Font.font(25));
        Button two = new Button("200");                                 //200元
        two.setPrefSize(100,60);
        two.setFont(Font.font(25));
        Button three = new Button("500");                               //500元
        three.setPrefSize(100,60);
        three.setFont(Font.font(25));
        Button four = new Button("1000");                               //1000元
        four.setPrefSize(100,60);
        four.setFont(Font.font(25));
        Button five = new Button("2000");                                //2000元
        five.setPrefSize(100,60);
        five.setFont(Font.font(25));
        Button six = new Button("5000");                                 //5000元
        six.setPrefSize(100,60);
        six.setFont(Font.font(25));
        Button exist = new Button("其他金额");                           //其他金额选择
        exist.setPrefSize(100,60);
        exist.setFont(Font.font(18));
        Button exit = new Button("返回");                                //返回主界面
        exit.setPrefSize(100,60);
        exit.setFont(Font.font(25));

        Text text1 = new Text("请选择您得准备存款的金额");
        text1.setFont(Font.font(25));
        Text text2 = new Text();                                               //准备存款金额显示
        text2.setFont(Font.font(30));
        Text text3 = new Text("选择后点击按钮存款");
        text3.setFont(Font.font(20));
        Button in = new Button("存款");                                  //存款
        in.setPrefSize(100,60);
        in.setFont(Font.font(25));

        pane1.addColumn(0,one,two,three,four);                    //GridPane行结点设置
        pane2.addColumn(2,five,six,exist,exit);
        pane3.addColumn(1,text1);
        pane4.addColumn(1,text3,text2,in);
        pane.setLeft(pane1);
        pane.setRight(pane2);
        pane.setTop(pane3);
        pane.setCenter(pane4);

        pane1.setPadding(new Insets(15,0,0,0));       //padding边设置
        pane2.setPadding(new Insets(15,0,0,0));
        pane3.setPadding(new Insets(25,0,0,0));

        pane1.setVgap(45);                                                      //元素间距
        pane2.setVgap(45);
        pane4.setVgap(30);
        pane3.setAlignment(Pos.CENTER);                                        //元素居中
        pane4.setAlignment(Pos.CENTER);

        one.setOnAction(e -> {
            text2.setText("100");
        });

        two.setOnAction(e -> {
            text2.setText("200");
        });

        three.setOnAction(e -> {
            text2.setText("500");
        });

        four.setOnAction(e -> {
            text2.setText("1000");
        });

        five.setOnAction(e -> {
            text2.setText("2000");
        });

        six.setOnAction(e -> {
            text2.setText("5000");
        });

        in.setOnAction(e -> {                                                //存款跳转
            account.setBalance(account.getBalance()+Double.valueOf(text2.getText()));
            try {
                account.transactions("Deposit",Double.valueOf(text2.getText()),account.getId(),account.getBalance());
                Platform.runLater(() -> {
                    new DepositSuccess().start(new Stage());
                    primaryStage.hide();
                });
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        exist.setOnAction(e -> {                                            //额外金额跳转
            Platform.runLater(() -> {
                new OtherDeposit().start(new Stage());
                primaryStage.hide();
            });
        });

        exit.setOnAction(e -> {                                             //返回跳转
            Platform.runLater(() -> {
                new Interface().start(new Stage());
                primaryStage.hide();
            });
        });

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("存款");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);                                //窗口锁定
        primaryStage.show();
    }
}
