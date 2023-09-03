package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        CaesarCipher cipher = new CaesarCipher();
        FileService newFile = new FileService();
        List<String> textFromFile;

        if (args.length == 0) {
            System.out.println("CLI mode");
        }
        if (args[0].equals(Command.BRUTE_FORCE.toString())) {
            System.out.println("Brute-Force mode");
        }
        if (args[0].equals(Command.ENCRYPT.toString())) {
            List<String> encryptedText;
            String filePath = args[1];
            String newFilePath = filePath.replaceFirst(".txt", "[ENCRYPTED].txt");

            System.out.println("Encrypting");

            textFromFile = newFile.read(filePath);
            encryptedText = cipher.encrypt(textFromFile, Integer.parseInt(args[2]));
            newFile.write(newFilePath, encryptedText);
        }
        if (args[0].equals(Command.DECRYPT.toString())) {
            List<String> decryptedText;
            String filePath = args[1];
            String newFilePath = filePath.replaceFirst(".txt", "[DECRYPTED].txt");

            System.out.println("Decrypting");

            textFromFile = newFile.read(filePath);
            decryptedText = cipher.decrypt(textFromFile, Integer.parseInt(args[2]));
            newFile.write(newFilePath, decryptedText);
        }
    }
}
