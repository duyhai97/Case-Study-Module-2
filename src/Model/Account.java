package Model;

import java.io.Serializable;

public class Account implements Serializable {
    private User user;
    private int accountNumber;
    private int passWord;
    private double amountInAccount;

    public Account(User user,  int accountNumber,int passWord ,double amountInAccount) {
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
}