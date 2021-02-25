import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.valueOf;
import ErrorHandlers.*;

public class SecondQuestion {
    protected JFrame frame;
    protected JLabel label;
    protected JPanel panel, midPanel, lowerPanel, panelCarrierFrequency, panelHeightTranmitting, 
    panelHeightReceiving, panelPropagationDist, panelCitySize, panelAreaType;
    protected JMenuBar mb;
    protected JTextArea t1, t2, t3, t4, t5, t6, result;
    protected JButton getAnswer;
    protected JRadioButton rSmall, rMedium, rLarge, rUrban, rSuburban, rOpen;
    protected ButtonGroup bgSize, bgType;
    protected JTextField f1,f2,f3,f4,f5,f6;

    Font font = new Font("Segoe Script", Font.BOLD, 16);

    private void makeMenuBar() {
        mb = new JMenuBar();
        JMenu m1 = new JMenu("My info");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
    }

    private void makeMidPanel() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        // Part 1
        panelCarrierFrequency= new JPanel();
        t1 = new JTextArea("Carrier frequency in MHz (150 to 1500): ");
        f1 = new JTextField(10);
        t1.setFont(font);
        t1.setForeground(Color.blue);
        f1.setFont(font);
        panelCarrierFrequency.add(t1);
        panelCarrierFrequency.add(f1);
        panelCarrierFrequency.setBackground(Color.darkGray);

        // Part 2
        panelHeightTranmitting = new JPanel();
        t2 = new JTextArea("Height of transmitting Antenna in m (30 to 300): ");
        f2 = new JTextField(10);
        t2.setFont(font);
        t2.setForeground(Color.blue);
        f2.setFont(font);
        panelHeightTranmitting.add(t2);
        panelHeightTranmitting.add(f2);
        panelHeightTranmitting.setBackground(Color.darkGray);

        // Part 3
        panelHeightReceiving = new JPanel();
        t3 = new JTextArea("Height of recieving Antenna in m (1 to 10): ");
        f3 = new JTextField(10);
        t3.setFont(font);
        t3.setForeground(Color.blue);
        f3.setFont(font);
        panelHeightReceiving.add(t3);
        panelHeightReceiving.add(f3);
        panelHeightReceiving.setBackground(Color.darkGray);

        // Part 4
        panelCitySize = new JPanel();
        t4 = new JTextArea("Size of the city : ");
        t4.setFont(font);
        t4.setForeground(Color.blue);

        rSmall = new JRadioButton("Small city");
        rMedium = new JRadioButton("Medium city");
        rLarge = new JRadioButton("Large city");
        bgSize = new ButtonGroup();
        bgSize.add(rSmall);
        bgSize.add(rMedium);
        bgSize.add(rLarge);

        panelCitySize.add(t4);
        panelCitySize.add(rSmall);
        panelCitySize.add(rMedium);
        panelCitySize.add(rLarge);

        panelCitySize.setBackground(Color.DARK_GRAY);

        // Part 5
        panelPropagationDist = new JPanel();
        t5 = new JTextArea("Distance between antenna (1 to 20): ");
        f5 = new JTextField(10);
        t5.setFont(font);
        t5.setForeground(Color.blue);
        f5.setFont(font);
        panelPropagationDist.add(t5);
        panelPropagationDist.add(f5);
        panelPropagationDist.setBackground(Color.DARK_GRAY);


        // Part 6
        panelAreaType = new JPanel();
        t6 = new JTextArea("Select Area Type : ");
        t6.setFont(font);
        t6.setForeground(Color.blue);

        rUrban = new JRadioButton("Urban");
        rSuburban = new JRadioButton("SubUrban");
        rOpen = new JRadioButton("Open Area");
        bgType = new ButtonGroup();
        bgType.add(rUrban);
        bgType.add(rSuburban);
        bgType.add(rOpen);

        panelAreaType.add(t6);
        panelAreaType.add(rUrban);
        panelAreaType.add(rSuburban);
        panelAreaType.add(rOpen);
        panelAreaType.setBackground(Color.DARK_GRAY);

        // Adding part
        panel.add(panelCarrierFrequency);
        panel.add(panelHeightTranmitting);
        panel.add(panelHeightReceiving);
        panel.add(panelCitySize);
        panel.add(panelPropagationDist);
        panel.add(panelAreaType);
    }

    private void makeLowerPanel() {
        getAnswer = new JButton("Get Answer");
        result = new JTextArea();
        getAnswer.setBackground(Color.cyan);
        getAnswer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // result.setText("The answer is ");
                // getAnswer.setEnabled(false);

                double frequency = valueOf(f1.getText());
                double transmitting = valueOf(f2.getText());
                double receiving = valueOf(f3.getText());
                int sizeOpt = 0;
                if(rSmall.isSelected()){
                    sizeOpt = 1;
                }
                else if(rMedium.isSelected()){
                    sizeOpt = 2;
                }
                else if(rLarge.isSelected()){
                    sizeOpt = 3;
                }

                double distance = valueOf(f5.getText());

                int typeOpt = 0;
                if(rUrban.isSelected()){
                    typeOpt = 1;
                }
                else if(rSuburban.isSelected()){
                    typeOpt = 2;
                }
                else if(rOpen.isSelected()){
                    typeOpt = 3;
                }

                // CHECKERs

                if(frequency<150 || frequency>1500){
                    new FrequencyError();
                    return;
                }
                if(transmitting<30 || transmitting>300){
                    new TransmittingHeightError();
                    return;
                }
                if(receiving<1 || receiving>10){
                    new ReceivingHeightError();
                    return;
                }
                if(sizeOpt==0){
                    new CitySizeError();
                    return;
                }
                if(distance<1 || distance>20){
                    new DistanceError();
                    return;
                }
                if(typeOpt==0){
                    new AreaTypeError();
                    return;
                }

                new SecondAnswer(frequency, transmitting, receiving, sizeOpt, distance, typeOpt);
                frame.dispose();
            }
        });
        lowerPanel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        lowerPanel.add(getAnswer);
        lowerPanel.add(result);
    }

    public SecondQuestion() {
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

        frame.setBounds(450, 150, 650, 400);
        frame.setBackground(Color.darkGray);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}

