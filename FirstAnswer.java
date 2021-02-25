import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstAnswer {
    protected JFrame frame;
    protected JLabel label;
    protected JPanel panel, midPanel, lowerPanel, panelCellType, panelAreaSize, panelRadius, panelFactor;
    protected JMenuBar mb;
    protected JTextArea t1,t2,t3,t4;
    protected JButton goToMainMenu, goToFirst, goToSecond;

    Font font = new Font("Segoe Script", Font.BOLD, 20);


    private void makeMenuBar(){
        mb = new JMenuBar();
        JMenu m1 = new JMenu("My info");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
    }

    private void makeMidPanel(int cellNumber, int channelNumber, int channelCapacity){
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,1));

        // Part 1
        panelAreaSize = new JPanel();
        t1 = new JTextArea("Number of cell required : " + cellNumber);
        t1.setFont(font);
        t1.setForeground(Color.blue);
        panelAreaSize.add(t1);
        panelAreaSize.setBackground(Color.darkGray);

        // Part 2
        panelCellType = new JPanel();
        t2 = new JTextArea("Number of channels per cell : " + channelNumber);
        panelCellType.add(t2);
        t2.setFont(font);
        t2.setForeground(Color.blue);
        panelCellType.setBackground(Color.DARK_GRAY);

        // Part 3
        panelRadius = new JPanel();
        t3 = new JTextArea("Total chennel Capacity : " + channelCapacity);
        t3.setFont(font);
        t3.setForeground(Color.blue);
        panelRadius.add(t3);
        panelRadius.setBackground(Color.darkGray);

        // Part 4
        panelFactor = new JPanel();
        t4 = new JTextArea("Total number of possible Concurrent call : " + channelCapacity);
        t4.setFont(font);
        t4.setForeground(Color.blue);
        panelFactor.add(t4);
        panelFactor.setBackground(Color.DARK_GRAY);

        // Adding part
        panel.add(panelAreaSize);
        panel.add(panelCellType);
        panel.add(panelRadius);
        panel.add(panelFactor);
    }

    private void makeLowerPanel() {
        goToFirst = new JButton("Check again");
        goToFirst.setBackground(Color.green);
        goToFirst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new FirstQuestion();
                frame.dispose();
            }
        });

        goToMainMenu = new JButton("Go to the Main Menu");
        goToMainMenu.setBackground(Color.MAGENTA);
        goToMainMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new App();
                frame.dispose();
            }
        });
        goToSecond = new JButton("Go to 2nd Question");
        goToSecond.setBackground(Color.cyan);
        goToSecond.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new SecondQuestion();
                frame.dispose();
            }
        });
        lowerPanel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        lowerPanel.add(goToFirst);
        lowerPanel.add(goToMainMenu);
        lowerPanel.add(goToSecond);
    }


    private int[] Calculate(double areaSize, double radius, int frequencyReuseFactor, Boolean type, double traffic){
        double deno = 1.5 * Math.sqrt(3) * radius * radius;
        int cellNumber = (int) (areaSize / deno) ;
        int channelNumber = (int)(traffic / frequencyReuseFactor);
        int channelCapacity = channelNumber * cellNumber;

        int ans[] = {cellNumber, channelNumber, channelCapacity};
        return ans;
    }

    public FirstAnswer(double areaSize, double radius, int frequencyReuseFactor, Boolean type, double traffic) {
        frame = new JFrame("Mobile and Wireless Communication Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        int ans[] = Calculate(areaSize, radius, frequencyReuseFactor, type, traffic);

        makeMenuBar();
        makeMidPanel(ans[0], ans[1], ans[2]);
        makeLowerPanel();

        frame.setBounds(500, 150, 600, 400);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}

