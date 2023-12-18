import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Scanner;

public class WebPageReader {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите адрес веб-страницы: ");
        String url = scanner.nextLine();

        try {
            // Получаем исходный текст веб-страницы
            Document document = Jsoup.connect(url).get();
            String html = document.html();

            // Выводим исходный текст
            System.out.println("Исходный текст веб-страницы:");
            System.out.println(html);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Ошибка при чтении веб-страницы: " + e.getMessage());
        }
    }
}