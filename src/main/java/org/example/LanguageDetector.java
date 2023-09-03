package org.example;

import java.util.List;

public class LanguageDetector {
    private LanguageDetector() {}

    private static final char[] UKRAINIAN_ALPHABET = new char[]{'А', 'Б', 'В', 'Г', 'Ґ', 'Д', 'Е', 'Є', 'Ж', 'З', 'И', 'І', 'Ї', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ю', 'Я', 'а', 'б', 'в', 'г', 'ґ', 'д', 'е', 'є', 'ж', 'з', 'и', 'і', 'ї', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ю', 'я'};
    private static final char[] ENGLISH_ALPHABET = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static char[] language(List<String> text) {
        return language(text.get(0));
    }

    public static char[] language(String line) {
        char[] alphabet = new char[]{};

        for (int i = 0; i <= line.length(); i++) {
            char checkedChar = line.charAt(i);

            if (checkedChar >= 1040 && checkedChar <= 1103) {
                alphabet = UKRAINIAN_ALPHABET;
                break;
            } else if (checkedChar >= 65 && checkedChar <= 122) {
                alphabet = ENGLISH_ALPHABET;
                break;
            }
        }
        return alphabet;
    }
}
