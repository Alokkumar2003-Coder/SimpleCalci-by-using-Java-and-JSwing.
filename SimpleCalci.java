import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Myframe extends JFrame implements ActionListener {
    private Container c;
    private JLabel label1, label2, result;
    private JTextField t1, t2;
    private JButton add, sub, mul, div;

    Myframe() {
        setTitle("Simple Calculator");
        setSize(300, 300);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);

        label1 = new JLabel("First Number :");
        label1.setBounds(10, 20, 100, 20);
        c.add(label1);

        t1 = new JTextField();
        t1.setBounds(120, 20, 100, 20);
        c.add(t1);

        label2 = new JLabel("Second Number :");
        label2.setBounds(10, 50, 100, 20);
        c.add(label2);

        t2 = new JTextField();
        t2.setBounds(120, 50, 100, 20);
        c.add(t2);

        add = new JButton("+");
        add.setBounds(10, 80, 50, 30);
        c.add(add);

        sub = new JButton("-");
        sub.setBounds(70, 80, 50, 30);
        c.add(sub);

        mul = new JButton("*");
        mul.setBounds(130, 80, 50, 30);
        c.add(mul);

        div = new JButton("/");
        div.setBounds(190, 80, 50, 30);
        c.add(div);

        result = new JLabel("Result : ");
        result.setBounds(10, 120, 150, 20);
        c.add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int c = 0;

            if (e.getSource() == add) {
                c = a + b;
            } else if (e.getSource() == sub)
            {
                c = a - b;
            } 
            else if (e.getSource() == mul) 
            {
                c = a * b;
            } 
            else if (e.getSource() == div) 
            {
                if (b != 0) 
                {
                    c = a / b;
                } 
                else 
                {
                    throw new ArithmeticException("Division by zero");
                }
            }
            result.setText("Result : " + c);
        } catch (NumberFormatException ex) {
            result.setText("Please Input Integer values");
        } catch (ArithmeticException ex) {
            result.setText("Can't divide by zero");
        }
    }
}

public class SimpleCalci {
    public static void main(String[] args) {
        Myframe f = new Myframe();
    }
}
