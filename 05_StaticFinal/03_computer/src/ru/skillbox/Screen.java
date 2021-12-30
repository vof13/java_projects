package ru.skillbox;

public class Screen {

    final double diagonal;
    final ScreenType type;
    final double weight;

    public Screen(double diagonal, ScreenType type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }
}
