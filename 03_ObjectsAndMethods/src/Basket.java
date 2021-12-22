public class Basket {

    private static int basketCount = 0;
    private static int totalPrice = 0;
    private static int totalItems = 0;
    private String items = "";
    private int basketPrice = 0;
    private int limit;
    private double basketWeight =0;

    public Basket() {
        increaseBasketCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.basketPrice = totalPrice;
    }

    public static int getBasketCount() {
        return basketCount;
    }

    public static void increaseBasketCount(int count) {
        basketCount += count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight){
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (basketPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " руб. " + weight*count;
        basketPrice += count * price;
        basketWeight +=weight * count;
        increaseTotalPrice(count*price);
        increaseTotalItems(count);

    }

    private static void increaseTotalItems(int count) {
        totalItems += count;
    }

    private static  void increaseTotalPrice(int i) {
        totalPrice += i;
    }

    public static double averageProductPrice() {
        return (double)totalPrice/totalItems;

    }

    public static double averageBasketPrice(){
        return (double) totalPrice/basketCount;
    }

    public void clear() {
        items = "";
        basketPrice = 0;
        basketWeight = 0;
    }

    public int getBasketPrice() {
        return basketPrice;
    }

    public double getBasketWeight(){
        return basketWeight;
    }


    public static int getTotalPrice() {
        return totalPrice;
    }

    public static int getTotalItems() {
        return totalItems;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
