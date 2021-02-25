package ErrorHandlers;

import javax.swing.JOptionPane;

public class FirstError {
    public FirstError(){
        infoBox("Value of the given frequency reuse factor is not valid.", "Error Handler");
    }
    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
