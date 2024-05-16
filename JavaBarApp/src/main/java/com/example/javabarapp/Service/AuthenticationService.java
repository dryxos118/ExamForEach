package com.example.javabarapp.Service;

import com.example.javabarapp.Model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AuthenticationService {
    private final Map<String, User> authenticatedUsers;

    public AuthenticationService() {
        this.authenticatedUsers = new HashMap<>();
    }

    public void loginUser(String username, User userDetails) {
        authenticatedUsers.put(username, userDetails);
    }

    public void logoutUser(String username) {
        authenticatedUsers.remove(username);
    }

    public static String EncodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return Objects.equals(EncodePassword(plainTextPassword), hashedPassword);
    }
}
