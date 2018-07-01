package version3.UI;

/**
 * 版本3
 * ATM UI - 交易记录查询
 * 实现ATM交易记录查询
 * @author 11603080209 代利文
 */


import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import version3.entity.Account2;

import java.io.IOException;
import java.util.ArrayList;

public class Transaction extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Account2 account = Login.login1;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane pane = new Pane();

        Text text = new Text();
        text.setFont(Font.font(15));
        text.setLayoutY(20);
        Button reture = new Button("返回");
        reture.setPrefSize(80,80);
        reture.setFont(Font.font(20));
        reture.setLayoutX(250);
        pane.getChildren().addAll(text,reture);

        ArrayList list = null;
        try {
            list = account.transactionsSerch(account.getId());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        int i;
        for (i=0;i<list.size();i=i+2) {
            text.setText(text.getText() + (String) list.get(i) + "     " + (String) list.get(i + 1) + "\n");
        }

        reture.setOnAction(event -> {                     //返回页面
            Platform.runLater(() -> {
                new Interface().start(new Stage());
                primaryStage.hide();
            });
        });
        reture.setLayoutY(500);
        Scene scene = new Scene(pane);                   //不设置pane宽度。根据文本自动调整
        primaryStage.setTitle("交易信息查询");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
