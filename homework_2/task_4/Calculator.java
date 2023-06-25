package homework_2.task_4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Calculator {
    private FileWriter fileWriter;

    public Calculator() {
        try {
            fileWriter = new FileWriter("calculator.txt", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int add(int a, int b) {
        int result = a + b;
        writeLog("Сложение: " + a + " + " + b + " = " + result);
        return result;
    }

    public int subtract(int a, int b) {
        int result = a - b;
        writeLog("Вычитание: " + a + " - " + b + " = " + result);
        return result;
    }

    public int multiply(int a, int b) {
        int result = a * b;
        writeLog("Умножение: " + a + " * " + b + " = " + result);
        return result;
    }

    public double divide(int a, int b) {
        if (b != 0) {
            double result = (double) a / b;
            writeLog("Деление: " + a + " / " + b + " = " + result);
            return result;
        } else {
            writeLog("Деление на ноль!");
            return Double.NaN;
        }
    }

    private void writeLog(String logMessage) {
        try {
            fileWriter.write(logMessage);
            fileWriter.write(System.lineSeparator());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введите знак операции (+, -, *, /): ");
        String operator = scanner.next();


        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        

        int result = 0;
        switch (operator) {
            case "+":
                result = calculator.add(num1, num2);
                break;
            case "-":
                result = calculator.subtract(num1, num2);
                break;
            case "*":
                result = calculator.multiply(num1, num2);
                break;
            case "/":
                double divisionResult = calculator.divide(num1, num2);
                System.out.println("Результат деления: " + divisionResult);
                break;
            default:
                System.out.println("Неподдерживаемый знак операции.");
                break;
        }

        System.out.println("Результат: " + result);

        calculator.closeLogger();
        scanner.close();
    }

    public void closeLogger() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Calculator {
    
}
