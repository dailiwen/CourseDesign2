package version3.UI;

/**
 * 版本3
 * ATM UI - 主界面
 * 实现ATM功能选择
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

import java.io.IOException;

public class Interface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        GridPane pane1 = new GridPane();
        GridPane pane2 = new GridPane();
        GridPane pane3 = new GridPane();


        Button one = new Button("余额查询");
        one.setPrefSize(150,60);
        one.setFont(Font.font(25));
        Button two = new Button("存款");
        two.setPrefSize(150,60);
        two.setFont(Font.font(25));
        Button three = new Button("取款");
        three.setPrefSize(150,60);
        three.setFont(Font.font(25));
        Button four = new Button("交易记录查询");
        four.setPrefSize(150,60);
        four.setFont(Font.font(18));
        Button five = new Button("修改密码");
        five.setPrefSize(150,60);
        five.setFont(Font.font(25));
        Button six = new Button("退出");
        six.setPrefSize(150,60);
        six.setFont(Font.font(25));


        Text text1 = new Text("请选择您需要的功能");
        text1.setFont(Font.font(30));

        pane1.addColumn(0,one,two,three);                                  //GridPane列结点设置
        pane2.addColumn(2,four,five,six);
        pane3.addColumn(1,text1);

        pane.setLeft(pane1);                                                            //boderPane结点设置
        pane.setRight(pane2);
        pane.setTop(pane3);

        pane1.setPadding(new Insets(30,0,0,0));              //padding设置
        pane2.setPadding(new Insets(30,0,0,0));
        pane3.setPadding(new Insets(25,0,0,0));

        pane1.setVgap(45);
        pane2.setVgap(45);
        pane3.setAlignment(Pos.CENTER);

        one.setOnAction(event -> {                                                    //余额查询跳转
            Platform.runLater(() -> {
                try {
                    new BalanceQuery().start(new Stage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.hide();
            });
        });

        two.setOnAction(event -> {                                          //存钱跳转
            Platform.runLater(() -> {
                new Deposit().start(new Stage());
                primaryStage.hide();
            });
        });

        three.setOnAction(event -> {                                        //取钱跳转
            Platform.runLater(() -> {
                new Withdraw().start(new Stage());
                primaryStage.hide();
            });
        });

        four.setOnAction(event -> {                                         //交易记录查询跳转
            Platform.runLater(() -> {
                try {
                    new Transaction().start(new Stage());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.hide();
            });
        });

        five.setOnAction(event -> {                                             //更改密码跳转
            Platform.runLater(() -> {
                new PasswordChange().start(new Stage());
                primaryStage.hide();
            });
        });


        six.setOnAction(event -> {
            primaryStage.close();                                                 //退出程序
        });

        Scene scene = new Scene(pane,400,400);
        primaryStage.setTitle("主界面");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
