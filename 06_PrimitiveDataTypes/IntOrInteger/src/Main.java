public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        for (int i = 'А'; i <= 'я' ; i++) {
            System.out.println((char) i + " = " + i);
            if ((char) i == 'Е') {
                System.out.println('Ё' + " = " + (int) 'Ё');
            }
            if ((char) i == 'е') {
                System.out.println('ё' + " = " + (int) 'ё');
            }
        }

    }
}
