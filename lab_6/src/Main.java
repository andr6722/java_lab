
public class Main {

    public static void main(String[] args) {
        ColoredLaundry coloredLaundry = new ColoredLaundry(40, 120, ColorType.COLOR);
        WashingMachine washingMachine = new WashingMachine();

        washingMachine.Load(coloredLaundry, "Universal", "Средство для цветного белья");

        System.out.println(washingMachine.toString());

    }
}