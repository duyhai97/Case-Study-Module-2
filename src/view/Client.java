package view;

import controller.Check;
import controller.ManagerAccount;
import Model.Account;
import Model.User;
import observer.AppNotification;
import observer.EmailNotification;
import observer.PhoneNotification;
import storage.fileAccount;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Account> accountList;
        fileAccount fileAccounts = fileAccount.getINSTANCE();
        accountList = fileAccounts.getData();
        ManagerAccount hai = new ManagerAccount(accountList);
        Check check = new Check(accountList);
        PhoneNotification phone = new PhoneNotification();
        EmailNotification email = new EmailNotification();
        AppNotification app = new AppNotification();


        while (true){
            System.out.println("Chào bạn đến với menu quản lí tài khoản ngân hàng.");
            System.out.println("Nhập 1: Thêm mới tài khoản.");
            System.out.println("Nhập 2: Xóa tài khoản khỏi hệ thống.");
            System.out.println("Nhập 3: Sửa thông tin tài khoản.");
            System.out.println("Nhập 4: Hiển thị thông tin tài khoản.");
            System.out.println("Nhập 5: Đăng kí nhận thông báo.");
            System.out.println("Nhập 6: Nạp tiền vào tài khoản");
            System.out.println("Nhập 7: Rút tiền");
            System.out.println("Nhập 8: Chuyển tiền.");
            System.out.println("Nhập 9: Kết thúc.");
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
                    int id1;
                    Scanner scanner8 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số chứng minh cho tài khoản cần xóa: ");
                        id1 = scanner8.nextInt();
                    }while (!check.checkID2(id1));
                    hai.deleteAccount(id1);
                    System.out.println("Xóa tài khoản thành công.");
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
                                        acc.notification1("Đổi tên thành công. Thêm yêu cầu khác: " );
                                        break;
                                    case 2:
                                        System.out.println("Nhập ngày sinh mới: ");
                                        Scanner scanner12 = new Scanner(System.in);
                                        String newDateOfBirth = scanner12.nextLine();
                                        acc.getUser().setDateOfBirth(newDateOfBirth);
                                        acc.notification1("Đổi Ngày sinh thành công. Thêm yêu cầu khác: " );
                                        break;
                                    case 3 :
                                        System.out.println("Nhập số điện thoại mới: ");
                                        Scanner scanner13 = new Scanner(System.in);
                                        int newPhoneNumber = scanner13.nextInt();
                                        acc.getUser().setPhoneNumber(newPhoneNumber);
                                        acc.notification1("Đổi số điện thoại thành công. Thêm yêu cầu khác: " );
                                        break;
                                    case 4:
                                        System.out.println("Nhập mật khẩu mới: ");
                                        Scanner scanner14 = new Scanner(System.in);
                                        int newPassWord = scanner14.nextInt();
                                        acc.setPassWord(newPassWord);
                                        acc.notification1("Đổi mật khẩu thành công. Thêm yêu cầu khác: " );
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
                    int iddk;
                    Scanner s1 = new Scanner(System.in);
                    do {
                        System.out.print("Nhập số chứng minh cho tài khoản cần đăng kí: ");
                        iddk = s1.nextInt();
                    }while (!check.checkID2(iddk));


                    for (int i = 0; i <accountList.size() ; i++) {
                        if (accountList.get(i).getUser().getId() == iddk){
                        Account acc = accountList.get(i);
                            boolean thoat = true;
                            while (thoat) {
                                Scanner s = new Scanner(System.in);
                                System.out.println("Nhập 1 để Đăng kí nhận thông báo: ");
                                System.out.println("Nhập 2 để hủy nhận thông báo: ");
                                System.out.println("Nhập 3 kiểm tra trạng thái.");
                                System.out.println("Nhập 4 quay lại.");
                                int choice5 = s.nextInt();
                                    switch (choice5) {
                                        case 1:
                                            boolean end2 = true;
                                            while (end2) {
                                                System.out.println("nhập 1 để nhận thông báo qua điện thoại.");
                                                System.out.println("nhập 2 để nhận thông báo qua Email.");
                                                System.out.println("nhập 3 để nhận thông báo qua App");
                                                System.out.println("nhập 4 thoát menu đăng kí thông báo. ");
                                                Scanner s6 = new Scanner(System.in);
                                                int choice1 = s6.nextInt();
                                                switch (choice1) {
                                                    case 1:
                                                        if (acc.getObserverList().equals(phone)){
                                                            System.out.println("ban da dang ki roi,");
                                                            break;
                                                        }
                                                        else acc.add(phone);
                                                        System.out.println("đăng kí thành công. Thêm lựa chọn khác: ");
                                                        break;
                                                    case 2:
                                                        acc.add(email);
                                                        System.out.println("Đăng kí thành công. Thêm lựa chon khác: ");
                                                        break;

                                                    case 3:
                                                        acc.add(app);
                                                        System.out.println("Đăng kí thành công. Thên lựa chon khác: ");
                                                        break;
                                                    case 4:
                                                        end2 = false;
                                                        break;
                                                }
                                                fileAccounts.setData(accountList);
                                            }

                                            break;
                                        case 2:
                                            boolean end3 = true;
                                            while (end3){
                                                System.out.println("nhập 1 để hủy đăng kí thông báo qua điện thoại");
                                                System.out.println("nhập 2 để hủy đăng kí thông báo qua email");
                                                System.out.println("nhập 3 để hủy đăng kí thông báo qua App");
                                                System.out.println("nhập 4 thoát nemu hủy đăng kí: ");
                                                Scanner s7 = new Scanner(System.in);
                                                int choice2 = s7.nextInt();
                                                switch (choice2){
                                                    case 1:
                                                        acc.delete(phone);
                                                        System.out.println("Hủy thành công. Thêm lựa chon khác: ");
                                                        break;
                                                    case 2:
                                                        acc.delete(email);
                                                        System.out.println("Hủy thành công. Thêm lựa chon khác: ");
                                                        break;
                                                    case 3:
                                                        acc.delete(app);
                                                        System.out.println("Hủy thành công. Thêm lựa chọn khác: ");
                                                        break;
                                                    case 4:
                                                        end3 = false;
                                                        break;
                                                }
                                                fileAccounts.setData(accountList);
                                            }
                                            break;

                                        case 3:
                                            System.out.println(acc.getAllObserver());


                                            break;
                                        case 4:
                                            thoat = false;
                                            break;
                                    }
                                    fileAccounts.setData(accountList);
                                }
                            }
                        }
                    break;

                case 6:
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

                case 7:
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

                case 8:
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
                case 9:
                    return;
                default:
                    System.out.println("Nhập sai thông tin Menu.");
            }
        }
    }
}

