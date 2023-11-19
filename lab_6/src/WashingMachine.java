import java.util.Scanner;

public class WashingMachine implements Chackable{
    private String detergentType;
    private String conditionerType;
    private ColoredLaundry loadedLaundry;

    public void Load(ColoredLaundry laundry, String detergentType, String conditionerType) {
        this.loadedLaundry = laundry;
        this.detergentType = detergentType;
        this.conditionerType = conditionerType;
    }


    @Override
    public String toString() {
        if (loadedLaundry != null) {
            return "Стиральная машина загружена с бельем: " + loadedLaundry.toString() +
                    ", Тип порошка: " + detergentType +
                    ", Тип кондиционера: " + conditionerType;
        } else {
            return "Стиральная машина не загружена.";
        }
    }

    @Override
    public boolean chackData() {
        // проверка что данные не пустые
        return !detergentType.isEmpty() && !conditionerType.isEmpty();
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите тип порошка: ");
        detergentType = scanner.nextLine();

        System.out.print("Введите тип кондиционера: ");
        conditionerType = scanner.nextLine();
    }
}
