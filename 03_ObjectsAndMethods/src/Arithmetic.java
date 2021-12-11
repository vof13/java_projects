public class Arithmetic {

    int a;
    int b;

    public Arithmetic (int a, int b){
        this.a = a;
        this.b = b;
    }

    public void summ () {
        System.out.println(a + b);
    }

    public void multipl () {
        System.out.println(a*b);
    }

    public void max () {
        System.out.println(Math.max(a, b));
    }

    public void min (){
        System.out.println(Math.min(a, b));
    }
}
