package Controller;

import Model.Account;

import java.util.ArrayList;
import java.util.List;

public class Check {
    List<Account> accountList = new ArrayList<>();

    public Check(List<Account> accountList) {
        this.accountList = accountList;
    }

    public boolean checkID1(int id){
        for (Account account: accountList) {
            if (account.getUser().getId() == id){
                System.out.println("Số chứng minh đã đăng kí rồi:.");
                return false;
            }
        }
        return true;
    }

    public boolean checkID2(int id){
        for (Account account: accountList) {
            if (account.getUser().getId() == id) return true;
        }
        System.out.println("Không tìm thấy tài khoản tương ứng với số chứng minh đã nhập.");
        return false;
    }

    public boolean checkPhoneNumber(int phoneNumber){
        for (Account account: accountList) {
            if (account.getUser().getPhoneNumber() == phoneNumber){
                System.out.println("Số điện thoại đã đăng kí rồi.");
                return false;
            }
        }
        return true;
    }

    public boolean checkAccountNumber1(int accountNumber){
        for (Account account: accountList) {
            if (account.getAccountNumber() == accountNumber){
                System.out.println("Số tài khoản đã đăng kí rồi.");
                return false;
            }
        }
        return true;
    }

    public boolean checkAccountNumber2(int accountNumber){
        for (Account account: accountList) {
            if (account.getAccountNumber() == accountNumber) return true;
        }
        System.out.println("Không tìm thấy tài khoản.");
        return false;
    }

    public boolean checkPassWord(int passWord){
        for (Account account: accountList) {
            if (account.getPassWord() == passWord) return true;
        }
        System.out.println("Sai mật khẩu: ");
        return false;
    }

    public boolean checkAmountInAccount(double money){
        double fees = 5000;
        for (Account account: accountList) {
            if (account.getAmountInAccount() >= (money + fees) ) return true;
        }
        System.out.println("Số tiền cần chuyển vượt quá số tiền trong tài khoản.");
        return false;
    }

}
