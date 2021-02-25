import javax.swing.*;

import static java.lang.Double.valueOf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ErrorHandlers.*;

public class FirstQuestion {
    protected JFrame frame;
    protected JLabel label;
    protected JPanel panel, midPanel, lowerPanel, panelCellType, panelAreaSize, panelRadius, panelFactor, panelTraffic;
    protected JMenuBar mb;
    protected JTextArea t1, t2, t3, t4, t5, result;
    protected JButton getAnswer;
    protected JRadioButton radio1, radio2;
    protected ButtonGroup bg;
    protected JTextField fieldAreaSize, fieldradius, fieldFactor, fieldTraffic;

    Font font = new Font("Segoe Script", Font.BOLD, 20);

    private void makeMenuBar() {
        mb = new JMenuBar();
        JMenu m1 = new JMenu("My info");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
    }

    private void makeMidPanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        // Part 1
        panelAreaSize = new JPanel();
        t1 = new JTextArea("Area size to cover : ");
        fieldAreaSize = new JTextField(10);
        t1.setFont(font);
        t1.setForeground(Color.blue);
        fieldAreaSize.setFont(font);
        panelAreaSize.add(t1);
        panelAreaSize.add(fieldAreaSize);
        panelAreaSize.setBackground(Color.darkGray);

        // Part 2
        panelCellType = new JPanel();
        t2 = new JTextArea("Cell type : ");
        panelCellType.add(t2);
        t2.setFont(font);
        t2.setForeground(Color.blue);
        radio1 = new JRadioButton("Macro cell");
        radio2 = new JRadioButton("Micro cell");
        bg = new ButtonGroup();
        bg.add(radio1);
        bg.add(radio2);
        panelCellType.add(radio1);
        panelCellType.add(radio2);
        panelCellType.setBackground(Color.DARK_GRAY);

        // Part 3
        panelRadius = new JPanel();
        t3 = new JTextArea("Radius of each cell : ");
        fieldradius = new JTextField(10);
        t3.setFont(font);
        t3.setForeground(Color.blue);
        fieldradius.setFont(font);
        panelRadius.add(t3);
        panelRadius.add(fieldradius);
        panelRadius.setBackground(Color.darkGray);

        // Part 4
        panelFactor = new JPanel();
        t4 = new JTextArea("Frequency reuse factor : ");
        fieldFactor = new JTextField(10);
        t4.setFont(font);
        t4.setForeground(Color.blue);
        fieldFactor.setFont(font);
        panelFactor.add(t4);
        panelFactor.add(fieldFactor);
        panelFactor.setBackground(Color.DARK_GRAY);


        // Part 5
        panelTraffic = new JPanel();
        t5 = new JTextArea("Channel Traffic : ");
        fieldTraffic = new JTextField(10);
        t5.setFont(font);
        t5.setForeground(Color.blue);
        fieldTraffic.setFont(font);
        panelTraffic.add(t5);
        panelTraffic.add(fieldTraffic);
        panelTraffic.setBackground(Color.DARK_GRAY);



        // Adding part
        panel.add(panelAreaSize);
        panel.add(panelCellType);
        panel.add(panelRadius);
        panel.add(panelFactor);
        panel.add(panelTraffic);
    }

    private boolean checkN(int N){
        for(int i=0;i<10000;i++){
            for(int j=0;j<10000;j++){
                long val = (long) 0 + i*i + i*j + j*j ;
                if(val ==N) return true;
            }
        }
        return false;
    }

    private void makeLowerPanel() {
        getAnswer = new JButton("Get Answer");
        result = new JTextArea();
        getAnswer.setBackground(Color.cyan);
        getAnswer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // result.setText("The answer is ");
                // getAnswer.setEnabled(false);

                double areaSize = valueOf(fieldAreaSize.getText());
                double radius = valueOf(fieldradius.getText());
                int frequencyReuseFactor = Integer.parseInt(fieldFactor.getText());
                Boolean type = true;
                double traffic = valueOf(fieldTraffic.getText());
                if(radio1.isSelected()){
                    type = true;
                }
                else if(radio2.isSelected()){
                    type = false;
                }
                boolean ch = checkN(frequencyReuseFactor);
                System.out.println("The error message in FirstQuestion " + ch);

                if(ch == false){
                    new FirstError();
                    return;
                }

                new FirstAnswer(areaSize, radius, frequencyReuseFactor, type, traffic);
                frame.dispose();
            }
        });
        lowerPanel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        lowerPanel.add(getAnswer);
        lowerPanel.add(result);
    }

    public FirstQuestion() {
        frame = new JFrame("Mobile and Wireless Communication Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        makeMenuBar();
        makeMidPanel();
        makeLowerPanel();

        // Text Area at the Center
        /*JTextArea ta = new JTextArea();
        q1 = new JButton("Question 1");
        q2 = new JButton("Question 1");
        ta.add(q1);
        ta.add(q2);*/

        //frame.setIconImage((new ImageIcon()).getClass().getResource("two men.jpg"));

        frame.setBounds(500, 150, 600, 400);
        frame.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}

