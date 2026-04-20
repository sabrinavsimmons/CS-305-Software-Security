package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class SslServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SslServerApplication.class, args);
    }

}

/**
 * REST controller that exposes a single endpoint for checksum verification.
 * Implements SHA-256 hashing to provide data integrity verification for
 * Artemis Financial's secure communication requirements.
 */
@RestController
class HashController {

    /**
     * Handles GET requests to /hash.
     * Computes a SHA-256 cryptographic hash of a static data string
     * containing the developer name as a unique identifier.
     *
     * SHA-256 was selected per NIST FIPS 180-4 as a currently approved
     * hash algorithm for data integrity verification applications.
     *
     * @return HTML response displaying the original data string and its
     *         corresponding SHA-256 hexadecimal digest
     * @throws NoSuchAlgorithmException if SHA-256 is unavailable in the JVM
     */
    @GetMapping("/hash")
    public String getHash() throws NoSuchAlgorithmException {

        // Static data string with developer name as unique identifier
        String data = "Sabrina Simmons";

        // Obtain a MessageDigest instance configured for SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Compute the hash as a byte array using UTF-8 encoded input
        byte[] hashBytes = digest.digest(data.getBytes(StandardCharsets.UTF_8));

        // Convert each byte to a two-character hexadecimal string
        // Padding with leading zero ensures consistent 64-character output
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        // Return the data string and its SHA-256 digest as an HTML response
        return "<p><b>Data:</b> " + data + "</p>"
             + "<p><b>SHA-256 Checksum:</b> " + hexString + "</p>";
    }

}