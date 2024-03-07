import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UI extends JFrame implements ActionListener, MouseMotionListener {
    private JButton b = new JButton("Color 1");
    private JButton b2 = new JButton("Color 2");
    private JButton b3 = new JButton("+");
    private JButton b4 = new JButton("-");
    private JButton b5 = new JButton("Pencil");
    private JButton b6 = new JButton("Eraser");

    private int oldX = 0;
    private int oldY = 0;
    private int newX = 0;
    private int newY = 0;

    private Color color;
    private int thickness = 1;

    JPanel drawingPanel = new JPanel();




    UI() {
        setSize(500, 500);
        setLayout(null);
        add(b);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        addMouseMotionListener(this);

        b.setBounds(15, 25, 100, 100);
        b.setBackground(Color.MAGENTA);
        b2.setBounds(120, 25, 100, 100);
        b2.setBackground(Color.BLUE);
        b3.setBounds(230, 25, 50, 40);
        b3.setBackground(Color.LIGHT_GRAY);
        b4.setBounds(290, 25, 50, 40);
        b4.setBackground(Color.LIGHT_GRAY);
        b5.setBounds(230, 75, 110, 50);
        b5.setBackground(Color.LIGHT_GRAY);
        b6.setBounds(355, 25, 90, 90);
        b6.setBackground(Color.WHITE);



        b.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(color);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(thickness));
        if (oldX != 0 && oldY != 0) {
            g.drawLine(oldX, oldY, e.getX(), e.getY());
        }
        oldX = e.getX();
        oldY = e.getY();

        if (b6.getX()<=e.getX()&& e.getX()<b6.getX()+b6.getWidth()) {
            b6.setBounds(e.getX()-b6.getWidth()/2,(e.getY()-b6.getHeight()/2)-30,100,50);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = 0;
        oldY = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        switch (b.getText()) {
            case "Color 1":
                color = Color.MAGENTA;
                break;
            case "Color 2":
                color = Color.BLUE;
                break;
            case "Pencil":
                color = Color.BLACK;
                break;
            case "+":
                thickness++;
                break;
            case "-":
                if (thickness > 1) {
                    thickness--;
                }
                break;

        }
    }
}