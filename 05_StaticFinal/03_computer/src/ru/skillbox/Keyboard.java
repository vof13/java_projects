package ru.skillbox;

public class Keyboard {

    final KeyboardType type;
    final String backlight;
    final double weight;

    public Keyboard(KeyboardType type, String backlight, double weight) {
        this.type = type;
        this.backlight = backlight;
        this.weight = weight;
    }
}
