
public class ColoredLaundry extends Laundry{
    private ColorType color;

    public ColoredLaundry(int washingTemperature, int ironingTemperature, ColorType color) {
        super(washingTemperature, ironingTemperature);
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + ", Цвет белья: " + color;
    }
}
