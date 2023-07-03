package homework_4;

import java.util.Scanner;

public class Calculator {
    private static double result;
    private static double previousResult;
    private static boolean isPreviousOperationCancelled;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Калькулятор готов к использованию.\nДля отмены операции введите слово 'отмена' ");
        System.out.println("Для выхода введите 'exit'.");

        while (true) {
            System.out.print("Введите первое число: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            double number1;
            try {
                number1 = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число. Попробуйте еще раз.");
                continue;
            }

            System.out.print("Введите знак операции (+, -, *, /) или 'отмена': ");
            String operator = scanner.nextLine();

            if (operator.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Введите второе число: ");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            double number2;
            try {
                number2 = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число. Попробуйте еще раз.");
                continue;
            }

            if (operator.equalsIgnoreCase("отмена")) {
                cancelPreviousOperation();
            } else if (!isPreviousOperationCancelled) {
                calculate(number1, operator, number2);
            } else {
                System.out.println("Предыдущая операция была отменена. Введите новую операцию.");
                isPreviousOperationCancelled = false;
            }
        }

        System.out.println("Калькулятор завершил работу.");
    }

    private static void calculate(double number1, String operator, double number2) {
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                System.out.println("Неправильный знак операции. Введите операцию заново.");
                return;
        }

        System.out.println("Результат: " + result);

        previousResult = result;
    }

    public static void cancelPreviousOperation() {
        if (!isPreviousOperationCancelled) {
            result = previousResult;
            previousResult = 0.0;
            isPreviousOperationCancelled = true;
            System.out.println("Предыдущая операция отменена. Результат: " + result);
        } else {
            System.out.println("Нет предыдущей операции для отмены.");
        }
    }
}