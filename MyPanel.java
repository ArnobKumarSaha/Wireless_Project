import java.io.File;
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    Image img;

    public MyPanel(LayoutManager l) {
        super(l);

        JFileChooser fc = new JFileChooser();
        int result = fc.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            String sname = file.getAbsolutePath();
            img = new ImageIcon(sname).getImage();

            double xRatio = img.getWidth(null) / 400;
            double yRatio = img.getHeight(null) / 400;
            double ratio = (xRatio + yRatio) / 2;

            img = img.getScaledInstance((int)(img.getWidth(null) / ratio), (int)(img.getHeight(null) / ratio), Image.SCALE_SMOOTH);
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(img, 0, 0, Color.WHITE, null);
    }
}