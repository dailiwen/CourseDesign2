package version3.UI;

/**
 * 版本3
 * ATM UI - 最初界面
 * ATM初始界面
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class MainInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Button login = new Button("登录");
        Button register = new Button("注册");
        login.setLayoutX(80);
        login.setLayoutY(200);
        login.setFont(Font.font(30));
        login.setPrefSize(150,150);
        register.setLayoutX(280);
        register.setLayoutY(200);
        register.setFont(Font.font(30));
        register.setPrefSize(150,150);
        Text text1 = new Text(95,80,"欢迎使用ATM机");
        text1.setFont(Font.font(45));
        Text text2 = new Text(120,130,"请按下按钮 选择登录或是注册");
        text2.setFont(Font.font(20));

        pane.getChildren().addAll(login,register,text1,text2);
        login.setOnAction(e -> {                                    //登录界面跳转
            Platform.runLater(() -> {
                new Login().start(new Stage());
                primaryStage.hide();
            });
        });

        register.setOnAction(e -> {                                 //注册界面跳转
            Platform.runLater(() -> {
                try {
                    new Register().start(new Stage());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                primaryStage.hide();
            });
        });


        Scene scene = new Scene(pane,500,400);
        primaryStage.setTitle("ATM");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
