package ru.student.lab5.util;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InputHelper {
    private InputHelper() {
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число.");
            }
        }
    }

    public static String readNonEmptyString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Ошибка: строка не должна быть пустой.");
        }
    }

    public static List<Integer> readIntegerList(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Ошибка: список не должен быть пустым.");
                continue;
            }
            String[] parts = line.split("\\s+");
            List<Integer> result = new ArrayList<>();
            boolean ok = true;
            for (String part : parts) {
                try {
                    result.add(Integer.parseInt(part));
                } catch (NumberFormatException e) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return result;
            }
            System.out.println("Ошибка: введите список целых чисел через пробел.");
        }
    }

    public static Queue<Integer> readQueue(Scanner scanner, String prompt) {
        return new ArrayDeque<>(readIntegerList(scanner, prompt));
    }
}
