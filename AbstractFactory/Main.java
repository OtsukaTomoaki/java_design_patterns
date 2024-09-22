package AbstractFactory;
import AbstractFactory.factory.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java Main class.name.of.ConcreteFactory class.name.of.ConcreteFactory");
            System.out.println("Example 1: java Main ListFactory.ListFactory TableFactory.TableFactory");
            System.out.println("Example 2: java Main TableFactory.TableFactory ListFactory.ListFactory");
            System.exit(0);
        }

        String filename = args[0];
        String classname = args[1];

        Factory factory = Factory.getFactory(filename);

        // Blog
        Link blog1 = factory.createLink("ブログ1", "http://blog1.com");
        Link blog2 = factory.createLink("ブログ2", "http://blog2.com");
        Link blog3 = factory.createLink("ブログ3", "http://blog3.com");

        Tray blogTray = factory.createTray("ブログ");
        blogTray.add(blog1);
        blogTray.add(blog2);
        blogTray.add(blog3);

        // News
        Link news1 = factory.createLink("ニュース1", "http://news1.com");
        Link news2 = factory.createLink("ニュース2", "http://news2.com");
        Tray news3 = factory.createTray("ニュース3");

        news3.add(factory.createLink("Yahoo!", "http://yahoo.com"));
        news3.add(factory.createLink("Google", "http://google.com"));

        Tray newsTray = factory.createTray("ニュース");
        newsTray.add(news1);
        newsTray.add(news2);
        newsTray.add(news3);

        // Page
        Page page = factory.createPage("LinkPage", "Author");
        page.add(blogTray);
        page.add(newsTray);

        page.output();
    }
}