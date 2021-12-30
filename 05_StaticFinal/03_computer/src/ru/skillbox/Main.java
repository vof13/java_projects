package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Computer computer = new Computer("Dell", "My computer");

        computer.setProcessor(new Processor(1500, 4, ProcessorManufacturer.AMD, 100));
        computer.setRam(new Ram(RamType.LR_DIMM, 2000, 200));
        computer.setStorage(new Storage(StorageType.SSD, 3000, 300));
        computer.setScreen(new Screen(18.5, ScreenType.IPS, 400));
        computer.setKeyboard(new Keyboard(KeyboardType.COMPACT, "YES", 50));


        System.out.println(computer.totalWeight());
        computer.allInformation();


    }
}
