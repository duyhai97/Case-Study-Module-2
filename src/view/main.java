package view;

import Model.Account;
import Model.User;
import controller.ManagerAccount;
import observer.EmailNotification;
import observer.Observer;
import observer.PhoneNotification;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        List<Account> accountList = new ArrayList<>();
        User user1 = new User("Hải", 111, "11/3/2010", 222, "Thanh Hoa");
        User user2 = new User("Hoàng", 111, "11/3/2010", 222, "Thanh Hoa");
        User user3 = new User("hà", 111, "11/3/2010", 222, "Thanh Hoa");
        Observer phone = new PhoneNotification();
        Observer email = new EmailNotification();
        Account hai = new Account(user1,123,123456,50000.0);
        Account hoang = new Account(user2,124,123456,50000.0);
        Account hà = new Account(user3,125,123456,50000.0);
        accountList.add(hai);
        accountList.add(hoang);
        accountList.add(hà);
        hai.add(email);
        hai.add(phone);
        hoang.add(phone);
        ManagerAccount maa = new ManagerAccount(accountList);
        maa.transfers(123,125,5000);
        maa.inputMoney(124, 100000);




    }
}
