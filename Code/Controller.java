package Code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private Temperature TempModel;
    private Simulation view;
    private SoilMoisture Moist;
    private Humidity Humi;

    /**
     * constructor which implements the other classes and add action listeners
     * @param model Model for Green_House_Simulation_System.Temperature
     * @param Moist Moist for Soil Moisture
     * @param Humi Humi for Green_House_Simulation_System.Humidity
     * @param view view for the Green_House_Simulation_System.Simulation GUI
     */
    public Controller(Temperature model, SoilMoisture Moist, Humidity Humi, Simulation view) {
        this.TempModel = model;
        this.view = view;
        this.Moist = Moist;
        this.Humi = Humi;

        // attach listeners to view components
        view.addStartButtonListener(new StartButtonListener());
        view.addStopButtonListener(new StopButtonListener());
        view.addSaveButtonActionListener(new SaveButtonListener());
        view.addOpenButtonActionListener(new OpenButtonListener());
    }

    /**
     * This method gets the values from the Gui and them shares them to the appropriate Model classes
     */
    class StartButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //append the 13 text input form view
            double temperature1 = Double.parseDouble(view.getTemp_input().getText());
            double external1 = Double.parseDouble(view.getWeatherField().getText());
            double incrementValue1 = Double.parseDouble(view.getTemp_inc_input().getText());
            double decrementValue1 = Double.parseDouble(view.getTemp_Dec_input().getText());
            int sampleRate1 = Integer.parseInt(view.getTemp_sample_input().getText());

            double humi = Double.parseDouble(view.getHumi_input().getText());
            double incrementValue2 = Double.parseDouble(view.getHumi_inc_input().getText());
            double decrementValue2 = Double.parseDouble(view.getHumi_Dec_input().getText());
            int sampleRate2 = Integer.parseInt(view.getHumi_sample_input().getText());

            double soil = Double.parseDouble(view.getSoil_input().getText());
            double incrementValue3 = Double.parseDouble(view.getSoil_inc_input().getText());
            double decrementValue3 = Double.parseDouble(view.getSoil_Dec_input().getText());
            int sampleRate3 = Integer.parseInt(view.getSoil_sample_input().getText());

            TempModel.setTemperature(temperature1);
            TempModel.setExternalTemperature(external1);
            TempModel.setIncrementValue(incrementValue1);
            TempModel.setDecrementValue(decrementValue1);
            TempModel.setSampleRate(sampleRate1);
            TempModel.start();

            Moist.setMoisture(soil);
            Moist.setExternal(external1);
            Moist.setIncrementValue(incrementValue2);
            Moist.setDecrementValue(decrementValue2);
            Moist.setSampleRate(sampleRate2);
            Moist.start();

            Humi.sethumidity(humi);
            Humi.setExternal(external1);
            Humi.setIncrementValue(incrementValue3);
            Humi.setDecrementValue(decrementValue3);
            Humi.setSampleRate(sampleRate3);
            Humi.start();

        }
    }

    /**
     * This classes controller the Stop button
     */
    class StopButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TempModel.stop();
            Humi.stop();
            Moist.stop();
        }
    }

    /**
     * This classes controller the Save button to save in the same directory as the java file
     */
    class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String content = view.getTemperatureLog();
            String initdata = view.getinputs();
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt"));
                writer.write(initdata);
                writer.write(content);
                writer.close();
            } catch (IOException ex) {
                System.out.println("Error");
            }
            
            
        }
    }

    /**
     *  This classes controller the Open button to Open the saved files in the area field
     */
    class OpenButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("Save.txt"));
                String line;
                while ((line = reader.readLine())!=null){
                    view.appendText(line+"\n");
                }
                reader.close();
                
            } catch (Exception ez) {
                System.out.println("Error");
            }

        }
    }

    
}
