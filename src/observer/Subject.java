package observer;
public interface Subject {
        void add(Observer observer);
        void delete (Observer observer);
        void notification1(String mess);
        void notification (String mess, Subject s);
//        boolean check(Observer observer);
    }

