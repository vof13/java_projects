package ru.skillbox;

public class Processor {

    final int frequency;
    final int numberCores;
    final String manufacturer;
    final double weight;

    public Processor(int frequency, int numberCores, String manufacturer, double weight) {
        this.frequency = frequency;
        this.numberCores = numberCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }
}
