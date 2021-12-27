package ru.skillbox;

public class Storage {
    final String type;
    final int memoryCapacity;
    final double weight;

    public Storage(String type, int memoryCapacity, double weight) {
        this.type = type;
        this.memoryCapacity = memoryCapacity;
        this.weight = weight;
    }
}
