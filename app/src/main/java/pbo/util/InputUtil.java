package pbo.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static int readInt(String prompt) {
        System.out.println(prompt);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static double readDouble(String prompt) {
        System.out.println(prompt);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;  
    }
}