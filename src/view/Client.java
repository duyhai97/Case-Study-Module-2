package view;

import controller.Check;
import controller.ManagerAccount;
import Model.Account;
import Model.User;
import storage.fileAccount;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Account> accountList;
        fileAccount fileAccounts = fileAccount.getINSTANCE();
        accountList = fileAccounts.getData();

        ManagerAccount hai = new ManagerAccount(accountList);
//        ManagerAccount hai = ManagerAccount.getInstance();
        Check check = new Check(accountList);
        while (true){
            System.out.println("Chào bạn đến với menu quản lí tài khoản ngân hàng.");
            System.out.println("Nhập 1: Thêm mới tài khoản.");
            System.out.println("Nhập 2: Xóa tài khoản khỏi hệ thống.");
            System.out.println("Nhập 3: Sửa thông tin tài khoản.");
            System.out.println("Nhập 4: Hiển thị thông tin tài khoản.");
            System.out.println("Nhập 5: Nạp tiền vào tài khoản");
            System.out.println("Nhập 6: Rút tiền");
            System.out.println("Nhập 7: Chuyển tiền.");
            System.out.println("Nhập 8: Kết thúc.");
            Scanner scanner1 = new Scanner(System.in);
            int choose = scanner1.nextInt();
            switch (choose){
                case 1:
                    System.out.print("Nhập họ tên đầy đủ: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String fullName = scanner2.nextLine();
                    int id;
                    Scanner scanner3 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số chứng minh thư: ");
                        id = scanner3.nextInt();
                    }while (!check.checkID1(id));
                    System.out.print("Nhập ngày tháng năm sinh: ");
                    Scanner scanner4 = new Scanner(System.in);
                    String dateOfBirth = scanner4.nextLine();
                    Scanner scanner5 = new Scanner(System.in);
                    System.out.print("Nhập số điện thoại: ");
                    int phoneNumber = scanner5.nextInt();
                    System.out.print("Nhập địa chỉ thường trú: ");
                    Scanner scanner6 = new Scanner(System.in);
                    String address = scanner6.nextLine();
                    User user = new User(fullName,id, dateOfBirth,phoneNumber,address);
                    int accountNumber;
                    Scanner scanner7 = new Scanner(System.in);
                    do {
                        System.out.println("Nhập số tài khoản: ");
                        accountNumber = scanner7.nextInt();
                    }while (!check.checkAccountNumber1(accountNumber));

                    int password = 111111;
                    double amountInAccount = 50000;
                    Account account = new Account(user, accountNumber,password, amountInAccount);
                    hai.addNewAccount(account);
                    break;
                case 2:
                    System.out.print("Nhập số chứng minh cho tài khoản cần xóa: ");
                    Scanner scanner8 = new Scanner(System.in);
                    int id1 = scanner8.nextInt();
                    hai.deleteAccount(id1);
                    break;
                case 3:
                    Scanner scanner9 = new Scanner(System.in);
                    int id2;
                    do {
                        System.out.print("nhập số chứng minh cho tài khoản cần sửa: ");
                        id2 = scanner9.nextInt();
                    }while (!check.checkID2(id2));

                    for (Account acc: accountList) {
                        if (acc.getUser().getId() == id2){
                            Scanner scanner10 = new Scanner(System.in);
                            boolean isExit = true;
                            while (isExit){
                                System.out.println("Nhập 1 để thay đổi tên người dùng.");
                                System.out.println("Nhập 2 để thay đổi ngày sinh.");
                                System.out.println("Nhập 3 để thay đổi số điện thoại.");
                                System.out.println("Nhập 4 để thay đổi mật khẩu.");
                                System.out.println("Nhập 5 để thoát khỏi menu sửa. ");
                                int type = scanner10.nextInt();
                                switch (type){
                                    case 1 :
                                        System.out.println("Nhập tên mới");
                                        Scanner scanner11 = new Scanner(System.in);
                                        String newFullName = scanner11.nextLine();
                                        acc.getUser().setFullName(newFullName);
                                        System.out.println("đổi tên thành : " + newFullName);
                                        System.out.println("thêm yêu cầu khác: ");
                                        break;
                                    case 2:
                                        System.out.println("Nhập ngày sinh mới: ");
                                        Scanner scanner12 = new Scanner(System.in);
                                        String newDateOfBirth = scanner12.nextLine();
                                        acc.getUser().setDateOfBirth(newDateOfBirth);
                                        System.out.println("đổi ngày sinh thành: " + newDateOfBirth);
                                        break;
                                    case 3 :
                                        System.out.println("Nhập số điện thoại mới: ");
                                        Scanner scanner13 = new Scanner(System.in);
                                        int newPhoneNumber = scanner13.nextInt();
                                        acc.getUser().setPhoneNumber(newPhoneNumber);
                                        System.out.println("Đổi số điện thoại thành: " + newPhoneNumber);
                                        break;
                                    case 4:
                                        System.out.println("Nhập mật khẩu mới: ");
                                        Scanner scanner14 = new Scanner(System.in);
                                        int newPassWord = scanner14.nextInt();
                                        acc.setPassWord(newPassWord);
                                        System.out.println("đổi mật khẩu: " + newPassWord);
                                        break;
                                    case 5 :
                                        isExit = false;
                                        break;
                                    default:
                                        throw new IllegalStateException("Unexpected value: " + type);
                                }
                                fileAccounts.setData(accountList);
                            }
                        }
                    }
                    break;

                case 4:
                    boolean exit = true;
                    while (exit){
                        Scanner scanner15 = new Scanner(System.in);
                        System.out.println("nhập 1 để tìm kiếm theo số chứng minh thư: ");
                        System.out.println("nhâp 2 để hiển thị tất cả tài khoản ");
                        System.out.println("nhaap3 để thoát khỏi menu tìm kiếm.");
                        int choice = scanner15.nextInt();
                        switch (choice){
                            case 1:
                                int id3;
                                Scanner scanner16 = new Scanner(System.in);
                                do {
                                    System.out.print("Nhập số chứng minh thư để tìm kiếm tài khoản: ");
                                    id3 = scanner16.nextInt();
                                }while (!check.checkID2(id3));
                                hai.searchByID(id3);
                                System.out.println("Tìm kiếm thêm: ");
                                break;
                            case 2:
                                hai.showAllAccount();
                                System.out.println("Tìm kiếm thêm: ");
                                break;
                            case 3:
                                exit = false;
                                break;
                        }
                    }
                    break;

                case 5:
                    int accountNumber1;
                    Scanner scanner17 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản cần nạp tiền: ");
                        accountNumber1 = scanner17.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber1));
                    Scanner scanner18 = new Scanner(System.in);
                    int passWord1;
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        passWord1 = scanner18.nextInt();
                    }while (!check.checkPassWord(passWord1));
                    Scanner scanner19 = new Scanner(System.in);
                    System.out.println("Nhập số tiền cần nạp");
                    double amountToDeposit = scanner19.nextDouble();
                    hai.inputMoney(accountNumber1, amountToDeposit);
                    break;

                case 6:
                    Scanner scanner20 = new Scanner(System.in);
                    int accountNumber2;
                    do {
                        System.out.print("Nhập số tài khoản rút tiền: ");
                        accountNumber2 = scanner20.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber2));
                    double amountToWithdrawn;
                    Scanner scanner21 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tiền cần rút: ");
                        amountToWithdrawn = scanner21.nextDouble();
                    }while (!check.checkAmountInAccount(amountToWithdrawn));
                    Scanner scanner22 = new Scanner(System.in);
                    int password2;
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        password2 = scanner22.nextInt();
                    }while (!check.checkPassWord(password2));
                    hai.withdrawal(accountNumber2, amountToWithdrawn);
                    break;

                case 7:
                    int accountNumber3;
                    Scanner scanner23 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản chuyển tiền: ");
                        accountNumber3 = scanner23.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber3));
                    int password3;
                    Scanner scanner24 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        password3 = scanner24.nextInt();
                    }while (!check.checkPassWord(password3));
                    int accountNumber4;
                    Scanner scanner25 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản nhận: ");
                        accountNumber4 = scanner25.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber4));
                    double amountToTransferred;
                    Scanner scanner26 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tiền cần chuyển: ");
                        amountToTransferred = scanner26.nextDouble();
                    }while (!check.checkAmountInAccount(amountToTransferred));
                    hai.transfers(accountNumber3,accountNumber4,amountToTransferred);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Nhập sai thông tin Menu.");
            }
        }
    }
}

