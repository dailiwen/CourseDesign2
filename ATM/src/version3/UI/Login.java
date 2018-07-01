package version3.UI;

/**
 * 版本3
 * ATM UI - 登录界面
 * 登录ATM
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
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
import version3.alert.LoginFailure1;
import version3.alert.LoginFailure2;
import version3.entity.Account2;

import java.io.IOException;

public class Login extends Application {
    public static Account2 login1 = new Account2();                           //全局静态变量设置
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(120,10,10,45));
        pane.setHgap(10);
        pane.setVgap(10);

        Pane pane1 = new Pane();
        Label id1 = new Label("ID   :");
        id1.setFont(Font.font(30));
        id1.setLayoutX(20);
        id1.setLayoutY(20);
        TextField id2 = new TextField();
        id2.setPromptText("请输入您的账号");
        id2.setLayoutX(100);
        id2.setLayoutY(20);
        id2.setPrefWidth(220);
        id2.setPrefHeight(40);
        Label password1 = new Label("密码:");
        password1.setFont(Font.font(30));
        password1.setLayoutX(20);
        password1.setLayoutY(75);
        PasswordField password2 = new PasswordField();
        password2.setPromptText("请输入您的密码");
        password2.setLayoutX(100);
        password2.setLayoutY(75);
        password2.setPrefWidth(220);
        password2.setPrefHeight(40);
        pane1.getChildren().addAll(id1,id2,password1,password2);


        Button one = new Button("1");
        one.setPrefSize(80,80);
        one.setFont(Font.font(30));
        Button two = new Button("2");
        two.setPrefSize(80,80);
        two.setFont(Font.font(30));
        Button three = new Button("3");
        three.setPrefSize(80,80);
        three.setFont(Font.font(30));
        Button four = new Button("4");
        four.setPrefSize(80,80);
        four.setFont(Font.font(30));
        Button five = new Button("5");
        five.setPrefSize(80,80);
        five.setFont(Font.font(30));
        Button six = new Button("6");
        six.setPrefSize(80,80);
        six.setFont(Font.font(30));
        Button seven = new Button("7");
        seven.setPrefSize(80,80);
        seven.setFont(Font.font(30));
        Button eight = new Button("8");
        eight.setPrefSize(80,80);
        eight.setFont(Font.font(30));
        Button nine = new Button("9");
        nine.setPrefSize(80,80);
        nine.setFont(Font.font(30));
        Button zore = new Button("0");
        zore.setPrefSize(80,80);
        zore.setFont(Font.font(30));

        Button reset = new Button("重置");
        reset.setPrefSize(80,80);
        reset.setFont(Font.font(20));
        Button login = new Button("登录");
        login.setPrefSize(80,80);
        login.setFont(Font.font(20));
        Button reture = new Button("返回");
        reture.setPrefSize(200,50);
        reture.setFont(Font.font(20));
        reture.setLayoutX(75);
        reture.setLayoutY(490);
        Pane pane3 = new Pane();
        pane3.getChildren().add(reture);
        pane.addRow(1,one,two,three);
        pane.addRow(2,four,five,six);
        pane.addRow(3,seven,eight,nine);
        pane.addRow(4,reset,zore,login);


        Pane pane2 = new Pane();
        pane2.getChildren().addAll(pane3,pane,pane1);

        one.setOnAction(event -> {
            if(id2.getText().length()<6)                              //在账户长度超过6的时候设置密码实现按钮输入时的焦点转移
                id2.setText(id2.getText()+"1");
            else
                password2.setText(password2.getText()+"1");
        });
        two.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"2");
            else
                password2.setText(password2.getText()+"2");
        });
        three.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"3");
            else
                password2.setText(password2.getText()+"3");
        });
        four.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"4");
            else
                password2.setText(password2.getText()+"4");
        });
        five.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"5");
            else
                password2.setText(password2.getText()+"5");
        });
        six.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"6");
            else
                password2.setText(password2.getText()+"6");
        });
        seven.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"7");
            else
                password2.setText(password2.getText()+"7");
        });
        eight.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"8");
            else
                password2.setText(password2.getText()+"8");
        });
        nine.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"9");
            else
                password2.setText(password2.getText()+"9");
        });
        zore.setOnAction(event -> {
            if(id2.getText().length()<6)
                id2.setText(id2.getText()+"0");
            else
                password2.setText(password2.getText()+"0");
        });

        reture.setOnAction(e -> {                                      //返回跳转
            Platform.runLater(() -> {
                try {
                    new MainInterface().start(new Stage());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                primaryStage.hide();
            });
        });

        reset.setOnAction(e -> {                                        //清空输入
            id2.clear();
            password2.clear();
        });

        login.setOnAction(e -> {                                        //登录跳转
            try {
                int judgment = login1.login(id2.getText(),password2.getText());    //登录判断
                if (judgment == 0) {                                         //登录成功，跳转主界面
                    Platform.runLater(() -> {
                        new Interface().start(new Stage());
                        primaryStage.hide();
                    });
                }
                else if (judgment == 1) {                             //登录失败，跳转密码错误警告
                    Platform.runLater(() -> {
                        new LoginFailure1().start(new Stage());
                        primaryStage.hide();
                    });
                }

                else if (judgment == 2) {                              //登录成功，跳转不存在账户警告
                    Platform.runLater(() -> {
                        new LoginFailure2().start(new Stage());
                        primaryStage.hide();
                    });
                }

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        Scene scene = new Scene(pane2,350,550);
        primaryStage.setTitle("登录");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
