import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/*
3*дополнительно. К калькулятору из предыдущего дз добавить логирование.
1 + 3 = 4
4 + 3 = 7
 */
public class Task3 {
    static void start() {
        String logName = "CalculatorLog";
        String result;
        try {
            Logger arraylog = Logger.getLogger(logName);
            FileHandler fh = new FileHandler("CalculatorLog.txt");
            fh.setFormatter(new SimpleFormatter());
            arraylog.addHandler(fh);
            arraylog.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: \n");
        int first = scanner.nextInt();
        System.out.print("Введите операцию: \n");
        String str = scanner.next();
        System.out.print("Введите второе число: \n");
        int second = scanner.nextInt();
        String strFirst = String.valueOf(first);
        String strSecond = String.valueOf(second);
        switch (str) {
            case "-" -> result = String.format("%s - %s = %d.",
                    strFirst, strFirst, first - second);
            case "+" -> result = String.format("%s + %s = %d.",
                    strFirst, strSecond, first + second);
            case "*" -> result = String.format("%s * %s = %d.",
                    strFirst, strSecond, first * second);
            case "/" -> {
                if (second == 0) {
                    result = "На ноль дельть нельзя.";
                } else {
                    result = String.format("%s / %s = %.2f.",
                            strFirst, strSecond, (float)first / second);
                }
            }
            default -> result = "Нет такой операции.";
        }
        Logger.getLogger(logName).log(Level.INFO, result);
        System.out.println(result);
    }
}