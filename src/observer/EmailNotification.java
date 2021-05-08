package observer;

import java.io.Serializable;

public class EmailNotification implements Observer , Serializable {
    @Override
    public void update(String mess) {
        System.out.println("Email: " + mess);
    }
}
