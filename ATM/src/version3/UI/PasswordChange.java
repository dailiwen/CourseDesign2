package version3.UI;

/**
 * 版本3
 * ATM UI - 密码修改
 * ATM密码修改
 * @author 11603080209 代利文
 */


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.alert.*;
import version3.entity.Account2;

import java.io.IOException;

public class PasswordChange extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Account2 account = Login.login1;
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(10);
        pane.setVgap(10);

        Text id = new Text("您的ID为: "+account.getId());
        id.setFont(Font.font(25));
        Label name = new Label("请输入旧密码:");
        name.setFont(Font.font(25));
        PasswordField nameIn = new PasswordField();
        nameIn.setPromptText("请输入旧密码:");
        nameIn.setPrefWidth(220);
        nameIn.setPrefHeight(40);
        Label password = new Label("请重置密码:");
        password.setFont(Font.font(25));
        PasswordField passwordIn = new PasswordField();
        passwordIn.setPromptText("密码长度为6-10位");
        passwordIn.setPrefWidth(220);
        passwordIn.setPrefHeight(40);
        Label repassword = new Label("请确认此密码:");
        repassword.setFont(Font.font(25));
        PasswordField repasswordIn = new PasswordField();
        repasswordIn.setPromptText("重复输入密码");
        repasswordIn.setPrefWidth(220);
        repasswordIn.setPrefHeight(40);

        Button one = new Button("确定");
        one.setPrefSize(100,60);
        one.setFont(Font.font(25));
        Button two = new Button("返回");
        two.setPrefSize(100,60);
        two.setFont(Font.font(25));

        pane.addRow(1,id);
        pane.addRow(2,name,nameIn);
        pane.addRow(3,password,passwordIn);
        pane.addRow(4,repassword,repasswordIn);
        pane.addRow(5,one,two);

        one.setOnAction(event -> {
            try {
                int ju = account.changePassword(nameIn.getText(),passwordIn.getText(),repasswordIn.getText());//更改密码判断
                if (ju == 0){                               //更改密码失败，旧密码输入不符
                    Platform.runLater(() -> {
                        new ChangeFailure1().start(new Stage());
                        primaryStage.hide();
                    });
                }
                else if (ju == 1) {
                    Platform.runLater(() -> {                //密码长度报错
                        new ChangeFailure2().start(new Stage());
                        primaryStage.hide();
                    });
                }
                else if (ju == 2) {                          //前后密码不一致报错
                    Platform.runLater(() -> {
                        new ChangeFailure3().start(new Stage());
                        primaryStage.hide();
                    });
                }
                else {
                    Platform.runLater(() -> {                      //更改密码成功
                        try {
                            new ChangeSuccess().start(new Stage());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        primaryStage.hide();
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        two.setOnAction(event -> {
            Platform.runLater(() -> {
                new Interface().start(new Stage());
                primaryStage.hide();
            });
        });

        Scene scene = new Scene(pane,500,280);
        primaryStage.setTitle("密码重置");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
