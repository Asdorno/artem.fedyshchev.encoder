package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws IOException {
        List<String> testList = new ArrayList<>();
        testList.add("Hello World!");
        testList.add("Goodbye World!");
        FileService fileService = new FileService();

        System.out.println(fileService.read("/home/user/Рабочий стол/NewText.txt"));
        fileService.write("/home/user/Рабочий стол/NewText[Encrypted].txt", testList);

        if (args.length == 0) {
            System.out.println("Working from console");
        } else if (args.length == 2) {
            System.out.println("Bruting Forcing");
        } else if (args.length == 3) {
            System.out.println("Encrypting & Decrypting");
        }
    }
}
