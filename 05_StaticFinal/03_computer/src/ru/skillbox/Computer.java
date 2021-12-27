package ru.skillbox;

public class Computer {

    private Processor processor;
    private Ram ram;
    private Storage storage;
    private Screen screen;
    private Keyboard keyboard;

    final String vendor;
    final String name;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public double totalWeight () {
        return processor.weight + ram.weight + storage.weight +
                screen.weight + keyboard.weight;
    }

    public void allInformation (){
        System.out.println("Vendor: " + vendor +". Name: " + name);
        System.out.println("Processor: Производитель " + processor.manufacturer +
                ". Частота: " + processor.frequency + ". Количество ядер: " + processor.numberCores
        + ". Вес " + processor.weight);
        System.out.println("RAM: " + "Тип: " + ram.type + ". Объём: " + ram.volume + ". Вес " + ram.weight);
        System.out.println("Storage: " + "Тип: " + storage.type + ". Объём памяти: " + storage.memoryCapacity
                + ". Вес " + storage.weight);
        System.out.println("Screen: " + "Тип: " + screen.type + ". Диагональ: " + screen.diagonal
                + ". Вес " + screen.weight);
        System.out.println("Keyboard: " + "Тип: " + keyboard.type + ". Наличие подсветки: " + keyboard.backlight
                + ". Вес " + keyboard.weight);
    }



    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Ram getRam() {
        return ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
