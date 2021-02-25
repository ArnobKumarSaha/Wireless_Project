import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondAnswer {
    protected JFrame frame;
    protected JLabel label;
    protected JPanel panel, midPanel, lowerPanel, panelPathLoss;
    protected JMenuBar mb;
    protected JTextArea t1;
    protected JButton goToMainMenu, goToFirst, goToSecond;

    Font font = new Font("Segoe Script", Font.BOLD, 20);


    private void makeMenuBar(){
        mb = new JMenuBar();
        JMenu m1 = new JMenu("My info");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
    }

    private void makeMidPanel(double ans){
        panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        // Part 1
        panelPathLoss = new JPanel();
        t1 = new JTextArea("Predicted Path loss in decible (dB) : \n " + ans);
        t1.setFont(font);
        t1.setForeground(Color.blue);
        panelPathLoss.add(t1);
        panelPathLoss.setBackground(Color.darkGray);

        // Adding part
        panel.add(panelPathLoss);
    }

    private void makeLowerPanel() {
        goToFirst = new JButton("Check again");
        goToFirst.setBackground(Color.green);
        goToFirst.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new SecondQuestion();
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
        goToSecond = new JButton("Go to 1st Question");
        goToSecond.setBackground(Color.cyan);
        goToSecond.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new FirstQuestion();
                frame.dispose();
            }
        });
        lowerPanel = new JPanel(); // the panel is not visible in output
        label = new JLabel("Enter Text");
        lowerPanel.add(goToFirst);
        lowerPanel.add(goToMainMenu);
        lowerPanel.add(goToSecond);
    }
    private double lg(double x){
        return Math.log10(x);//Math.log(2);
    }

    private double findCorrectionFactor(double frequency, double receiving, int sizeOpt){
        double correctionFactor = 0;
        if(sizeOpt == 1 || sizeOpt ==2){
            System.out.println(frequency+" "+receiving+" "+sizeOpt);
            correctionFactor= (1.1 * lg(frequency) - 0.7 ) * receiving;
            double xx =  (1.56 * lg(frequency) - 0.8);
            System.out.println("here I am " + correctionFactor + " " +xx);
            correctionFactor -= xx;
        }
        else{
            if(frequency <= 300){
                correctionFactor = 8.29 * (lg(1.54) * receiving) * (lg(1.54) * receiving) -1.1 ;
            }
            else{
                correctionFactor = 3.2 * (lg(11.75)* receiving) * (lg(11.75)* receiving) - 4.97 ;
            }
        }
        return correctionFactor;
    }

    private double findUrban(double frequency, double transmitting, double receiving, double distance, double correctionFactor){
        double tmp = 69.55 + 26.16 * lg(frequency) - 13.82 * lg(transmitting) - correctionFactor;
        tmp += (44.9 - 6.55 * lg(transmitting)) * lg(distance);
        return tmp;
    }

    private double Calculate(double frequency, double transmitting, double receiving, int sizeOpt, double distance, int typeOpt){
        double correctionFactor = findCorrectionFactor(frequency, receiving, sizeOpt);
        System.out.println("Correction Factor is " + correctionFactor);
        
        double urbanPathLoss = findUrban(frequency, transmitting, receiving, distance, correctionFactor);

        if(typeOpt == 1){
            return urbanPathLoss;
        }
        else if(typeOpt == 2){
            double SubUrban = urbanPathLoss - 2 * lg(frequency/28) * lg(frequency/28) - 5.4;
            return SubUrban;
        }
        else if(typeOpt == 3){
            double openspace = urbanPathLoss - 4.78 * lg(frequency) * lg(frequency) - 18.733 * lg(frequency) - 40.98;
            return openspace;
        }
        return 0.0;
    }

    public SecondAnswer(double frequency, double transmitting, double receiving, int sizeOpt, double distance, int typeOpt) {
        frame = new JFrame("Mobile and Wireless Communication Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        double ans = Calculate(frequency, transmitting, receiving, sizeOpt, distance, typeOpt);

        makeMenuBar();
        makeMidPanel(ans);
        makeLowerPanel();

        frame.setBounds(500, 150, 600, 400);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setVisible(true);
    }
}

