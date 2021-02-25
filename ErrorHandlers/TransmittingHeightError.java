package ErrorHandlers;

import javax.swing.JOptionPane;

public class TransmittingHeightError {
    public TransmittingHeightError(){
        infoBox("Height of Transmitting Antenna have to be in between 30 to 300 m.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
