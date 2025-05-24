package org.example;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";

    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generatePassword(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Довжина пароля має бути більше 0");
        }

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomCharIndex = RANDOM.nextInt(PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(randomCharIndex));
        }
        return password.toString();
    }

    public static void generateMultiplePasswords(int count, int length) {
        for (int i = 0; i < count; i++) {
            String generatedPassword = generatePassword(length);
            System.out.println("Згенерований пароль " + (i + 1) + ": " + generatedPassword);
        }
    }

    public static void main(String[] args) {
        int passwordCount = 3; // Кількість паролів для генерації
        int passwordLength = 12; // Довжина паролів

        generateMultiplePasswords(passwordCount, passwordLength);
    }
}
