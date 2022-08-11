import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static String path = "https://skillbox.ru/";

    public static void main(String[] args) throws InterruptedException {

        Node rootNode = new Node(path, 0);
        SiteParser siteParser = new SiteParser(rootNode);
        rootNode = new ForkJoinPool().invoke(siteParser);
        fileWriter("", rootNode);
    }

    private static void fileWriter(String tab, Node rootNode) {
        File file = new File("siteMap.txt");
        if (file.exists()) {
            file.delete();
        }
        try (FileWriter writer = new FileWriter("siteMap.txt", true)) {
          for (Node node : rootNode.getChildNode()
            ) {
                writer.write(tab +  node.getPath());
                writer.flush();
                if (node.getChildNode() != null) {
                    fileWriter(tab + "\t", node);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}