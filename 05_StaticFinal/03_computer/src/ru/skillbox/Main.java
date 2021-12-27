package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer("Dell", "My computer");
        Processor processor = new Processor(1500, 4, "Intel", 100);
        Ram ram = new Ram("ram", 2000, 200);
        Storage storage = new Storage("HDD", 3000, 300);
        Screen screen = new Screen(18.5, "IPS", 400);
        Keyboard keyboard = new Keyboard("notebook", "YES", 50);
        computer.setProcessor(processor);
        computer.setRam(ram);
        computer.setStorage(storage);
        computer.setScreen(screen);
        computer.setKeyboard(keyboard);

        System.out.println(computer.totalWeight());
        computer.allInformation();


    }
}
