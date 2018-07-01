package version3.alert;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.UI.MainInterface;

import java.io.*;
import java.util.ArrayList;

public class ChangeSuccess extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Text text1 = new Text("修改成功，请务必牢记您修改的密码");
        text1.setFont(Font.font(25));
        Text text2 = new Text("牢记后，请点击按钮回到初始界面，重新登录");
        text2.setFont(Font.font(25));
        Button two = new Button("返回");
        two.setPrefSize(100,60);
        two.setFont(Font.font(25));

        pane.addRow(1,text1);
        pane.addRow(2,text2);
        pane.addRow(3,two);

        two.setOnAction(e -> {
            Platform.runLater(() -> {
                try {
                    new MainInterface().start(new Stage());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                primaryStage.hide();
            });
        });

        Scene scene = new Scene(pane,600,300);
        primaryStage.setTitle("修改密码成功");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
