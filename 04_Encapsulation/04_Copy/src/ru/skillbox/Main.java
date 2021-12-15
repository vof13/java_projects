package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(5.0, 7.0, 90.00);
        Cargo cargo = new Cargo(dimensions, 50, "Minsk", true,
                "F0501", false);

        System.out.println(cargo.getDeliveryAddress());
        Cargo cargo2 = cargo.setDeliveryAddress("Moscow");
        System.out.println(cargo.getDeliveryAddress());
        System.out.println(cargo2.getDeliveryAddress());


    }
}
