package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

        //String dial = "+38(050)123-45-67";
        //dial = dial.replaceAll("[^0-9]+", "");
        //dial = "callto://+" + dial;
        //System.out.println(dial);

        //String name = "Ivanov, Ivan";
        //String[] names = name.split(", ");
        //System.out.println(names[0]);

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String countryName = customer.getCountryName();
            String countryCode = null;
            if (countries.containsValue(countryName)) {
                for (Map.Entry<String, String> pair : countries.entrySet()) {
                    if (pair.getValue().equals(countryName)) {
                        countryCode = pair.getKey();
                    }
                }
            }
            return countryCode;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(", ");
            return name[1];
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(", ");
            return name[0];
        }

        @Override
        public String getDialString() {
            String dial = contact.getPhoneNumber();
            dial = dial.replaceAll("[^0-9]+", "");
            dial = "callto://+" + dial;
            return dial;
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