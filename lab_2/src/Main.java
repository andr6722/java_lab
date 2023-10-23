import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {
    private static String LOGIN;
    private static boolean LOG_ENTRY_SING;

    public void Example() throws IOException{
        Properties props = new Properties();
        props.load(new FileInputStream(new File("config/example.ini")));
        LOGIN = props.getProperty("LOGIN");
        LOG_ENTRY_SING = Boolean.valueOf(props.getProperty("LOG_ENTRY_SING"));
    }
    public static void main(String[] args) {
        Linen linen1 = new Linen(Washingtemperature.Warm, Ironingtemperature.High);
        Linen linen2 = new Linen(Washingtemperature.Cold, Ironingtemperature.Low);
        Linen linen3 = new Linen(Washingtemperature.Hot, Ironingtemperature.Medium);

        Color_linen color_linen1 = new Color_linen(Washingtemperature.Warm, Ironingtemperature.High, LaundryColor.Color);
        Color_linen color_linen2 = new Color_linen(Washingtemperature.Cold, Ironingtemperature.Medium, LaundryColor.Dark);
        Color_linen color_linen3 = new Color_linen(Washingtemperature.Hot, Ironingtemperature.Low, LaundryColor.Light);

        Washing_mashine washing_mashine = new Washing_mashine();
        washing_mashine.Load(color_linen1);
        System.out.println(washing_mashine);
        washing_mashine.Load(color_linen2);
        System.out.println(washing_mashine);
        washing_mashine.Load(linen1);
        System.out.println(washing_mashine);

    }
}