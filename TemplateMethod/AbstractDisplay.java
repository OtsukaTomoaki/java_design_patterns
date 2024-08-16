package TemplateMethod;

public interface AbstractDisplay {
    public void open();
    public void print();
    public void close();
    default void display() {
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}