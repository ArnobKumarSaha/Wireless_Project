//import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;

public class App implements ActionListener {
    protected JFrame frame;
    protected JLabel label;
    protected JPanel panel, midPanel, lowerPanel, leftPanel, rightPanel, 
    panelStudent, panelTeacher, panelReg, panelOther;
    protected JTextArea t1,t2,t3,t4;
    protected JMenuBar mb;
    protected JButton send, reset, tmp;
    protected int counter = 0;
    protected JSplitPane pane;
    protected JButton q1, q2;

    Font font = new Font("Segoe Script", Font.BOLD, 20);

    private void makeMenuBar() {
        mb = new JMenuBar();
        JMenu m1 = new JMenu("My info");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        /*
         * JMenuItem m11 = new JMenuItem("Open"); JMenuItem m22 = new
         * JMenuItem("Save as"); m1.add(m11); m1.add(m22);
         */
    }

    private void makeMidPanel() {
        panel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();

        q1 = new JButton("Question 1");
        q1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new FirstQuestion();
                frame.dispose();
            }

        });
        q2 = new JButton("Question 2");
        q2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SecondQuestion();
                frame.dispose();
            }

        });
        rightPanel.add(q1);
        rightPanel.add(q2);
        rightPanel.setLayout(new GridLayout(2, 1));

        tmp = new JButton("tmp");
        /*
        BufferedImage myPicture;
        try {
            myPicture = ImageIO.read(new File("F:\\Development\\Java files\\java\\src\\two_men.jpg"));
        } catch (IOException e1) {
            System.out.println("Error occured in Image reading.");
            e1.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon("two men.jpg"));
        leftPanel.add(picLabel);
        */


        //leftPanel.add(new ImagePanel());
        leftPanel.setLayout(new GridLayout(4, 1));

        // Part 1
        panelStudent = new JPanel();
        t1 = new JTextArea("Name : Arnob kumar saha");
        t1.setFont(font);
        t1.setForeground(Color.blue);
        panelStudent.add(t1);
        panelStudent.setBackground(Color.darkGray);

        //Part 2
        panelReg = new JPanel();
        t2 = new JTextArea("Reg No : 2016331083");
        t2.setFont(font);
        t2.setForeground(Color.blue);
        panelReg.add(t2);
        panelReg.setBackground(Color.darkGray);

        // Part 3
        panelTeacher = new JPanel();
        t3 = new JTextArea("To Sadia Sultana");
        t3.setFont(font);
        t3.setForeground(Color.blue);
        panelTeacher.add(t3);
        panelTeacher.setBackground(Color.darkGray);

        // Part 4
        panelOther = new JPanel();
        t4 = new JTextArea("CSE , SUST");
        t4.setFont(font);
        t4.setForeground(Color.blue);
        panelOther.add(t4);
        panelOther.setBackground(Color.darkGray);

        pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        pane.setResizeWeight(0.6);

        leftPanel.add(panelTeacher);
        leftPanel.add(panelStudent);
        leftPanel.add(panelReg);
        leftPanel.add(panelOther);
        
        /*panel.setLayout(new BorderLayout());
        panel.add( leftPanel, BorderLayout.WEST );
        panel.add( rightPanel, BorderLayout.EAST );*/
    }

    private void makeLowerPanel() {
        lowerPanel = new JPanel(); // the panel is not visible in output
        /*label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        send = new JButton("Send");
        send.addActionListener(this);

        reset = new JButton("Reset");
        lowerPanel.add(label); // Components Added using Flow Layout
        lowerPanel.add(tf);
        lowerPanel.add(send);
        lowerPanel.add(reset);*/
    }

    public App() {
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
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.SOUTH, lowerPanel);
        frame.getContentPane().add(BorderLayout.CENTER, pane);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        counter++;
        label.setText( "Number of clicks " + counter );
    }
}

