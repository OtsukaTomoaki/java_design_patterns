package Composite;

public abstract class Entry {
    public abstract String getName();
    public abstract int getSize();

    public void printList() {
        printList("");
    }

    //prefixを前につけて一覧を表示する
    protected abstract void printList(String prefix);

    //文字列表現
    public String toString() {
        return getName() + " (" + getSize() + ")";
    }
}