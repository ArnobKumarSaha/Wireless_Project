package ErrorHandlers;

import javax.swing.JOptionPane;

public class DistanceError {
    public DistanceError(){
        infoBox("Propagation distance between two antenna should be in range 1 to 20 Km.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
