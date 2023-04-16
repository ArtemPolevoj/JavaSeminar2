//Дана строка (получение через обычный текстовый файл!!!)
//
//"фамилия":"Иванов","оценка":"5","предмет":"Математика"
//"фамилия":"Петрова","оценка":"4","предмет":"Информатика"
//Написать метод(ы), который распарсит строку и, используя StringBuilder,
//создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода в консоль:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика

import java.io.BufferedReader;
import java.io.FileReader;


public class Task2 {
    static void start(){
        String fileName = "Task2Input.txt";
        String line;
        String[] array;
        StringBuilder fileReader = new StringBuilder();
        try(BufferedReader read = new BufferedReader(new FileReader(fileName))){
            while ((line = read.readLine()) != null) {
                array = line.replace("\"", "").split("[:,]");
                fileReader.append("Студент ");
                fileReader.append(array[1]);
                fileReader.append(" получил ");
                fileReader.append(array[3]);
                fileReader.append(" по предмету ");
                fileReader.append(array[5].toLowerCase());
                fileReader.append(".\n");
            }
        }catch (Exception e){
            System.out.println("Не удалось прочитать файл.");
        }
        System.out.println(fileReader);
    }
}
