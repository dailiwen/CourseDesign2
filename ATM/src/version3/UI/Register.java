package version3.UI;

/**
 * 版本3
 * ATM UI - 注册
 * ATM注册界面
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
import version3.alert.RegisterFailure1;
import version3.alert.RegisterFailure2;
import version3.alert.RegisterFailure3;
import version3.alert.RegisterSuccess;
import version3.entity.Account2;

import java.io.IOException;

public class Register extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.setHgap(10);
        pane.setVgap(10);

        Account2 register = new Account2();
        int ID = (int)(100000+Math.random()*900000);                     //随机选取数字为ID

        Text id = new Text("您的ID为:");
        id.setFont(Font.font(25));
        Text id1 = new Text(register.IDShow(ID));
        id1.setFont(Font.font(25));
        Label name = new Label("您的名字:");
        name.setFont(Font.font(25));
        TextField nameIn = new TextField();
        nameIn.setPrefWidth(220);
        nameIn.setPrefHeight(40);
        Label password = new Label("请输入密码:");
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
        Label balance = new Label("请设置账户余额:");
        balance.setFont(Font.font(25));
        TextField balanceIn = new TextField();
        balanceIn.setPrefWidth(220);
        balanceIn.setPrefHeight(40);

        Button one = new Button("注册");
        one.setPrefSize(100,60);
        one.setFont(Font.font(25));
        Button two = new Button("返回");
        two.setPrefSize(100,60);
        two.setFont(Font.font(25));

        pane.addRow(1,id,id1);
        pane.addRow(2,name,nameIn);
        pane.addRow(3,password,passwordIn);
        pane.addRow(4,repassword,repasswordIn);
        pane.addRow(5,balance,balanceIn);
        pane.addRow(6,one,two);

        one.setOnAction(e -> {

            try {
                id1.setText(register.IDShow(ID));
                int judgment = register.register(nameIn.getText(),passwordIn.getText(),repasswordIn.getText(),Double.valueOf(balanceIn.getText()),ID);//注册判断

                if (judgment == 0) {
                    Platform.runLater(() -> {               //注册成功跳转
                        try {
                            new RegisterSuccess().start(new Stage());
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        primaryStage.hide();
                    });
                }
                else if (judgment == 1) {                   //注册失败，密码长度报错
                    Platform.runLater(() -> {
                        new RegisterFailure1().start(new Stage());
                        primaryStage.hide();
                    });
                }

                else if (judgment == 2) {                   //注册失败，重复密码错误
                    Platform.runLater(() -> {
                        new RegisterFailure2().start(new Stage());
                        primaryStage.hide();
                    });
                }

                else {
                    Platform.runLater(() -> {                   //注册失败，账户金额设置错误
                        new RegisterFailure3().start(new Stage());
                        primaryStage.hide();
                    });
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        });

        two.setOnAction(e -> {                                  //返回页面
            Platform.runLater(() -> {
                new MainInterface().start(new Stage());
                primaryStage.hide();
            });
        });

        Scene scene = new Scene(pane,500,300);
        primaryStage.setTitle("注册");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
