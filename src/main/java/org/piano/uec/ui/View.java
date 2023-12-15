package org.piano.uec.ui;

import javafx.scene.Group;
import javafx.scene.Scene;


public class View extends Group {

    private final Board board;
    public View(){
        this.board = new Board(this);
    }

    public Board getBoard(){
        return this.board;
    }
}
