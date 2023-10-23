public class Controller {
    private Model model;
    private View view;

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void processNumbers(int[] numbers) {
        model.setnumbers(numbers);

        boolean isArithmetic = model.Arithmetic_progression();
        boolean isGeometric = model.Geometric_Progression();

        view.showResult(isArithmetic, isGeometric);
    }
}
