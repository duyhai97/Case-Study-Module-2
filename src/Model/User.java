package Model;

import java.io.Serializable;

public class User implements Serializable {
    private String fullName;
    private int id;
    private String dateOfBirth;
    private int phoneNumber;
    private String address;

    public User(String fullName, int id, String dateOfBirth, int phoneNumber, String address) {
        this.fullName = fullName;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Họ tên :" + fullName  +
                ", Số chứng minh: " + id +
                ", Ngày sinh: " + dateOfBirth +
                ", Số điện thoại: " + phoneNumber +
                ", Địa chỉ: " + address ;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
