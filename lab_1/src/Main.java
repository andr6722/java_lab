
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller();

        controller.setModel(model);
        controller.setView(view);

        view.setController(controller);

        view.start();
    }
}