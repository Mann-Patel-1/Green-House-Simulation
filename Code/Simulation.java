package Code;

import javax.swing.*;
import java.awt.event.ActionListener;


public class Simulation {

    private JButton openButton, saveButton, stopButton, startButton;
    private JTextField Temp_input, Temp_inc_input, Temp_Dec_input, Temp_sample_input;
    private JLabel Temp, Temp_inc, Temp_Dec, Temp_sample, weatherJLabel;
    private JTextField Humi_input, Humi_inc_input,Humi_Dec_input, Humi_sample_input;
    private JLabel Humi, Humi_inc,Humi_Dec, Humi_sample;
    private JTextField Soil_input, Soil_inc_input, Soil_Dec_input, Soil_sample_input;
    private JLabel Soil, Soil_inc, Soil_Dec, Soil_sample;
    private JTextField weatherField;
    private JTextArea aTextArea;
    
    /**
     * Text filed for soil moisture
     * @return JTextField
     */
    public JTextField getSoil_input() {
        return Soil_input;
    }
    
    /**
     * Text filed for soil moisture increasing  rate
     * @return JTextField
     */
    public JTextField getSoil_inc_input() {
        return Soil_inc_input;
    }
    
    /**
     * Text filed for soil moisture decreasing rate
     * @return JTextField
     */
    public JTextField getSoil_Dec_input() {
        return Soil_Dec_input;
    }
    
    /**
     * Text filed for soil moisture sample rate
     * @return JTextField
     */
    public JTextField getSoil_sample_input() {
        return Soil_sample_input;
    }
    
    /**
     * Text filed for humidity
     * @return JTextField
     */
    public JTextField getHumi_input() {
        return Humi_input;
    }
    
    /**
     * Text filed for humidity increasing  rate
     * @return JTextField
     */
    public JTextField getHumi_inc_input() {
        return Humi_inc_input;
    }

    /**
     * Text filed for humidity decreasing rate
     * @return JTextField
     */
    public JTextField getHumi_Dec_input() {
        return Humi_Dec_input;
    }
    /**
     * Text filed for Green_House_Simulation_System.Humidity sample rate
     * @return JTextField
     */
    public JTextField getHumi_sample_input() {
        return Humi_sample_input;
    }
    /**
     * Text filed for weather
     * @return JTextField
     */
    public JTextField getWeatherField() {
        return weatherField;
    }
    /**
     * Text filed for Green_House_Simulation_System.Temperature
     * @return JTextField
     */
    public JTextField getTemp_input() {
        return Temp_input;
    }
    /**
     * Text filed for Green_House_Simulation_System.Temperature increasing  rate
     * @return JTextField
     */
    public JTextField getTemp_inc_input() {
        return Temp_inc_input;
    }
    /**
     * Text filed for Green_House_Simulation_System.Temperature decreasing rate
     * @return JTextField
     */
    public JTextField getTemp_Dec_input() {
        return Temp_Dec_input;
    }
    /**
     * Text filed for Green_House_Simulation_System.Temperature sample rate
     * @return JTextField
     */
    public JTextField getTemp_sample_input() {
        return Temp_sample_input;
    }
    /**
     * Constructor that has the visual elements for this GUI
     */
    Simulation(){
        
        //create a new Jframe
        JFrame frame = new JFrame("Table Loop");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(920, 600);
        // frame.setLayout(new BorderLayout());

        //create a new Jpanel and set panle to null layout
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //create the new weather section
        weatherJLabel = new JLabel("Weather (°C/min)");
        weatherField = new JTextField();

        //create a temperature input section 
        Temp = new JLabel("Temperature (°C)");
        Temp_inc = new JLabel("Increasing rate (°C/Min)");
        Temp_Dec = new JLabel("Decreasing rate (°C/Min)");
        Temp_sample = new JLabel("Temperature Update");
        Temp_input = new JTextField();
        Temp_inc_input = new JTextField();
        Temp_Dec_input = new JTextField();
        Temp_sample_input = new JTextField();

        //create a humidity input section
        Humi = new JLabel("Humidity (%)");
        Humi_inc = new JLabel("Increasing rate (%/Min)");
        Humi_Dec = new JLabel("Decreasing rate (%/Min)");
        Humi_sample = new JLabel("Humidity Update");
        Humi_input = new JTextField();
        Humi_inc_input = new JTextField();
        Humi_Dec_input = new JTextField();
        Humi_sample_input = new JTextField();

        //create a soil moisture input section
        Soil = new JLabel("Soil Moister (%)");
        Soil_inc = new JLabel("Increasing rate (%/Min)");
        Soil_Dec = new JLabel("Decreasing rate (%/Min)");
        Soil_sample = new JLabel("Soil Moister Update");
        Soil_input = new JTextField();
        Soil_inc_input = new JTextField();
        Soil_Dec_input = new JTextField();
        Soil_sample_input = new JTextField();

        //set the weather to the panel
        weatherJLabel.setBounds(20, 150 , 250, 30);
        weatherField.setBounds(175, 150, 100, 30);
        panel.add(weatherField);
        panel.add(weatherJLabel);

        //set the Green_House_Simulation_System.Temperature Components to the panels
        Temp.setBounds(20, 10 , 250, 30);
        Temp_inc.setBounds(20, 40, 250, 30);
        Temp_Dec.setBounds(20, 70, 250, 30);
        Temp_sample.setBounds(20, 100, 250, 30);
        panel.add(Temp);
        panel.add(Temp_inc);
        panel.add(Temp_Dec);
        panel.add(Temp_sample);

        //set the Green_House_Simulation_System.Humidity Components to the panels
        Humi.setBounds(320, 10 , 250, 30);
        Humi_inc.setBounds(320, 40, 250, 30);
        Humi_Dec.setBounds(320, 70, 250, 30);
        Humi_sample.setBounds(320, 100, 250, 30);
        panel.add(Humi);
        panel.add(Humi_inc);
        panel.add(Humi_Dec);
        panel.add(Humi_sample);
        //set the Green_House_Simulation_System.Humidity Components to the panels
        Soil.setBounds(620, 10 , 250, 30);
        Soil_inc.setBounds(620, 40, 250, 30);
        Soil_Dec.setBounds(620, 70, 250, 30);
        Soil_sample.setBounds(620, 100, 250, 30);
        panel.add(Soil);
        panel.add(Soil_inc);
        panel.add(Soil_Dec);
        panel.add(Soil_sample);

        //This is a new area

        Temp_input.setBounds(175, 10 , 100, 30);
        Temp_inc_input.setBounds(175, 40, 100, 30);
        Temp_Dec_input.setBounds(175, 70, 100, 30);
        Temp_sample_input.setBounds(175, 100, 100, 30);
        panel.add(Temp_input);
        panel.add(Temp_inc_input);
        panel.add(Temp_Dec_input);
        panel.add(Temp_sample_input);

        //set the Green_House_Simulation_System.Humidity Components to the panels
        Humi_input.setBounds(475, 10 , 100, 30);
        Humi_inc_input.setBounds(475, 40, 100, 30);
        Humi_Dec_input.setBounds(475, 70, 100, 30);
        Humi_sample_input.setBounds(475, 100, 100, 30);
        panel.add(Humi_input);
        panel.add(Humi_inc_input);
        panel.add(Humi_Dec_input);
        panel.add(Humi_sample_input);

        //set the Green_House_Simulation_System.Humidity Components to the panels
        Soil_input.setBounds(775, 10 , 100, 30);
        Soil_inc_input.setBounds(775, 40, 100, 30);
        Soil_Dec_input.setBounds(775, 70, 100, 30);
        Soil_sample_input.setBounds(775, 100, 100, 30);
        panel.add(Soil_input);
        panel.add(Soil_inc_input);
        panel.add(Soil_Dec_input);
        panel.add(Soil_sample_input);

        startButton = new JButton("START");
        stopButton = new JButton("STOP");
        saveButton = new JButton("SAVE");
        openButton = new JButton("OPEN");
        
        startButton.setBounds(320, 150 , 100, 30);
        stopButton.setBounds(475, 150, 100, 30);
        saveButton.setBounds(620, 150 , 100, 30);
        openButton.setBounds(775, 150, 100, 30);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(saveButton);
        panel.add(openButton);

        aTextArea = new JTextArea();
        aTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(aTextArea);
        scrollPane.setBounds(20, 200, 880, 350);
        panel.add(scrollPane);

        frame.add(panel);
        frame.setVisible(true);
    }

