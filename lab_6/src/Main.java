
public class Main {
    public static void main(String[] args) {
        TimerModel model = new TimerModel();
        TimerView view = new TimerView();
        TimerController controller = new TimerController(model, view);
    }
}