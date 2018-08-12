package com.demoqa.utility;

import java.util.UUID;

public class EmailGenerator {


    public static String generateUniqueEmail() {

        String alias = UUID.randomUUID().toString();
        String uniqueEmail = "bayshoretst" + "+" + alias + "@gmail.com";
        return uniqueEmail;
    }
}

