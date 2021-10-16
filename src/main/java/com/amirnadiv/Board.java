package com.amirnadiv;

public interface Board<Piece> {
    void print();
    void change(Piece piece);
    boolean hasWon();
}
//