package com.ruoyi.common.core.utils.phone;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.OptionalInt;
import java.util.Random;

public class PhoneUtil {
    public static Long genPhone(long begin) {

        if (begin<=0){
            return null;
        }

        String s = String.valueOf(begin);
        if (s.length() == 11)
            return begin;
        if (s.length()>11)
            return  Long.parseLong(s.substring(0,11));


        String start = appendZero(s);
        String end = appendNine(s);
        Long len = Long.parseLong(end) - Long.parseLong(start);

        try {
            SecureRandom instance = new SecureRandom();
            long i = instance.nextInt(Integer.valueOf(String.valueOf(len))) + Long.parseLong(start);

            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static String appendZero(String s) {
        while (s.length() < 11) {
            s = s + "0";
        }
        return s;

    }

    public static String appendNine(String s) {
        while (s.length() < 11) {
            s = s + "9";
        }
        return s;

    }

    public static void main(String[] args) {
        Long aLong = genPhone(19999999999L);
        System.out.println(aLong);
    }
}
