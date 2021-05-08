package observer;
public interface Subject {
        void add(Observer observer);
        void delete (Observer observer);
        void notification (String mess, Subject s);
    }

