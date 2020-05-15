package pl.edu.pwsztar;

import java.util.ArrayList;
import java.util.List;

public class SampleDataGenerator {
    public static List<Account> getAccountsList(){

        List<Account> accounts = new ArrayList<>();

        accounts.add(new Account(1, 250));

        accounts.add(new Account(2, 100));

        accounts.add(new Account(3, 300));

        accounts.add(new Account(4, 200));

        return accounts;
    }
}
