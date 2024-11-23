package ChainOfResponsibility;

public abstract class Support {
    private String name; // トラブル解決者の名前
    private Support next; // たらい回し先

    public Support(String name) {
        this.name = name;
    }

    // たらい回し先を設定
    public Support setNext(Support next) {
        this.next = next;
        return next;
    }

    // トラブル解決の手順
    public final void support(Trouble trouble) {
        if (resolve(trouble)) {
            done(trouble);
        } else if (next != null) {
            next.support(trouble);
        } else {
            fail(trouble);
        }
    }

    public String toString() {
        return "[" + name + "]";
    }

    protected abstract boolean resolve(Trouble trouble);

    protected void done(Trouble trouble) {
        System.out.println(trouble + " is resolved by " + this + ".");
    }

    protected void fail(Trouble trouble) {
        System.out.println(trouble + " cannot be resolved.");
    }
}