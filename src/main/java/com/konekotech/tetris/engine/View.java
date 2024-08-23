package com.konekotech.tetris.engine;

import javafx.scene.Group;


public class View extends Group {

    private final Board board;
    public View(){
        this.board = new Board(this);
    }

    public Board getBoard(){
        return this.board;
    }
}
