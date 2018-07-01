package version3;

/**
 * 版本3
 * 刽子手游戏跳转页面
 * 在此页面跳转回之前的界面，实现游戏的重新开始
 * @author 11603080209 代利文
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Jump extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {                       //跳转去主界面
            new Interface().start(new Stage());
            primaryStage.hide();
        });
    }
}
