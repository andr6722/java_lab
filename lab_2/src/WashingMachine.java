public class WashingMachine {
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
}
