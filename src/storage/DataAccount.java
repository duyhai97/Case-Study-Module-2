package storage;

import Model.Account;

import java.util.List;

public interface DataAccount {

    List<Account> getData();

    void setData(List<Account> accounts);
}
