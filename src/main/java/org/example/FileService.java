package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService extends FileNotFoundRuntimeException {

    public List<String> read(String filePath) throws IOException {
        List<String> textFromFile = new ArrayList<>();
        Path path = Paths.get(filePath);
        Scanner scanner = new Scanner(path);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            textFromFile.add(line);
        }
        scanner.close();

        return textFromFile;
    }

    public void write(String fileName, List<String> lines) throws IOException {

        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            for (String line :
                    lines) {
                out.println(line);
            }
        }
    }


}
