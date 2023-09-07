package Code;


public class Client {
    /**
     * Run the Code This holds the main method
     * @param args
     */
    public static void main(String[] args) {

        Simulation view = new Simulation();
        Temperature model = new Temperature(view);
        SoilMoisture Moist = new SoilMoisture(view);
        Humidity Humi = new Humidity(view);
    
       new Controller(model, Moist, Humi, view);
    }
    
}
