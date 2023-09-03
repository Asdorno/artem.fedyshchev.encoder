package org.example;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {

    public List<String> encrypt(List<String> text, int key) {
        List<String> encryptedText = new ArrayList<>();
        for (String line :
                text) {
            encryptedText.add(cryptStr(line, key));
        }

        return encryptedText;
    }

    public List<String> decrypt(List<String> text, int key) {
        List<String> encryptedText = new ArrayList<>();
        List<Character> alphabet = new ArrayList<>();
        for (char letter :
                LanguageDetector.language(text.get(0))) {
            alphabet.add(letter);
        }

        int actualKey = alphabet.size() - (key % alphabet.size());

        for (String line :
                text) {
            encryptedText.add(cryptStr(line, actualKey));
        }

        return encryptedText;
    }

    public void bruteForce(List<String> text) {
        LanguageDetector.language(text);
        throw new UnsupportedOperationException();
    }

    public String cryptStr(String line, int key) {
        List<Character> alphabet = new ArrayList<>();
        StringBuilder cryptoLn = new StringBuilder();
        for (char letter :
                LanguageDetector.language(line)) {
            alphabet.add(letter);
        }

        for (char character :
                line.toCharArray()) {
            if (alphabet.contains(character)) {
                int startPosition = alphabet.indexOf(character);
                int endPosition = (startPosition + key) % alphabet.size();
                char newCharacter = alphabet.get(endPosition);
                cryptoLn.append(newCharacter);
            } else {
                cryptoLn.append(character);
            }
        }

        return cryptoLn.toString();
    }
}
