public class Color_linen extends Linen{
    private LaundryColor landry_color;

    public LaundryColor getColor_linen_1(){
        return landry_color;
    }

    public Color_linen(Washingtemperature washing_temperature, Ironingtemperature ironing_temperature, LaundryColor landry_color ){
        super(washing_temperature, ironing_temperature);
        this.landry_color = landry_color;
    }

    public String toString(){
        return super.toString() + "\t" + landry_color;
    }

}
