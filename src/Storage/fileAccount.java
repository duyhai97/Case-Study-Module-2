package Storage;

import Model.Account;

import java.io.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class fileAccount implements DataAccount{
    public fileAccount(){
    }

//    private static fileAccount INSTANCE;
//
//    public static fileAccount getINSTANCE(){
//        if (getINSTANCE() == null) INSTANCE = new fileAccount();
//        return INSTANCE;
//    }


    @Override
    public List<Account> getData() {
        File file = new File("List.txt");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() > 0){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Object obj = null;
            try {
                obj = objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            List<Account> accountList = (List<Account>) obj;
            return accountList;
        }
        else return new ArrayList<>();
    }

    @Override
    public void setData(List<Account> accounts) {
        File file = new File("List.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            objectOutputStream.writeObject(accounts);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

