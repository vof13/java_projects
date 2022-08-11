import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<Node> {
    private final Node parrentNode;
    private final Logger logger = LogManager.getRootLogger();
    HashMap<String, Integer> allSiteList = new HashMap<>();
    List<SiteParser> subTasks = new ArrayList<>();

    public SiteParser(Node parrentNode) {
        this.parrentNode = parrentNode;
    }

    @Override
    protected Node compute() {
        allSiteList.put(parrentNode.getPath(), parrentNode.getLevel());
        Document document = null;
        try {
            Thread.sleep(125);
            document = Jsoup.connect(parrentNode.getPath()).get();
        } catch (IOException e) {
            logger.error("Страница не открывается: " + parrentNode.getPath());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (document != null) {
            Elements elements = document.getElementsByAttribute("href");
            for (Element element :
                    elements) {
                String url = element.attr("href");
                if (element.attr("href").matches("\\/[\\w\\/]*")
                        && !allSiteList.containsKey(url)
                        && url.contains(parrentNode.getPath())
                ) {
                    add(url, parrentNode.getLevel() + 1);
                    Node childNode = new Node(url, parrentNode.getLevel() + 1);
                    childNode.setParrentNode(parrentNode);
                    parrentNode.setChildNode(childNode);
                    SiteParser task = new SiteParser(childNode);
                    task.fork();
                    subTasks.add(task);
                }
            }
        }

        for (SiteParser task :
                subTasks) {
            task.join();
        }
        return parrentNode;
    }

    private void add(String path, Integer level) {
        if (!path.endsWith("/")) {
            path += path + '/';
        }
        allSiteList.put(path, level);
    }
}
