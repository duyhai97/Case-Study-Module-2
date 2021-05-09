package observer;

import java.io.Serializable;

public class PhoneNotification implements Observer, Serializable {
    @Override
    public void update(String mess) {
        System.out.println("Phone: " + mess);
    }
}
