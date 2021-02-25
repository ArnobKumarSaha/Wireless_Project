package ErrorHandlers;

import javax.swing.JOptionPane;

public class FrequencyError {
    public FrequencyError(){
        infoBox("Frequency have to be in between 150 to 1500 MHz.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
