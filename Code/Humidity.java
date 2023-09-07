package Code;

public class Humidity implements Runnable {
    private double humidity;
    private double minHumidity;
    private double maxHumidity;
    private double external;
    private double incrementValue;
    private double decrementValue;
    private int sampleRate;
    private boolean running;
    private Simulation view;
    private String Machine;
    /**
     * This method sets the view
     * @param view
     */
    public Humidity(Simulation view) {
        this.view = view;
    }
    /**
     * methods set the humidity and also sets the humidity confort range of +-3
     * @param temperature
     */
    public synchronized void sethumidity(double temperature) {
        this.humidity = temperature;
        this.minHumidity = temperature -3;
        this.maxHumidity = temperature +3;
    }
    /**
     * set the external temperature
     * @param externalTemperature
     */
    public synchronized void setExternal(double externalTemperature) {
        this.external = externalTemperature;
    }
    /**
     * set the increasing values
     * @param incrementValue
     */
    public synchronized void setIncrementValue(double incrementValue) {
        this.incrementValue = incrementValue;
    }
    /**
     * set the decreasing values
     * @param decrementValue
     */
    public synchronized void setDecrementValue(double decrementValue) {
        this.decrementValue = decrementValue;
    }

    /**
     * set the sample rate
     * @param sampleRate
     */
    public synchronized void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }
    /**
     * start method that set the boolean value and makes a thread
     */
    public synchronized void start() {
        running = true;
        new Thread(this).start();
    }
    /**
     * stop the thread by setting boolean to false
     */
    public synchronized void stop() {
        running = false;
    }
    /**
     * run method that calculates if the temperature is in confort range
     */
    @Override
    public void run() {
        while (running) {
            if (humidity <= minHumidity) {
                    humidity += incrementValue;
                    Machine = "Humidifier -> ON";
            } else if (humidity >= maxHumidity) {
                    humidity -= decrementValue;
                    Machine = "Humidifier -> OFF";
            } else { 
                humidity += external;
                Machine = "Humidifier -> OFF";
            }
            view.appendHumidity(humidity, Machine);
            try {
                Thread.sleep(sampleRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }
}
