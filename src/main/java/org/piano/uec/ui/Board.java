package org.piano.uec.ui;

import java.util.Timer;
import java.util.TimerTask;

import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.piano.uec.controllers.Block;
import org.piano.uec.controllers.Mino;
import org.piano.uec.controllers.TMino;

public class Board {
    //loggerを作成
    private static final Logger logger = LogManager.getLogger(new Object(){}.getClass().getEnclosingClass().getName() );

    //GUIを表示させるためのView
    private View view;
    //格子
    private final Rectangle[][] board;
    //格子の横幅
    private final int width = 30;
    //格子の縦幅
    private final int height = 30;
    //現在動いているミノ
    private Mino mino = new TMino(this);

    /**
     * ゲームが行われる格子上の操作を表現する
     * @param view viewを引数として渡す
     */
    public Board(View view){
        this.view = view;
        this.board = new Rectangle[10][20];

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                board[i][j] = new Rectangle(0,0,width, height);
                board[i][j].setX(100 + width * i);
                board[i][j].setY(60 + height * j);
                board[i][j].setStroke(new Color(0.3,0.3,0.3,1));
                board[i][j].setFill(null);
                view.getChildren().add(board[i][j]);
            }
        }
        initializeGame();
    }

    /**
     * ゲームを開始
     */
    void initializeGame(){
        mino.init();
        Timer timer = new Timer(false);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (mino.isStop()) {
                    timer.cancel();
                    initializeGame();
                }
                erase(mino);
                mino.goDown();
                fill(mino);
            }
        };
        timer.schedule(task, 0, 1000);
    }

    /**
     * Minoの色をfillする
     * @param mino fillするMino
     */
    private void fill(Mino mino){
        Block[] blocks = mino.getBlocks();
        for(int i = 0; i < blocks.length; i++){
            board[blocks[i].getX()][blocks[i].getY()].setFill(mino.getColor());
        }
    }

    /**
     * Minoの色を消す
     * @param mino 消すMino
     */
    private void erase(Mino mino){
        Block[] blocks = mino.getBlocks();
        for(int i = 0; i < blocks.length; i++){
            board[blocks[i].getX()][blocks[i].getY()].setFill(null);
        }
    }

    /**
     * キーが押されたときの挙動
     * @param event キーイベント
     */
    public void keyPressed(KeyEvent event){
        switch (event.getCode()){
            case A -> {
                logger.info("Go left.");
                erase(this.mino);
                this.mino.goLeft();
                fill(this.mino);
            }
            case D->{
                logger.info("Go right.");
                erase(this.mino);
                this.mino.goRight();
                fill(this.mino);
            }
            case Q -> {
                logger.info("Roll left.");
                erase(this.mino);
                this.mino.rollLeft();
                fill(this.mino);
            }
            case E ->{
                logger.info("Roll right.");
                erase(this.mino);
                this.mino.rollRight();
                fill(this.mino);
            }
            case S ->{
                logger.info("Go down.");
                erase(this.mino);
                this.mino.goDown();
                fill(this.mino);
            }
            default -> {
                System.out.println("ほげ");
            }
        }
    }
}
