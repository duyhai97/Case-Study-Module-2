package Controller;

import Model.Account;
import Storage.DataAccount;
import Storage.fileAccount;

import java.util.ArrayList;
import java.util.List;

public class ManagerAccount {
    private String name;
    private List<Account> accountList;
//    DataAccount dataAccount = fileAccount.getINSTANCE();
    DataAccount dataAccount = new fileAccount();

    public ManagerAccount() {
    }

    public ManagerAccount(String name, List<Account> accountList) {
        this.name = name;
        this.accountList = accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addNewAccount(Account account){
        accountList.add(account);
        dataAccount.setData(accountList);

    }

    public void deleteAccount(int id){
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUser().getId() == id) {
                accountList.remove(accountList.get(i));
            }
        }
        dataAccount.setData(accountList);
    }

//    public void editAccount(int id, Account account){
//        for (int i = 0; i < accountList.size(); i++) {
//            if (accountList.get(i).getUser().getId() == id) {
//                accountList.get(i) = account;
//            }
//        }
//        dataAccount.setData(accountList);
//    }

    public void searchByID(int id){
        for (Account account: accountList) {
            if (account.getUser().getId() == id){
                System.out.println(account);
            }
        }
    }

    public void showAllAccount(){
        for (Account account: accountList
             ) {
            System.out.println(account);
        }
    }

    public void inputMoney(int accountNumber, double amountToDeposit){
        for (Account account: accountList
             ) {
            if (account.getAccountNumber() == accountNumber){
                if (amountToDeposit > 0 ){
                    account.setAmountInAccount(account.getAmountInAccount() + amountToDeposit);
                    System.out.println("Bạn vừa nạp: " + amountToDeposit + "Đ vào tài khoản: " + account );
                }
                else System.out.println("Số tiền nạp vào không đúng.");
            }
        }
        dataAccount.setData(accountList);
    }

    public void withdrawal(int accountNumber, double amountToWithdrawn){
        double fees = 5000;
        for (Account account: accountList
             ) {
            if (account.getAccountNumber() == accountNumber){
                if (account.getAmountInAccount() > (amountToWithdrawn + fees)){
                    account.setAmountInAccount(account.getAmountInAccount() - (amountToWithdrawn + fees));
                    System.out.println("Bạn vừa rút: " + amountToWithdrawn + "Đ từ số tài khoản: " + account.getAccountNumber() + ". Phí dịch vụ: " + fees + "Đ");
                }
            }
        }
        dataAccount.setData(accountList);
    }

    public void transfers(int accountNumber1, int accountNumber2, double  amountToTransferred){
        double fees = 5000;
        for (Account account1: accountList) {
            if (account1.getAccountNumber() == accountNumber1){
                if ((amountToTransferred + fees) <= account1.getAmountInAccount()){
                    for (Account account2: accountList) {
                        if (account2.getAccountNumber() == accountNumber2){
                            account1.setAmountInAccount(account1.getAmountInAccount() - (amountToTransferred + fees));
                            account2.setAmountInAccount(account2.getAmountInAccount() + amountToTransferred);
                            System.out.println("Bạn vừa chuyển: " + amountToTransferred + "Đ từ số tài khoản: " + account1.getAccountNumber() + " Đến số tài khoản: " + account2.getAccountNumber() + ". Phí dịch vụ " + fees );
                        }
                    }
                }
            }
        }
        dataAccount.setData(accountList);
    }

}
