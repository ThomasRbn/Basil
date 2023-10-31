package org.vaasistas.basil.gui.views;

public class SquarePosition {

    private double posX;
    private double posY;

    private double width;
    private double height;

    public SquarePosition(double posX, double posY, double width, double height) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
    }

    public double getPosX() {
        return posX;
    }

    public SquarePosition setPosX(double posX) {
        this.posX = posX;
        return this;
    }

    public double getPosY() {
        return posY;
    }

    public SquarePosition setPosY(double posY) {
        this.posY = posY;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public SquarePosition setWidth(double width) {
        this.width = width;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public SquarePosition setHeight(double height) {
        this.height = height;
        return this;
    }
}
