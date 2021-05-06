package View;

import Controller.Check;
import Controller.ManagerAccount;
import Model.Account;
import Model.User;
import Storage.DataAccount;
import Storage.fileAccount;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Account> accountList;
//        DataAccount fileAccounts = fileAccount.getINSTANCE();
//        accountList = fileAccounts.getData();
        DataAccount dataAccount = new fileAccount();
        accountList = dataAccount.getData();

        ManagerAccount hai = new ManagerAccount("Hải", accountList);
        Check check = new Check(accountList);

        while (true){
            System.out.println("Mời bạn nhập lựa chọn.");
            System.out.println("1: Thêm mới tài khoản.");
            System.out.println("2: Xóa tài khoản khỏi hệ thống.");
            System.out.println("3: Sửa thông tin tài khoản.");
            System.out.println("4: Tìm kiếm tài khoản theo số chứng minh.");
            System.out.println("5: Hiển thị tất cả tài khoản.");
            System.out.println("6: Nạp tiền vào tài khoản");
            System.out.println("7: Rút tiền");
            System.out.println("8: Chuyển tiền.");
            System.out.println("9: Kết thúc.");
            Scanner scanner1 = new Scanner(System.in);
            int choose = scanner1.nextInt();
            switch (choose){
                case 1:
                    System.out.print("Nhập họ tên đầy đủ: ");
                    Scanner scanner2 = new Scanner(System.in);
                    String fullName = scanner2.nextLine();
                    System.out.print("Nhập số chứng minh thư: ");
                    Scanner scanner3 = new Scanner(System.in);
                    int id = scanner3.nextInt();
                    System.out.print("Nhập ngày tháng năm sinh: ");
                    Scanner scanner4 = new Scanner(System.in);
                    String dateOfBirth = scanner4.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    Scanner scanner5 = new Scanner(System.in);
                    int phoneNumber = scanner5.nextInt();
                    System.out.print("Nhập địa chỉ thường trú: ");
                    Scanner scanner6 = new Scanner(System.in);
                    String address = scanner6.nextLine();
                    User user = new User(fullName,id, dateOfBirth,phoneNumber,address);

                    System.out.println("Nhập số tài khoản: ");
                    Scanner scanner7 = new Scanner(System.in);
                    int accountNumber = scanner7.nextInt();
                    int password = 123456;
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
                    Scanner s2 = new Scanner(System.in);
                    int id2;
                    do {
                        System.out.print("nhập số chứng minh cho tài khoản cần sửa: ");
                        id2 = s2.nextInt();
                    }while (!check.checkID2(id2));

                    for (Account acc: accountList) {
                        if (acc.getUser().getId() == id2){
                            Scanner s1 = new Scanner(System.in);
                            boolean isExit = true;
                            while (isExit){
                                System.out.println("Nhập a để thay đổi tên người dùng.");
                                System.out.println("Nhập b để thay đổi ngày sinh.");
                                System.out.println("Nhập c để thay đổi số điện thoại.");
                                System.out.println("Nhập d để thay đổi mật khẩu.");
                                System.out.println("Nhập e để thoát khỏi menu sửa. ");
                                String type = s1.nextLine();
                                switch (type){
                                    case "a" :
                                        System.out.println("Nhập tên mới");
                                        Scanner s3 = new Scanner(System.in);
                                        String newFullName = s3.nextLine();
                                        acc.getUser().setFullName(newFullName);
                                        System.out.println("đổi tên thành : " + newFullName);
                                        System.out.println("thêm yêu cầu khác: ");
                                        break;
                                    case "b":
                                        System.out.println("Nhập ngày sinh mới: ");
                                        Scanner s4 = new Scanner(System.in);
                                        String newDateOfBirth = s4.nextLine();
                                        acc.getUser().setDateOfBirth(newDateOfBirth);
                                        System.out.println("đổi ngày sinh thành: " + newDateOfBirth);
                                        break;
                                    case "c" :
                                        System.out.println("Nhập số điện thoại mới: ");
                                        Scanner s5 = new Scanner(System.in);
                                        int newPhoneNumber = s5.nextInt();
                                        acc.getUser().setPhoneNumber(newPhoneNumber);
                                        System.out.println("Đổi số điện thoại thành: " + newPhoneNumber);
                                        break;
                                    case "d":
                                        System.out.println("Nhập mật khẩu mới: ");
                                        Scanner s6 = new Scanner(System.in);
                                        int newPassWord = s6.nextInt();
                                        acc.setPassWord(newPassWord);
                                        System.out.println("đổi mật khẩu: " + newPassWord);
                                        break;
                                    case "e" :
                                        isExit = false;
                                        break;
                                }
                                dataAccount.setData(accountList);
                            }
                        }
                            }

                    break;
                case 4:
                    int id3;
                    Scanner scanner9 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số chứng minh thư để tìm kiếm tài khoản: ");
                        id3 = scanner9.nextInt();
                    }while (!check.checkID2(id3));
                    hai.searchByID(id3);
                    break;
                case 5:
                    hai.showAllAccount();
                    break;
                case 6:
                    int accountNumber1;
                    Scanner scanner10 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản cần nạp tiền: ");
                        accountNumber1 = scanner10.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber1));
                    Scanner scanner11 = new Scanner(System.in);
                    int passWord1;
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        passWord1 = scanner11.nextInt();
                    }while (!check.checkPassWord(passWord1));
                    Scanner scanner12 = new Scanner(System.in);
                    System.out.println("Nhập số tiền cần nạp");
                    double amountToDeposit = scanner12.nextDouble();
                    hai.inputMoney(accountNumber1, amountToDeposit);
                    break;

                case 7:
                    Scanner scanner13 = new Scanner(System.in);
                    int accountNumber2;
                    do {
                        System.out.print("Nhập số tài khoản rút tiền: ");
                        accountNumber2 = scanner13.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber2));
                    double amountToWithdrawn;
                    Scanner scanner14 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tiền cần rút: ");
                        amountToWithdrawn = scanner14.nextDouble();
                    }while (!check.checkAmountInAccount(amountToWithdrawn));
                    Scanner scanner15 = new Scanner(System.in);
                    int password2;
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        password2 = scanner15.nextInt();
                    }while (!check.checkPassWord(password2));
                    hai.withdrawal(accountNumber2, amountToWithdrawn);
                    break;

                case 8:
                    int accountNumber3;
                    Scanner scanner16 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản chuyển tiền: ");
                        accountNumber3 = scanner16.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber3));
                    int password3;
                    Scanner scanner17 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập mật khẩu: ");
                        password3 = scanner17.nextInt();
                    }while (!check.checkPassWord(password3));
                    int accountNumber4;
                    Scanner scanner18 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tài khoản nhận: ");
                        accountNumber4 = scanner18.nextInt();
                    }while (!check.checkAccountNumber2(accountNumber4));
                    double amountToTransferred;
                    Scanner scanner19 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số tiền cần chuyển: ");
                        amountToTransferred = scanner19.nextDouble();
                    }while (!check.checkAmountInAccount(amountToTransferred));
                    hai.transfers(accountNumber3,accountNumber4,amountToTransferred);
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Nhập sai thông tin Menu.");


            }
        }
    }
}

