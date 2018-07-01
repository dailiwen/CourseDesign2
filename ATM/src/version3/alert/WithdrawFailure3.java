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
import version3.UI.Withdraw;

public class WithdrawFailure3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {         //取款失败，不为取款数不能超过5000元
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Text text1 = new Text("取款失败，每日取款数不能超过5000元");
        text1.setFont(Font.font(25));
        Text text2 = new Text("3秒钟后回到取款界面");
        text2.setFont(Font.font(25));

        pane.addRow(1,text1);
        pane.addRow(2,text2);

        new Timeline(new KeyFrame(Duration.millis(3000),
                e -> Platform.runLater(() -> {
                    new Withdraw().start(new Stage());
                    primaryStage.hide();
                }))).play();

        Scene scene = new Scene(pane,500,300);
        primaryStage.setTitle("取款失败");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
