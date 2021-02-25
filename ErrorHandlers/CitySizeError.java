package ErrorHandlers;

import javax.swing.JOptionPane;

public class CitySizeError {
    public CitySizeError(){
        infoBox("You have to choose the size of the City.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

