package com.ioprogramming.Day1_CSVHandling.advancedproblems.encryptdecrypt;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String CSV_PATH = "C:\\my doucments\\files\\encryt_data.csv";
    private static final String SECRET_KEY = "1234567890123456"; // 16-byte AES key

    public static void main(String[] args) {
        writeEncryptedCSV();
        readDecryptedCSV();
    }

    // Method to encrypt a string using AES
    private static String encrypt(String value) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(value.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Method to decrypt a string using AES
    private static String decrypt(String encryptedValue) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
        return new String(decrypted);
    }

    // Write encrypted CSV
    public static void writeEncryptedCSV() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_PATH))) {
            writer.write("ID,Name,Email,Salary\n");
            writer.write("101,Ram," + encrypt("ram@example.com") + "," + encrypt("50000") + "\n");
            writer.write("102,Shyam," + encrypt("shyam@example.com") + "," + encrypt("60000") + "\n");
            writer.write("103,Mohan," + encrypt("mohan@example.com") + "," + encrypt("70000") + "\n");
            writer.write("104,Subhash," + encrypt("subhash@example.com") + "," + encrypt("80000") + "\n");
            writer.write("105,Aman," + encrypt("aman@example.com") + "," + encrypt("90000") + "\n");

            System.out.println("Encrypted CSV file written successfully.");
        } catch (Exception e) {
            System.err.println("Error while writing encrypted CSV: " + e.getMessage());
        }
    }

    // Read and decrypt CSV
    public static void readDecryptedCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_PATH))) {
            String line = reader.readLine(); // Read header
            System.out.println(line); // Print header

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];
                String name = columns[1];
                String email = decrypt(columns[2]);
                String salary = decrypt(columns[3]);

                System.out.println(id + " " + name + " " + email + " " + salary);
            }
        } catch (Exception e) {
            System.err.println("Error while reading decrypted CSV: " + e.getMessage());
        }
    }
}