import java.io.*;
import java.util.Scanner;
import java.time.*;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Settings settings = new Settings();
        File file = new File("settings.ini");
        long endtime = System.currentTimeMillis();
        writeLog(endtime - startTime + "Старт программы");
        if(!file.exists()){
            System.out.println("Файл настроек не найден, создание нового");
            settings.Save();
        }else{
            System.out.println("Добро пожаловать - " + settings.getUsername());
            settings.Load();
        }

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1 - Чтение данных");
            System.out.println("2 - Запись данных");
            System.out.println("3 - Изменение данных конкретного обьекта");
            System.out.println("4 - Удаление конкретного обьекта");
            System.out.println("0 - Выход");
            System.out.println("Выберети операцию: ");

            choice = sc.nextInt();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    FileUtil.readFromDatabase();
                    break;
                case 2:
                    FileUtil.writeToDatabase(sc);
                    break;
                case 3:
                    FileUtil.updateData(sc);
                    break;
                case 4:
                    FileUtil.deleteData(sc);
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        }while (choice != 0);
        writeLog(endtime - startTime + "Конец программы");

    }

    public static void writeLog(String log) {
        Settings settings = new Settings();
        File file = new File("settings.ini");
        if (settings.getLogEnabled()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
                writer.write(log);
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Ошибка при записи лога.");
            }
        }
    }
}