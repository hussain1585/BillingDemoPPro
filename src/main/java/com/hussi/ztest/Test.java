package com.hussi.ztest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    private static final Pattern BILLING_ID_PATTERN = Pattern.compile("\\d{4}-(5[0-2]|[1-4]?\\d)");

    public static void main(String[] args) {
        String billingId = "2022-05";
        System.out.println(BILLING_ID_PATTERN.matcher(billingId).matches());
        billingId = "2019-7";
        System.out.println(BILLING_ID_PATTERN.matcher(billingId).matches());
        billingId = "2019-52";
        System.out.println(BILLING_ID_PATTERN.matcher(billingId).matches());
        billingId = "2019-53";
        System.out.println(BILLING_ID_PATTERN.matcher(billingId).matches());
        billingId = "2019-54";
        System.out.println(BILLING_ID_PATTERN.matcher(billingId).matches());
    }
}
