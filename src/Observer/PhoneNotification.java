package Observer;

public class PhoneNotification implements Observer {
    @Override
    public void update(String mess) {
        System.out.println("Sms" + mess);
    }
}
