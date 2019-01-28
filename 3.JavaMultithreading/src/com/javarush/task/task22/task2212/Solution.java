package com.javarush.task.task22.task2212;



/*
Проверка номера телефона
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.isEmpty()) {
            return false;
        }
        else {
            if (telNumber.startsWith("+")) {
                if (telNumber.replaceAll("\\D+", "").length() == 12) {
                    //System.out.print("12 digits ");
                    return telNumber.matches("^\\+\\d+$") ||
                            telNumber.matches("^\\+\\d+-\\d+") ||
                            telNumber.matches("^\\+\\d+-\\d+-\\d+") ||
                            telNumber.matches("^\\+\\d+\\(\\d\\d\\d\\)\\d+-?\\d+") ||
                            telNumber.matches("^\\+\\d+\\(\\d\\d\\d\\)\\d+-?\\d+-?\\d+");
                }
            }
            if (telNumber.substring(0,1).matches("\\d") || telNumber.startsWith("(")) {
                if (telNumber.replaceAll("\\D+", "").length() == 10) {
                    //System.out.print("10 digits ");
                    return telNumber.matches("\\d+$") ||
                            telNumber.matches("\\d+-\\d+") ||
                            telNumber.matches("\\d+-\\d+-\\d+") ||
                            telNumber.matches("^\\(\\d\\d\\d\\)\\d+-?\\d+") ||
                            telNumber.matches("^\\(\\d\\d\\d\\)\\d+-?\\d+-?\\d+");
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkTelNumber("+380501234567"));
        System.out.println(checkTelNumber("1501234567"));
        System.out.println(checkTelNumber("150123-4567"));
        System.out.println(checkTelNumber("150-123-4567"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38050123-45-67"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("(150)1234567"));
        System.out.println(checkTelNumber("(150)123-45-67"));
        System.out.println(checkTelNumber("150123-45-67"));
        System.out.println(checkTelNumber("15012345-67"));
        System.out.println(checkTelNumber("+38(050)1234567"));
        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("+38(050)12345-6-7"));
    }
}