    /**
     *  Start Button method for action listener
     * @param listener
     */
    public void addStartButtonListener(ActionListener listener) {
        startButton.addActionListener(listener);
    }

    /**
     *  Stop Button method for action listener
     * @param listener
     */
    public void addStopButtonListener(ActionListener listener){
        stopButton.addActionListener(listener);
    }

    /**
     *  Save Button method for action listener
     * @param listener
     */

    public void addSaveButtonActionListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    /**
     *  Open Button method for action listener
     * @param listener
     */
    public void addOpenButtonActionListener(ActionListener listener) {
        openButton.addActionListener(listener);
    }

    /**
     *  append the Green_House_Simulation_System.Temperature return to the text area
     * @param temperature
     * @param mesag
     */
    public synchronized void appendTemperature(double temperature, String mesag) {
        aTextArea.append(String.format("Temperature : "+ temperature + " || " + mesag + "\n"));

    }

    /**
     *   append the Green_House_Simulation_System.Humidity return to the text area
     * @param temperature
     * @param mesag
     */
    public synchronized void appendHumidity(double temperature, String mesag) {
        aTextArea.append(String.format("Humidity : "+ temperature + " || " + mesag + "\n"));

    }

    /**
     *   append the Soil moisture return to the text area
     * @param temperature
     * @param mesag
     */
    public synchronized void appendSoilMoisture(double temperature, String mesag) {
        aTextArea.append(String.format("Soil Moisture : "+ temperature + " || " + mesag + "\n"));

    }

    /**
     *   append a string to the text area
     * @param mesag
     */
    public synchronized void appendText(String mesag) {
        aTextArea.append(String.format(mesag));
    }

    /**
     *  append the input setting of rht user to the text area
     * @return
     */
    public String getinputs() {
        return "\n*** Temperature: "+Temp_input.getText()+
        " ## Temperature Decrease rate: " +Temp_Dec_input.getText()+" ## Temperature Increase rate: " +Temp_inc_input.getText()+
        " ## Temperature Sample rate: " +Temp_sample_input.getText()+ "\n*** Humidity: "+ Humi_input.getText()+
        " ## Humidity Decrease rate: " +Humi_Dec_input.getText()+" ## Humidity Increase rate: " +Humi_inc_input.getText()+
        " ## Humidity Sample rate (mille): " +Humi_sample_input.getText()+ "\n*** Soil Moister: " +Soil_input.getText()+
        " ## Soil Moister Decrease rate: " +Soil_Dec_input.getText()+
        " ## Soil Moister Increase rate: "+Soil_inc_input.getText()+" ## Soil Moister Sample rate (mille): " +Soil_sample_input.getText()+
                "\n*** Weather: " + weatherField.getText();
    }

    /**
     * this method get the text of the text area
     * @return
     */
    public String getTemperatureLog() {
        return aTextArea.getText();
    }
}
