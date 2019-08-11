package NiuKeLeetCode;

/**
 * create with NiuKeLeetCode
 * USER: husterfox
 */
public class Singleton {
    private Singleton singleton;

    private Singleton() {

    }

    public Singleton getSingleton() {
        if (singleton == null) {
            synchronized (this) {
                if (singleton != null) {
                    singleton = new Singleton();
                }
                return singleton;
            }
        }
        return singleton;
    }
}
