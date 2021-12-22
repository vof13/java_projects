public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 50, 5, 50.0);
        basket.add("Cheese", 100, 2, 100);
        basket.print("basket");
        Basket basket2 = new Basket();
        basket2.add("Milk", 40);
        basket2.add("Bread", 50, 5, 50.0);
        basket2.add("Cheese", 100, 7, 100);
        basket2.print("basket2");

        System.out.println(Basket.getBasketCount());
        System.out.println(Basket.getTotalItems());
        System.out.println(Basket.getTotalPrice());
        System.out.println(Basket.averageProductPrice());
        System.out.println(Basket.averageBasketPrice());



//        Arithmetic arithmetic = new Arithmetic(5, 7);
//        arithmetic.summ();
//        arithmetic.multipl();
//        arithmetic.max();
//        arithmetic.min();
//
//        Printer printer = new Printer();
//        printer.append("text1");
//        printer.append("text2", "document2");
    }
}
