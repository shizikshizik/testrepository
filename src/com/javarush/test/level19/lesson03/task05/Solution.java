package com.javarush.test.level19.lesson03.task05;

import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы.
Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("Ukraine","UA");
        countries.put("Russia","RU");
        countries.put("Canada","CA");
    }

    public static class DataAdapter implements RowItem {
        Customer customer;
        Contact contact;

        public DataAdapter(Customer customer, Contact contact)
        {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            return countries.get(customer.getCountryName());
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            return contact.getName().substring(contact.getName().indexOf(' ')).trim();
        }

        @Override
        public String getContactLastName()
        {
            return contact.getName().substring(0,contact.getName().indexOf(',')).trim();
        }

        @Override
        public String getDialString()
        {
            return "callto://"+contact.getPhoneNumber().substring(0,3)
                    +contact.getPhoneNumber().substring(4,7)
                    +contact.getPhoneNumber().substring(8,11)
                    +contact.getPhoneNumber().substring(12,14)
                    +contact.getPhoneNumber().substring(15);
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}