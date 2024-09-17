package org.example;
import java.util.Scanner;

public class TextModifier {
    String text;
    public String modify() {
        System.out.println("Hey there!");
        System.out.println("This is a test task for java course in kata academy...");
        System.out.println("And it's written by iUsup Magomedov...");
        System.out.println("Please, enter your string and tap \"Enter\"!");

        Scanner scanner = new Scanner(System.in);

        text = scanner.nextLine();
        text = spaceDeleter(text);
        text = dashHandler(text);
        text = plusHandler(text);
        return numbersHandler(text);
    }
    String spaceDeleter(String str) {
        while(str.contains("  ")) {
            String textFirstPart = str.substring(0, str.indexOf("  "));
            String textLastPart = str.substring(str.indexOf("  ") + 1);

            str = textFirstPart + textLastPart;
        }
        return str;
    }

    String dashHandler(String str) {
        while(str.contains("-")) {
            if (str.indexOf('-') != 0) {
                String textFirstPart = str.substring(0, str.indexOf('-') - 1);
                String textSecondPart = str.substring(str.indexOf('-') + 1, str.indexOf('-') + 2) +
                        str.substring(str.indexOf('-') - 1, str.indexOf('-'));//    .charAt(str.indexOf('-') - 1);
                String textThirdPart = str.substring(str.indexOf('-') + 2);
                str = textFirstPart + textSecondPart + textThirdPart;
            } else {
                String textFirstPart = str.substring(1);
                String textSecondPart = "";
                String textThirdPart = "";
                str = textFirstPart + textSecondPart + textThirdPart;
            }
        }
        return str;
    }

    String plusHandler(String str) {
        while (str.contains("+")){
            str = str.substring(0, str.indexOf('+')) + '!' + str.substring(str.indexOf('+') + 1);
        }
        return str;
    }
    public TextModifier() {
        text = "";
    }

    String numbersHandler(String str) {
        int sum = 0;
        StringBuilder result = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                sum = sum + ch - 48;
            } else {
                result.append(ch);
            }
        }
        if (sum == 0) {
            return str;
        }
        str = result.toString();
        return str + ' ' + sum;
    }
}
