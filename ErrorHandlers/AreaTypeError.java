package ErrorHandlers;

import javax.swing.JOptionPane;

public class AreaTypeError {
    public AreaTypeError(){
        infoBox("You have to choose the type of the City.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

