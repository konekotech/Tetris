package com.konekotech.tetris;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.konekotech.tetris.ui.View;


/**
 * JavaFX App
 *
 * 参考
 * https://qiita.com/h-hata/items/cf65e6cf5c68d7e65001
 */
public class TetrisApp extends Application {
    //loggerを作成
    private static final Logger logger = LogManager.getLogger(new Object(){}.getClass().getEnclosingClass().getName() );
    @Override
    public void start(Stage primaryStage) {
        View view = new View();
        Scene scene = new Scene(view, 600, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tetris");
        primaryStage.show();
        scene.setOnKeyPressed(view.getBoard()::keyPressed);
    }
}
