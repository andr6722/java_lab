import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FtpFileDownloader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес FTP-сервера: ");
        String serverAddress = scanner.nextLine();
        System.out.print("Введите путь к файлу на FTP-сервере: ");
        String filePath = scanner.nextLine();
        System.out.print("Введите логин: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        FTPClient ftpClient = new FTPClient();

        try {
            // Подключаемся к FTP-серверу
            ftpClient.connect(serverAddress);
            ftpClient.login(username, password);

            // Задаем тип передачи данных
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            // Создаем поток для сохранения файла
            try (FileOutputStream fos = new FileOutputStream("downloaded_file.txt")) {
                // Скачиваем файл
                ftpClient.retrieveFile(filePath, fos);
                System.out.println("Файл успешно скачан.");

            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Ошибка при скачивании файла: " + e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при подключении к FTP-серверу: " + e.getMessage());
        } finally {
            try {
                // Закрываем соединение с FTP-сервером
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}