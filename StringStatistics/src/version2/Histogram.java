package version2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Scanner;

public class Histogram extends Application {
    final static String A = "A";
    final static String B = "B";
    final static String C = "C";
    final static String D = "D";
    final static String E = "E";
    final static String F = "F";
    final static String G = "G";
    final static String H = "H";
    final static String I = "I";
    final static String J = "J";
    final static String K = "K";
    final static String L = "L";
    final static String M = "M";
    final static String N = "N";
    final static String O = "O";
    final static String P = "P";
    final static String Q = "Q";
    final static String R = "R";
    final static String S = "S";
    final static String T = "T";
    final static String U = "U";
    final static String V = "V";
    final static String W = "W";
    final static String X = "X";
    final static String Y = "Y";
    final static String Z = "Z";

    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String, Number> sbc =
            new BarChart<>(xAxis, yAxis);
    final XYChart.Series<String, Number> series1 =
            new XYChart.Series<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入字符串,我们将统计其中的字母个数 > ");
        String string = input.nextLine();
        int[] count = new int[26];
        string = string.toUpperCase();

        for(int i=0;i<string.length();i++) {
            switch (string.charAt(i)) {
                case 'A':count[0]++;break;
                case 'B':count[1]++;break;
                case 'C':count[2]++;break;
                case 'D':count[3]++;break;
                case 'E':count[4]++;break;
                case 'F':count[5]++;break;
                case 'G':count[6]++;break;
                case 'H':count[7]++;break;
                case 'I':count[8]++;break;
                case 'J':count[9]++;break;
                case 'K':count[10]++;break;
                case 'L':count[11]++;break;
                case 'M':count[12]++;break;
                case 'N':count[13]++;break;
                case 'O':count[14]++;break;
                case 'P':count[15]++;break;
                case 'Q':count[16]++;break;
                case 'R':count[17]++;break;
                case 'S':count[18]++;break;
                case 'T':count[19]++;break;
                case 'U':count[20]++;break;
                case 'V':count[21]++;break;
                case 'W':count[22]++;break;
                case 'X':count[23]++;break;
                case 'Y':count[24]++;break;
                case 'Z':count[25]++;break;
            }
        }


        final CategoryAxis xAxis = new CategoryAxis();                                    //x轴
        final NumberAxis yAxis = new NumberAxis();                                        //y轴
        final BarChart<String, Number> sbc = new BarChart<>(xAxis, yAxis);                //内容排布方式，sbc面板建立



        primaryStage.setTitle("String Statistics");                                     //舞台标题
        sbc.setTitle("String Statistics");                                              //柱状图标题
        xAxis.setLabel("Character");                                                     //x轴标题
        yAxis.setLabel("Number");                                                        //y轴标题
        xAxis.setCategories(FXCollections.<String>observableArrayList(
                Arrays.asList(A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z)));


        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data<>(A, count[0]));
        series1.getData().add(new XYChart.Data<>(B, count[1]));
        series1.getData().add(new XYChart.Data<>(C, count[2]));
        series1.getData().add(new XYChart.Data<>(D, count[3]));
        series1.getData().add(new XYChart.Data<>(E, count[4]));
        series1.getData().add(new XYChart.Data<>(F, count[5]));
        series1.getData().add(new XYChart.Data<>(G, count[6]));
        series1.getData().add(new XYChart.Data<>(H, count[7]));
        series1.getData().add(new XYChart.Data<>(I, count[8]));
        series1.getData().add(new XYChart.Data<>(J, count[9]));
        series1.getData().add(new XYChart.Data<>(K, count[10]));
        series1.getData().add(new XYChart.Data<>(L, count[11]));
        series1.getData().add(new XYChart.Data<>(M, count[12]));
        series1.getData().add(new XYChart.Data<>(N, count[13]));
        series1.getData().add(new XYChart.Data<>(O, count[14]));
        series1.getData().add(new XYChart.Data<>(P, count[15]));
        series1.getData().add(new XYChart.Data<>(Q, count[16]));
        series1.getData().add(new XYChart.Data<>(R, count[17]));
        series1.getData().add(new XYChart.Data<>(S, count[18]));
        series1.getData().add(new XYChart.Data<>(T, count[19]));
        series1.getData().add(new XYChart.Data<>(U, count[20]));
        series1.getData().add(new XYChart.Data<>(V, count[21]));
        series1.getData().add(new XYChart.Data<>(W, count[22]));
        series1.getData().add(new XYChart.Data<>(X, count[23]));
        series1.getData().add(new XYChart.Data<>(Y, count[24]));
        series1.getData().add(new XYChart.Data<>(Z, count[25]));

        Scene scene = new Scene(sbc, 800, 600);
        sbc.getData().addAll(series1);
        primaryStage.setMaximized(true);                                       //窗口最大化
        primaryStage.setResizable(false);                                      //窗口锁定，无法缩放
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
