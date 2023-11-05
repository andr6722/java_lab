import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class FileUtil {


    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void writeToDatabase(Scanner scanner) {

        System.out.print("Введите количество объектов для записи: ");
        int count = scanner.nextInt();
        scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", true))) {
            for (int i = 0; i < count; i++) {
                System.out.println("Объект " + (i + 1));
                System.out.print("Температура стирки: ");
                int washingTemperature = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Температура глажения: ");
                int ironingTemperature = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Цвет белья (LIGHT/DARK/COLORFUL): ");
                String colorStr = scanner.nextLine();
                ColorType color = ColorType.valueOf(colorStr);

                ColoredLaundry laundry = new ColoredLaundry(washingTemperature, ironingTemperature, color);

                writer.write(laundry.toString());
                writer.newLine();
            }
            logger.info("Writing data to a 'database' file");
            System.out.println("Данные успешно записаны.");
        } catch (IOException e) {
            logger.warning("Error writing data to 'database' file");
            System.out.println("Ошибка при записи данных.");

        }
    }


    public static void readFromDatabase() {

        try (BufferedReader reader = new BufferedReader(new FileReader("database.txt"))) {
            String line;
            List<String> data = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            logger.info("Reading data to a 'database' file");
            System.out.println("Данные успешно прочитаны:");
            for (String item : data) {
                System.out.println(item);
            }
        } catch (IOException e) {
            logger.warning("Error reading data to 'database' file");
        }

    }

    public static void updateData(Scanner scanner) {

        try{
            List <String> data = new ArrayList<>();
            BufferedReader reader  = new BufferedReader(new FileReader("database.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();

            System.out.println("Введите индекс обьекта для изменения: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < data.size()){
                System.out.print("Температура стирки: ");
                int washingTemperature = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Температура глажения: ");
                int ironingTemperature = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Цвет белья (WHITE/BLACK/COLOR): ");
                String colorStr = scanner.nextLine();
                ColorType color = ColorType.valueOf(colorStr);

                ColoredLaundry laundry = new ColoredLaundry(washingTemperature, ironingTemperature, color);

                data.set(index, laundry.toString());

                BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", false));
                for (String item : data) {
                    writer.write(item);
                    writer.newLine();
                }
                writer.close();
                logger.info("Data changed");
                System.out.println("Данные успешно изменены.");
            }

        } catch (IOException e){
            logger.warning("Error when changing data");
            System.out.println("Ошибка при изменении данных.");
        }
    }

    public static void deleteData(Scanner scanner) {

        try {

            List<String> data = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("database.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
            reader.close();

            System.out.print("Введите индекс объекта для удаления: ");
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < data.size()) {
                data.remove(index);

                BufferedWriter writer = new BufferedWriter(new FileWriter("database.txt", false));
                for (String item : data) {
                    writer.write(item);
                    writer.newLine();
                }
                writer.close();
                logger.info("Delete data");

                System.out.println("Данные успешно удалены.");
            } else {

                System.out.println("Некорректный индекс объекта.");
            }
        } catch (IOException e) {
            logger.warning("Error delete data");
            System.out.println("Ошибка при удалении данных.");
        }
    }
}
