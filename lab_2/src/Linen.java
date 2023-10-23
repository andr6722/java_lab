enum Washingtemperature{
    Cold, Warm, Hot
}

enum Ironingtemperature{
    Low, Medium, High
}

enum LaundryColor{
    Light,Dark,Color
}

public class Linen {
    private Washingtemperature washing_temperature;
    private Ironingtemperature ironing_temperature;

    //конструктор
    public Linen(Washingtemperature washing_temperature, Ironingtemperature ironing_temperature){
        this.washing_temperature = washing_temperature;
        this.ironing_temperature = ironing_temperature;
    }
    // get - методы
    public Washingtemperature getWashing_temperature(){
        return washing_temperature;
    }
    public Ironingtemperature getIroning_temperature(){
        return ironing_temperature;
    }
    // set - методы
    public void setWashing_temperature(Washingtemperature washing_temperature){
        this.washing_temperature = washing_temperature;
    }
    public void setIroning_temperature(Ironingtemperature ironing_temperature){
        this.ironing_temperature = ironing_temperature;
    }

    public String toString(){
        return washing_temperature + "\t" + ironing_temperature;
    }
}
