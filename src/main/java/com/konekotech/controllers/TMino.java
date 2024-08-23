package com.konekotech.controllers;

import javafx.scene.paint.Color;
import com.konekotech.ui.Board;

public class TMino extends Mino {

    public TMino(Board board){
        super(board, new Color(0,1,1,1));
        blocks[0] = new Block(1,1);
        blocks[1] = new Block(2,1);
        blocks[2] = new Block(3,1);
        blocks[3] = new Block(2,2);
    }


    @Override
    public void rollRight() {

    }

    @Override
    public void rollLeft() {

    }
}
