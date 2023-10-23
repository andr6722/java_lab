public class Model {
    private int[] numbers;

    public void setnumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public boolean Arithmetic_progression(){
        int diff = numbers[1] - numbers[0];
        for (int i =2; i<numbers.length; i++) {
            if (numbers[i] - numbers[i-1] != diff){
                return false;
            }
        }
        return true;
    }

    public boolean Geometric_Progression(){
        int ratio = numbers[1]/numbers[0];
        for (int i = 2; i< numbers.length; i++){
            if (numbers[i]/numbers[i-1] != ratio){
                return false;
            }
        }
        return true;
    }
}
