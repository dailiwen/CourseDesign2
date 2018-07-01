package version3.alert;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import version3.UI.Deposit;
import version3.UI.Interface;

public class DepositSuccess extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {         //存款成功
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Text text1 = new Text("存款成功");
        text1.setFont(Font.font(25));
        Text text2 = new Text("2秒钟后回到主界面");
        text2.setFont(Font.font(25));

        pane.addRow(1,text1);
        pane.addRow(2,text2);

        new Timeline(new KeyFrame(Duration.millis(2000),
                e -> Platform.runLater(() -> {
                    new Interface().start(new Stage());
                    primaryStage.hide();
                }))).play();

        Scene scene = new Scene(pane,500,300);
        primaryStage.setTitle("存款成功");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
