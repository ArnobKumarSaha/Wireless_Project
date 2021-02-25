package ErrorHandlers;

import javax.swing.JOptionPane;

public class ReceivingHeightError {
    public ReceivingHeightError(){
        infoBox("Height of Receiving Antena have to be in between 1 to 10 m.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
