package util;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generate() {
        Random r = new Random();
        return "AC" + (100000 + r.nextInt(900000));
    }
}
