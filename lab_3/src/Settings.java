import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Settings {
    private String username; // имя пользователя
    private boolean logEnabled; // Признак записи лога

    public Settings(){
        username = "User";
        logEnabled = true;
    }

    // метод для загрузки настроек из файла
    public void Load(){
        try{
            FileReader reader = new FileReader("settings.ini");
            Scanner scanner = new Scanner(reader);

            username = scanner.nextLine();
            logEnabled = Boolean.parseBoolean(scanner.nextLine());

            reader.close();
        }
        catch(IOException e){
            System.out.println("Ошибка при чтении из файла настроек");
        }
    }

    // метод для сохранения настроек в файл
    public void Save(){
        try{
            FileWriter writer = new FileWriter("settings.ini");

            writer.write(username + "\n");
            writer.write(logEnabled + "\n");

            writer.close();
        }
        catch(IOException e){
            System.out.println("Ошибка при записи настроек в файл");
        }
    }

    // методы для получения и установки значений настроек
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getLogEnabled() {
        return logEnabled;
    }

    public void setLogEnabled(boolean logEnabled) {
        this.logEnabled = logEnabled;
    }
}
