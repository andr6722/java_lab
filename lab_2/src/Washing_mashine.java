public class Washing_mashine {
    private String powder_type;
    private String conditioner_type;
    private LaundryColor color_of_laundry;
    private Washingtemperature washing_temperature;

    // метод load, который заполняет машину одним типом белья(одинаковые параметры стирки)

    public void Load(Linen linen){
        powder_type = "Universal";
        conditioner_type = "Soft";
        color_of_laundry = null;
        washing_temperature = linen.getWashing_temperature();
        if (linen instanceof Color_linen){
            Color_linen color_laundry = (Color_linen) linen;
            color_of_laundry = color_laundry.getColor_linen_1();
        }


    }
    public String toString(){
        return powder_type + "\t" + conditioner_type + "\t" + color_of_laundry + "\t" + washing_temperature;
    }
}
