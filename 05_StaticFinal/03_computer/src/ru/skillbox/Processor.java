package ru.skillbox;

public class Processor {

    final int frequency;
    final int numberCores;
    final ProcessorManufacturer manufacturer;
    final double weight;

    public Processor(int frequency, int numberCores, ProcessorManufacturer manufacturer, double weight) {
        this.frequency = frequency;
        this.numberCores = numberCores;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }
}
