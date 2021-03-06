package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        /*
        String number = String.format("%+d%010d", 7, 501234567);
        number = String.format("%s(%s)%s-%s-%s" , number.substring(0, number.length() - 10),
                number.substring(number.length() - 10, number.length() - 7),
                number.substring(number.length() - 7, number.length() - 4),
                number.substring(number.length() - 4, number.length() - 2),
                number.substring(number.length() - 2, number.length()));
        System.out.println(number);
        */
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;
        public IncomeDataAdapter(IncomeData incomeData) {
            this.data = incomeData;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String number = String.format("%+d%010d", data.getCountryPhoneCode(), data.getPhoneNumber());
            number = String.format("%s(%s)%s-%s-%s" , number.substring(0, number.length() - 10),
                    number.substring(number.length() - 10, number.length() - 7),
                    number.substring(number.length() - 7, number.length() - 4),
                    number.substring(number.length() - 4, number.length() - 2),
                    number.substring(number.length() - 2, number.length()));
            return number;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
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