public class Printer {
    String queue = "" ;
    int pagesNoPrint = 0;
    int pagesTotalPrint = 0;

    public void append (String text, String name, int quantity) {
        queue = queue + text + " " + name + " " + quantity + "\n";
        pagesNoPrint += quantity;
    }

    public void append(String text, String name){
       append(text, name, 1);
    }

    public void append (String text) {
        append(text, "");
    }

    public void clear () {
        queue = "";
    }

    public void print () {
        System.out.println(queue);
        clear();
        pagesTotalPrint += pagesNoPrint;
        pagesNoPrint = 0;
    }

    public int getPendingPagesCount () {
        return pagesNoPrint;
    }

    public int getPagesTotalPrint () {
        return pagesTotalPrint;
    }





}
