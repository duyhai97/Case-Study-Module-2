package Model;

import observer.Observer;
import observer.Subject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable, Subject {
    private User user;
    private int accountNumber;
    private int passWord;
    private double amountInAccount;
    private List<Observer> observerList = new ArrayList<>();

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }

    public Account(User user, int accountNumber, int passWord , double amountInAccount) {
        this.user = user;
        this.accountNumber = accountNumber;
        this.passWord = passWord;
        this.amountInAccount = amountInAccount;
    }

    @Override
    public String toString() {
        return  user + "\n" +
                ", Số tài khoản: " + accountNumber +
                ", Mật khẩu: " + passWord +
                ", Số dư trong tài khoản: " + amountInAccount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }

    public double getAmountInAccount() {
        return amountInAccount;
    }

    public void setAmountInAccount(double amountInAccount) {
        this.amountInAccount = amountInAccount;
    }


    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void delete(Observer observer) {
    observerList.remove(observer);
    }

    @Override
    public void notification(String mess, Subject subject) {

        for (Observer o: observerList
             ) {
            o.update(mess);
        }
//        System.out.println(((Account) subject).getUser().getFullName());
        for (Observer ob: ((Account) subject).getObserverList()
             ) {
            ob.update(mess);
        }
    }
}
