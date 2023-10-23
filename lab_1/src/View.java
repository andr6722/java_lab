import java.util.Scanner;
public class View {
    private Controller controller;
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество чисел: ");
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        System.out.println("Введите числа: ");

        for (int i = 0; i < count; i++){
            try{
                numbers[i] = scanner.nextInt();

            }catch(Exception e){
                System.out.println("Ошибка ввода! Попробуйте еще раз.");
                scanner.nextLine();
                i--;
            }
        }
        controller.processNumbers(numbers);
        scanner.close();
    }
    public void showResult(boolean isArithmetic, boolean isGeometric) {
        if (isArithmetic && isGeometric) {
            System.out.println("Набор чисел является и арифметической, и геометрической прогрессией.");
        } else if (isArithmetic) {
            System.out.println("Набор чисел является арифметической прогрессией.");
        } else if (isGeometric) {
            System.out.println("Набор чисел является геометрической прогрессией.");
        } else {
            System.out.println("Набор чисел не является ни арифметической, ни геометрической прогрессией.");
        }
    }

}
