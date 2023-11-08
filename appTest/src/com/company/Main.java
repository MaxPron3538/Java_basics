package com.company;

import java.math.BigDecimal;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    private static Collection<Account> accounts;

    public static void main(String[] args) {
        accounts = new ArrayList<>();
        Account account1 = new Account();
        account1.setId(1);
        account1.setFirstName("Ilia");
        account1.setLastName("Pron");
        account1.setEmail("Ilia12@gmail.com");
        account1.setBalance(2345);
        account1.setMonth(Month.MAY);
        account1.setSex(Sex.MALE);

        Account account2 = new Account();
        account2.setId(2);
        account2.setFirstName("Max");
        account2.setLastName("Pron");
        account2.setEmail("Max23@mail.ru");
        account2.setBalance(4545);
        account2.setMonth(Month.AUGUST);
        account2.setSex(Sex.MALE);

        Account account3 = new Account();
        account3.setId(3);
        account3.setFirstName("Liza");
        account3.setLastName("Korshik");
        account3.setEmail("Liza32@gmail.com");
        account3.setBalance(2634);
        account3.setMonth(Month.MAY);
        account3.setSex(Sex.FEMALE);

        accounts.add(account1);
        accounts.add(account2);
        accounts.add(account3);

        Map<Character,Long> mapAccounts = accounts.stream().map(Account::getFirstName)
                .flatMapToInt(String::chars).mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        /*
        for(Map.Entry<Month,Integer> entry : mapAccounts.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

         */





    }

}
