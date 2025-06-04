package com.epics82.agrovita.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

    public static void main(String[] args) {
        String plainTextPassword = "abcd@123";  // Replace with your actual password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(plainTextPassword);

        System.out.println("Plain Text Password: " + plainTextPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        // **CRITICAL STEP:** Copy the ENCODED password from the console output
        // and use it to UPDATE the password field in your database.
    }
}