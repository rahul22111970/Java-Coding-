package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class VehicleNumberGenerator {
    private static final Map<String, String> stateCodes = new HashMap<>();
    static {
        stateCodes.put("Andhra Pradesh", "AP");
        stateCodes.put("Arunachal Pradesh", "AR");
        stateCodes.put("Assam", "AS");
        stateCodes.put("Bihar", "BR");
        stateCodes.put("Chhattisgarh", "CG");
        stateCodes.put("Goa", "GA");
        stateCodes.put("Gujarat", "GJ");
        stateCodes.put("Haryana", "HR");
        stateCodes.put("Himachal Pradesh", "HP");
        stateCodes.put("Jammu and Kashmir", "JK");
        stateCodes.put("Jharkhand", "JH");
        stateCodes.put("Karnataka", "KA");
        stateCodes.put("Kerala", "KL");
        stateCodes.put("Madhya Pradesh", "MP");
        stateCodes.put("Maharashtra", "MH");
        stateCodes.put("Manipur", "MN");
        stateCodes.put("Meghalaya", "ML");
        stateCodes.put("Mizoram", "MZ");
        stateCodes.put("Nagaland", "NL");
        stateCodes.put("Odisha", "OD");
        stateCodes.put("Punjab", "PB");
        stateCodes.put("Rajasthan", "RJ");
        stateCodes.put("Sikkim", "SK");
        stateCodes.put("Tamil Nadu", "TN");
        stateCodes.put("Telangana", "TS");
        stateCodes.put("Tripura", "TR");
        stateCodes.put("Uttarakhand", "UK");
        stateCodes.put("Uttar Pradesh", "UP");
        stateCodes.put("West Bengal", "WB");
    }

    private static String generateRandomCode() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        Random random = ThreadLocalRandom.current();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
          .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
          .limit(targetStringLength)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

        return generatedString.toUpperCase();
    }

    public static String generateVehicleNumber(String state) {
        String stateCode = stateCodes.get(state);
        if (stateCode == null) {
            throw new IllegalArgumentException("Invalid state: " + state);
        }
        String randomCode = generateRandomCode();
        return stateCode + "-" + randomCode;
    }
}
