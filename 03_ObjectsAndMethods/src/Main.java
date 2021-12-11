public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40);
        basket.add("Bread", 50, 5, 50.0);
        basket.add("Cheese", 100, 2, 100);
        basket.print("basket");
        System.out.println(basket.getTotalWeight());

        Arithmetic arithmetic = new Arithmetic(5, 7);
        arithmetic.summ();
        arithmetic.multipl();
        arithmetic.max();
        arithmetic.min();

        Printer printer = new Printer();
        printer.append("text1");
        printer.append("text2", "document2");
    }
}
