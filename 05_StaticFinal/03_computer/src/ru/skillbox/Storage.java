package ru.skillbox;

public class Storage {
    final StorageType type;
    final int memoryCapacity;
    final double weight;

    public Storage(StorageType type, int memoryCapacity, double weight) {
        this.type = type;
        this.memoryCapacity = memoryCapacity;
        this.weight = weight;
    }
}
