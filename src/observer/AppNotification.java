package observer;

import java.io.Serializable;

public class AppNotification implements Observer, Serializable {
    @Override
    public void update(String mess) {
        System.out.println("App: " + mess);
    }
}
