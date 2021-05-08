package controller;
import Model.Account;
//import storage.fileAccount;

import java.util.List;

public class ManagerAccount   {

    private List<Account> accountList;

//    fileAccount dataAccount = fileAccount.getINSTANCE();

    public ManagerAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

//    private static ManagerAccount Instance;


//    public static ManagerAccount getInstance(){
//        if (Instance == null) Instance = new ManagerAccount();
//        return Instance;
//    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addNewAccount(Account account){
        accountList.add(account);
//        dataAccount.setData(accountList);

    }

    public void deleteAccount(int id){
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUser().getId() == id) {
                accountList.remove(accountList.get(i));
            }
        }
//        dataAccount.setData(accountList);
    }

    public void editAccount(int id){
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getUser().getId() == id) {

            }
        }
//        dataAccount.setData(accountList);
    }

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
                    account.notification(  account.getUser().getFullName()+ " vừa nạp: " + amountToDeposit, account);
                }
                else System.out.println("Số tiền nạp vào không đúng.");
            }
        }
//        dataAccount.setData(accountList);
    }

    public void withdrawal(int accountNumber, double amountToWithdrawn){
        double fees = 5000;
        for (Account account: accountList
             ) {
            if (account.getAccountNumber() == accountNumber){
                if (account.getAmountInAccount() > (amountToWithdrawn + fees)){
                    account.setAmountInAccount(account.getAmountInAccount() - (amountToWithdrawn + fees));
                    account.notification(account.getUser().getFullName()+ " đã rút: " + amountToWithdrawn, account);
//                    System.out.println("Bạn vừa rút: " + amountToWithdrawn + "Đ từ số tài khoản: " + account.getAccountNumber() + ". Phí dịch vụ: " + fees + "Đ");
                }
            }
        }
//        dataAccount.setData(accountList);
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
                            account1.notification( account1.getUser().getFullName() +" Chuyển cho " + account2.getUser().getFullName() + ": " + amountToTransferred, account2);
//                            account2.notification(account2.getUser().getFullName()+" Nhận được: " + amountToTransferred, account1 );
                        }
                    }
                }
            }
        }
//        dataAccount.setData(accountList);
    }

}
