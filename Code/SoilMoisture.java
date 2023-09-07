package Code;

public class SoilMoisture implements Runnable {
    private double moisture;
    private double minMoisture;
    private double maxMoisture;
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
    public SoilMoisture(Simulation view) {
        this.view = view;
    }
    /**
     * methods set the soil moisture and also sets the soil moisture confortable range of +-3
     * @param temperature
     */
    public synchronized void setMoisture(double temperature) {
        this.moisture = temperature;
        this.minMoisture = temperature -3;
        this.maxMoisture = temperature +3;
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
            if (moisture <= minMoisture) {
                    moisture += incrementValue;
                    Machine = "Sprinkler System -> ON";
            } else if (moisture >= maxMoisture) {
                    moisture -= decrementValue;
                    Machine = "Sprinkler System -> OFF";
            } else { 
                moisture += external;
                Machine = "Sprinkler System -> OFF";
            }
            view.appendSoilMoisture(moisture, Machine);
            try {
                Thread.sleep(sampleRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }
}
