import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InterruptedIOException;

public class RownanieKwadratowe implements ActionListener {
    private JFrame frame;
    private JTextField FieldA, FieldB, FieldC;
    private JLabel LabelA, LabelB, LabelC, Label1, Label2, Label3, Label4, LabelResult, LabelResult2;
    private JButton countButton, buttonReturn, buttonHelp;
    private int a,b,c;
    private double x1,x2,delta;

    public RownanieKwadratowe()
    {
        frame = new JFrame("Równanie Kwadratowe");
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        FieldA = new JTextField();
        FieldA.setBounds(60,50, 40,40);

        FieldB= new JTextField();
        FieldB.setBounds(160,50, 40,40);

        FieldC = new JTextField();
        FieldC.setBounds(260,50, 40,40);


        LabelA = new JLabel("X");
        LabelA.setBounds(100,50,40,40);
        Label1 = new JLabel("2");
        Label1.setBounds(108,35,40,40);

        Label2 = new JLabel("+");
        Label2.setBounds(130,50,40,40);
        Label2.setFont(new Font("Arial",Font.BOLD,18));

        LabelB = new JLabel("X");
        LabelB.setBounds(200,50,40,40);

        Label3 = new JLabel("+");
        Label3.setBounds(230,50,40,40);
        Label3.setFont(new Font("Arial",Font.BOLD,18));

        Label4 = new JLabel("= 0");
        Label4.setBounds(310,50,40,40);
        Label4.setFont(new Font("Arial",Font.BOLD,18));

        LabelResult = new JLabel("");
        LabelResult.setBounds(20,170,350,30);
        LabelResult2 = new JLabel("");
        LabelResult2.setBounds(20,200,350,30);


        countButton = new JButton("Policz");
        countButton.setBounds(150,120,100,30);
        countButton.addActionListener(this);

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(150,310,100,30);
        buttonReturn.addActionListener(this);

        buttonHelp = new JButton("Czym jest ?");
        buttonHelp.setBounds(150,250,100,30);
        buttonHelp.addActionListener(this);

        a=0;
        b=0;
        c=0;
        x1=0;
        x2=0;
        delta=0;

        frame.add(FieldA);
        frame.add(FieldB);
        frame.add(FieldC);
        frame.add(LabelA);
        frame.add(Label1);
        frame.add(Label2);
        frame.add(LabelB);
        frame.add(Label3);
        frame.add(Label4);
        frame.add(countButton);
        frame.add(buttonReturn);
        frame.add(buttonHelp);
        frame.add(LabelResult);
        frame.add(LabelResult2);
    }

    public void run()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == countButton)
        {
            a = Integer.parseInt(FieldA.getText());
            b = Integer.parseInt(FieldB.getText());
            c = Integer.parseInt(FieldC.getText());

            delta = (b*b)-(4*a*c);

            if(delta<0)
            {
                LabelResult.setText("Delta mniejsza od 0. Równanie nie posiada rozwiązań.");
                LabelResult2.setText("");
            }

            if(delta==0)
            {
                x1 = -b/(2*a);
                LabelResult.setText("Równanie posiada 1 rozwiązanie x1 = "+x1+".");
                LabelResult2.setText("");
            }

            if(delta>0)
            {
                x1 = (-b-(Math.sqrt(delta)))/(2*a);
                x2 = (-b+(Math.sqrt(delta)))/(2*a);
                LabelResult.setText("Równanie posiada 2 rozwiązania x1 = "+x1+",");
                LabelResult2.setText("oraz x2 = "+x2+".");
            }
        }

        if(source == buttonReturn)
        {
            frame.dispose();
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "Jest to taka funkcja, którą można zapisać w postaci: y=ax^2+bx+c , gdzie a, b, c są liczbami rzeczywistymi i a ≠ 0.");
        }

    }
}
