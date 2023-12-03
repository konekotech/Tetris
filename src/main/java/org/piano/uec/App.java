package org.piano.uec;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.piano.uec.ui.View;


/**
 * 参考
 * https://qiita.com/h-hata/items/cf65e6cf5c68d7e65001
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        View view = new View();
        Scene scene = new Scene(view, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("てすと");
        primaryStage.show();
    }
}
