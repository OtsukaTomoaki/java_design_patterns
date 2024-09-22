package AbstractFactory.listfactory;

import AbstractFactory.factory.Factory;
import AbstractFactory.factory.Link;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public ListTray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public ListPage createPage(String title, String author) {
        return new ListPage(title, author);
    }
}