package org.piano.uec.controllers;
import javafx.scene.paint.Color;
import org.piano.uec.ui.Board;

/**
 * テトリミノを扱うための抽象クラス
 * 条件分岐に不完全な部分があるので修正してみよう
 */
public abstract class Mino {
    protected final Block[] blocks = new Block[4];
    protected final Board board;
    protected final Color color;
    private boolean stop;

    Mino(Board board, Color color){
        this.board = board;
        this.stop = false;
        this.color = color;
    }

    public void init(){
        blocks[0] = new Block(1,1);
        blocks[1] = new Block(2,1);
        blocks[2] = new Block(3,1);
        blocks[3] = new Block(2,2);
        this.stop = false;
    }

    public Color getColor() {
        return this.color;
    }

    public final void goDown(){
        //下にいけるかどうか
        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].getY() + 1 >= 20){
                //下に行けないということは次のミノにうつるということなので、stopをtrueにする
                this.setStop(true);
                return;
            }
        }
        //実際に下に行く
        for(int i = 0; i < blocks.length; i++){
            blocks[i].setY(blocks[i].getY() + 1);
        }
    }

    public void goRight() {
        //右にいけるかどうか
        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].getX() + 1 >= 10){
                return;
            }
        }
        //実際に右に行く
        for(int i = 0; i < blocks.length; i++){
            blocks[i].setX(blocks[i].getX() + 1);
        }
    }

    public void goLeft() {
        //左にいけるかどうか
        for(int i = 0; i < blocks.length; i++){
            if(blocks[i].getX() - 1 < 0){
                return;
            }
        }
        //実際に左に行く
        for(int i = 0; i < blocks.length; i++){
            blocks[i].setX(blocks[i].getX() - 1);
        }
    }
    public abstract void rollRight();
    public abstract void rollLeft();

    public boolean isStop(){
        return this.stop;
    }
    public void setStop(boolean stop){
        this.stop = stop;
    }

    public Block[] getBlocks(){
        return this.blocks;
    }
}
