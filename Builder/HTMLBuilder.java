package Builder;

import java.io.*;

public class HTMLBuilder extends Builder {
    private String filename = "untitled.html";
    private StringBuilder sb = new StringBuilder();

    @Override
    public void makeTitle(String title) {
        filename = title + ".html";
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"ja\">\n");
        sb.append("<head><title>\n");
        sb.append(title);
        sb.append("</title></head>\n");
        sb.append("<body>\n");
        sb.append("<h1>");
        sb.append(title);
        sb.append("</h1>\n");
    }

    @Override
    public void makeString(String str) {
        sb.append("<p>");
        sb.append(str);
        sb.append("</p>\n");
    }

    @Override
    public void makeItems(String[] items) {
        sb.append("<ul>\n");
        for (int i = 0; i < items.length; i++) {
            sb.append("<li>");
            sb.append(items[i]);
            sb.append("</li>\n");
        }
        sb.append("</ul>\n");
    }

    @Override
    public void close() {
        sb.append("</body>\n");
        sb.append("</html>\n");
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(sb.toString());
            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHTMLResult() {
        return filename;
    }
}
