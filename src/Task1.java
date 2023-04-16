import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
//результат после каждой итерации запишите в лог-файл.
public class Task1 {
    static void start(){
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        String logName = "arrayLog";
        try {
            Logger arraylog = Logger.getLogger(logName);
            FileHandler fh = new FileHandler("ArrayLog.txt");
            fh.setFormatter(new SimpleFormatter());
            arraylog.addHandler(fh);
            arraylog.setUseParentHandlers(false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1, temp; j < array.length; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    Logger.getLogger(logName).log(Level.INFO, Arrays.toString(array));
                }
            }
        }
    }
}
