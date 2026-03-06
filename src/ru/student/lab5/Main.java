package ru.student.lab5;

import ru.student.lab5.fraction.CachedFraction;
import ru.student.lab5.listtask.ListTask1;
import ru.student.lab5.maptask.LoginGeneratorTask;
import ru.student.lab5.meow.Cat;
import ru.student.lab5.meow.MeowCounter;
import ru.student.lab5.meow.MeowService;
import ru.student.lab5.queuetask.QueueTask5;
import ru.student.lab5.settask.RussianLettersTask;
import ru.student.lab5.streamtask.Point;
import ru.student.lab5.streamtask.Polyline;
import ru.student.lab5.streamtask.StreamTasks;
import ru.student.lab5.util.InputHelper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Лабораторная работа №5, вариант 4");
        System.out.println("Введите номер задания:");
        int zadanie = InputHelper.readInt(scanner, "> ");
        System.out.println("Введите номер задачи:");
        int zadacha = InputHelper.readInt(scanner, "> ");

        boolean valid = true;

        if (zadanie == 1) {
            if (zadacha == 1) {
                int numerator = InputHelper.readInt(scanner, "Введите числитель: ");
                int denominator = InputHelper.readInt(scanner, "Введите знаменатель: ");
                try {
                    CachedFraction fraction = new CachedFraction(numerator, denominator);
                    System.out.println("Создана дробь: " + fraction);
                    System.out.println("Первое вычисление вещественного значения: " + fraction.toDouble());
                    System.out.println("Второе вычисление (из кэша): " + fraction.toDouble());
                    int newNumerator = InputHelper.readInt(scanner, "Введите новый числитель: ");
                    fraction.setNumerator(newNumerator);
                    System.out.println("После изменения дробь: " + fraction);
                    System.out.println("Новое вещественное значение: " + fraction.toDouble());
                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                valid = false;
            }
        } else if (zadanie == 2) {
            if (zadacha == 1) {
                String catName = InputHelper.readNonEmptyString(scanner, "Введите имя кота: ");
                Cat cat = new Cat(catName);
                MeowCounter counter = new MeowCounter(cat);
                MeowService service = new MeowService();
                System.out.println("Создан объект: " + cat);
                System.out.println("Запускаем мяуканье 3 раза...");
                service.meowAll(counter, counter, counter);
                System.out.println("Кот мяукал " + counter.getCount() + " раз.");
            } else {
                valid = false;
            }
        } else if (zadanie == 3) {
            if (zadacha == 1) {
                List<Integer> list = InputHelper.readIntegerList(scanner, "Введите элементы списка через пробел: ");
                int element = InputHelper.readInt(scanner, "Введите элемент E для удаления: ");
                ListTask1 task = new ListTask1(list, element);
                System.out.println("Исходные данные: " + task);
                System.out.println("Результат: " + task.solve());
            } else {
                valid = false;
            }
        } else if (zadanie == 4) {
            if (zadacha == 1) {
                System.out.print("Введите путь к файлу с учениками или 0 для sample: ");
                String pathString = scanner.nextLine().trim();
                if (pathString.equals("0")) {
                    pathString = "data/students_task4_1.txt";
                }
                try {
                    LoginGeneratorTask task = new LoginGeneratorTask(Path.of(pathString));
                    System.out.println("Логины:");
                    task.generateLogins().forEach(System.out::println);
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                valid = false;
            }
        } else if (zadanie == 5) {
            if (zadacha == 1) {
                System.out.print("Введите путь к текстовому файлу или 0 для sample: ");
                String pathString = scanner.nextLine().trim();
                if (pathString.equals("0")) {
                    pathString = "data/text_task5_1.txt";
                }
                try {
                    RussianLettersTask task = new RussianLettersTask(Path.of(pathString));
                    System.out.println("Звонкие согласные в алфавитном порядке: " + task.findVoicedConsonants());
                } catch (Exception e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                valid = false;
            }
        } else if (zadanie == 6) {
            if (zadacha == 5) {
                Queue<Integer> queue = InputHelper.readQueue(scanner, "Введите элементы очереди через пробел: ");
                QueueTask5 task = new QueueTask5(queue);
                System.out.println("Исходная очередь: " + task.getSourceQueue());
                System.out.println("Очередь L2 в обратном порядке: " + task.reverseCopy());
            } else {
                valid = false;
            }
        } else if (zadanie == 7) {
            if (zadacha == 1) {
                int n = InputHelper.readInt(scanner, "Введите количество точек: ");
                if (n <= 0) {
                    System.out.println("Ошибка: количество точек должно быть положительным.");
                    return;
                }
                new StreamTasks();
                java.util.ArrayList<Point> points = new java.util.ArrayList<>();
                for (int i = 1; i <= n; i++) {
                    int x = InputHelper.readInt(scanner, "Точка " + i + ", X: ");
                    int y = InputHelper.readInt(scanner, "Точка " + i + ", Y: ");
                    points.add(new Point(x, y));
                }
                StreamTasks tasks = new StreamTasks();
                Polyline polyline = tasks.buildPolyline(points);
                System.out.println("Результат стрима: " + polyline);
            } else if (zadacha == 2) {
                System.out.print("Введите путь к файлу с людьми или 0 для sample: ");
                String pathString = scanner.nextLine().trim();
                if (pathString.equals("0")) {
                    pathString = "data/people_task7_2.txt";
                }
                StreamTasks tasks = new StreamTasks();
                try {
                    Map<Integer, List<String>> result = tasks.groupNamesByNumber(Path.of(pathString));
                    System.out.println(result);
                } catch (IOException | IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            } else {
                valid = false;
            }
        } else {
            valid = false;
        }

        if (!valid) {
            System.out.println("Некорректный номер задания или задачи для варианта 4.");
            System.out.println("Доступно: 1.1, 2.1, 3.1, 4.1, 5.1, 6.5, 7.1, 7.2");
        }
    }
}
