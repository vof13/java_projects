import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {
    private static final String pathSource = "https://lenta.ru/";
    private static final String pathTarget = "D:\\java_projects\\skillbox\\java_basics\\homework_4\\data\\img\\";

    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.connect(pathSource).get();
        Elements img = doc.getElementsByTag("img");
        img.stream()
                .map((element) ->  element.attr("src")  )
                .forEach((e) -> {
            try {
                getImages(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private static void getImages(String src) throws IOException {
        String name = src.substring(src.lastIndexOf('/') + 1);
        String isPicture = name.substring(name.lastIndexOf('.') + 1);

        if (isPicture.equals("jpg") || isPicture.equals("jpeg")) {
            URL url = new URL(src);
            InputStream inputStream = url.openStream();
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream(pathTarget + name));

            int b;
            while((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }

            System.out.println("Изображение " + name + " cкачано");
            outputStream.close();
            inputStream.close();
        }

    }
}
