package Code;

public class Temperature implements Runnable {
    private double temperature;
    private double minTemperature;
    private double maxTemperature;
    private double externalTemperature;
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
    public Temperature(Simulation view) {
        this.view = view;
    }

    
    /** 
     * methods set the Temperature and also sets the temperature confortable range of +-3
     * @param temperature
     */
    public synchronized void setTemperature(double temperature) {
        this.temperature = temperature;
        this.minTemperature = temperature -3;
        this.maxTemperature = temperature +3;
    }

    
    /** 
     * set the external temperature
     * @param externalTemperature
     */
    public synchronized void setExternalTemperature(double externalTemperature) {
        this.externalTemperature = externalTemperature;
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
            if (temperature <= minTemperature) {
                    temperature += incrementValue;
                    Machine = "Furncae-> ON   Air Conditioner-> OFF";
            } else if (temperature >= maxTemperature) {
                    temperature -= decrementValue;
                    Machine = "Furncae-> OFF   Air Conditioner-> ON";
            } else {
                temperature += externalTemperature;
                Machine = "Furncae-> OFF   Air Conditioner-> OFF";
            }
            view.appendTemperature(temperature, Machine);

            try {
                Thread.sleep(sampleRate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
       }
    }
}
