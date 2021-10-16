package com.amirnadiv;

public enum Square  {
    RED("r", ConsoleColor.RED),
    BLUE("b", ConsoleColor.BLUE),
    GREEN("g", ConsoleColor.GREEN),
    YELLOW("y", ConsoleColor.YELLOW);

    private String color;
    private String ansiCode;

    Square(String color, String ansiCode) {
        this.color = color;
        this.ansiCode = ansiCode;
    }

    public static Square getByString(String str) {
        for(Square current: Square.values()) {
            if (current.color.equalsIgnoreCase(str)) {
                return current;
            }
        }

        return null;
    }

    public static Square getRandom() {
        int idx = (int) (Math.random()*(Square.values().length));
        return Square.values()[idx];
    }

    public String toString() {
        return this.ansiCode;
    }
}
