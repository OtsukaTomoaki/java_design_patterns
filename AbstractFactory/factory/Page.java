package AbstractFactory.factory;

import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.util.List;

public abstract class Page {
    protected String title;
    protected String author;
    protected List<Item> content = new ArrayList<Item>();
    public Page(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void add(Item item) {
        content.add(item);
    }
    public void output() {
        try {
            String filename = title + ".html";
            Files.write(Path.of(filename), makeHTML().getBytes());
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public abstract String makeHTML();
}