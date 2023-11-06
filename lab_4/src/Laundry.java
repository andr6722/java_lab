public class Laundry {
    private int washingTemperature;
    private int ironingTemperature;

    public Laundry(int washingTemperature, int ironingTemperature) {
        this.washingTemperature = washingTemperature;
        this.ironingTemperature = ironingTemperature;
    }

    public int getWashingTemperature() {
        return washingTemperature;
    }

    public int getIroningTemperature() {
        return ironingTemperature;
    }

    @Override
    public String toString() {
        return "Температура стирки: " + washingTemperature + "°C, Температура глажения: " + ironingTemperature + "°C";
    }

}
