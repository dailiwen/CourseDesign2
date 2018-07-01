package version3.UI;

/**
 * 版本3
 * ATM UI - 存款_其他金额
 * 选择储存其他金额
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.alert.DepositFailure1;
import version3.alert.DepositSuccess;
import version3.entity.Account2;

import java.io.IOException;

public class OtherDeposit extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Account2 account = Login.login1;
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Text text = new Text("请输入您需要的其他金额：");
        text.setLayoutX(30);
        text.setLayoutY(120);
        text.setFont(Font.font(30));

        Text text1 = new Text("(为100的倍数)");
        text1.setLayoutX(120);
        text1.setLayoutY(160);
        text1.setFont(Font.font(25));

        TextField input = new TextField();
        input.setLayoutX(90);
        input.setLayoutY(190);
        input.setPrefWidth(220);
        input.setPrefHeight(40);

        Button one = new Button("存款");
        one.setPrefSize(100,60);
        one.setFont(Font.font(25));
        one.setLayoutX(150);
        one.setLayoutY(260);

        pane.getChildren().addAll(text,text1,input,one);

        one.setOnAction(e -> {
            if (Double.valueOf(input.getText()) % 100 != 0||Double.valueOf(input.getText())<0) {
                Platform.runLater(() -> {
                    new DepositFailure1().start(new Stage());             //金额错误跳转
                    primaryStage.hide();
                });
            } else {
                try {
                    account.setBalance(account.getBalance() + Double.valueOf(input.getText()));
                    account.transactions("Deposit", Double.valueOf(input.getText()), account.getId(), account.getBalance());
                    Platform.runLater(() -> {
                        new DepositSuccess().start(new Stage());         //存款成功跳转
                        primaryStage.hide();
                    });
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("其他金额-存款");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
