package com.amirnadiv;

import java.util.ArrayList;
import java.util.List;


public class ColorBoard implements Board<Square> {


    private int boardSize =18; // my default value
    private int numberOfTurns=21; // my default value

    private static final int STARTING_ROW = 0;
    private static final int STARTING_COL = 0;

    private List<List<Square>> board;

    public ColorBoard(){
        board = new ArrayList<>();
        init();
    }

    public ColorBoard(int boardSize,int numberOfTurns){
        this.boardSize = boardSize;
        this.numberOfTurns =numberOfTurns;
        board = new ArrayList<>();
        init();
    }


    private void init(){
        for(int i = 0; i < this.boardSize; i++) {
            List<Square> row = new ArrayList<>();
            for(int j = 0; j < this.boardSize; j++) {
                row.add(Square.getRandom());
            }
            board.add(row);
        }
    }

    public void print() {
        for(int i = 0; i < this.boardSize; i++) {
            for(int j = 0; j < this.boardSize; j++) {
                System.out.printf(" %s ", board.get(i).get(j));
            }
            System.out.printf("%s\n", ConsoleColor.RESET);
        }
    }

    public boolean hasWon() {
        Square orig = board.get(STARTING_ROW).get(STARTING_COL);

        for(int i = 0; i < this.boardSize; i++) {
            for(int j =0; j < this.boardSize; j++) {
                if(board.get(i).get(j) != orig) return false;
            }
        }
        return true;
    }

    public void change(Square newColor) {
        Square starting = board.get(STARTING_ROW).get(STARTING_COL);
        if(starting != newColor) {
            switchColor(starting, newColor, STARTING_ROW, STARTING_COL);
        }
    }

    private void switchColor(Square old, Square newColor, int i, int j) {
        if(outOfBoundsOfBoard(i) || outOfBoundsOfBoard(j)) return;
        Square current = board.get(i).get(j);
        if(current == old) {
            board.get(i).set(j, newColor);
            switchColor(old, newColor, i-1, j);
            switchColor(old, newColor, i+1, j);
            switchColor(old, newColor, i, j+1);
            switchColor(old, newColor, i, j-1);
        }
    }



    private boolean outOfBoundsOfBoard(int i) {
        return i < 0 || i >= this.boardSize;
    }


    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public List<List<Square>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Square>> board) {
        this.board = board;
    }
}
