import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OdleglosciPunktow implements ActionListener
{
    private JFrame frame;
    private JLabel LabelPointA, LabelProsta, LabelProstaA, LabelProstaB, LabelOdleglosc, LabelResultOdleglosc;
    private JTextField FieldPointAx, FieldPointAy, FieldProstaX, FieldProstaY;
    private JButton buttonCount, buttonReturn, buttonHelp;


    public OdleglosciPunktow()
    {
        frame = new JFrame("Odległość punktu od prostej");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        LabelPointA = new JLabel("Punkt A (X,Y)");
        LabelPointA.setBounds(45,20,100,50);
        LabelPointA.setFont(new Font("Arial",Font.BOLD,15));
        FieldPointAx = new JTextField();
        FieldPointAx.setBounds(50,75,30,30);
        FieldPointAy = new JTextField();
        FieldPointAy.setBounds(100,75,30,30);


        LabelProsta = new JLabel("Współrzędne Prostej");
        LabelProsta.setBounds(200,20,150,50);
        LabelProsta.setFont(new Font("Arial",Font.BOLD,15));
        LabelProstaA = new JLabel("y=");

        LabelProstaA.setBounds(205,80,50,20);
        LabelProstaA.setFont(new Font("Arial",Font.BOLD,20));
        FieldProstaX = new JTextField();
        FieldProstaX.setBounds(230,75,30,30);
        LabelProstaB = new JLabel("x +");

        LabelProstaB.setBounds(260,80,50,20);
        LabelProstaB.setFont(new Font("Arial",Font.BOLD,20));
        FieldProstaY = new JTextField();
        FieldProstaY.setBounds(300,75,30,30);


        buttonCount = new JButton("Policz");
        buttonCount.setBounds(145,140,100,30);
        buttonCount.addActionListener(this);


        buttonHelp = new JButton("Pomoc");
        buttonHelp.setBounds(145,180,100,30);
        buttonHelp.addActionListener(this);


        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(145,320,100,30);
        buttonReturn.addActionListener(this);


        LabelOdleglosc = new JLabel("Oglełość wynosi:");
        LabelOdleglosc.setBounds(135,220,390,30);
        LabelOdleglosc.setFont(new Font("Arial",Font.BOLD,15));
        LabelResultOdleglosc = new JLabel("", SwingConstants.CENTER);
        LabelResultOdleglosc.setBounds(10,250,390,30);
        LabelResultOdleglosc.setFont(new Font("Arial",Font.BOLD,15));



        frame.add(LabelPointA);
        frame.add(FieldPointAx);
        frame.add(FieldPointAy);
        frame.add(LabelProsta);
        frame.add(FieldProstaX);
        frame.add(FieldProstaY);
        frame.add(buttonCount);
        frame.add(buttonHelp);
        frame.add(buttonReturn);

        frame.add(LabelProstaA);
        frame.add(LabelProstaB);
        frame.add(LabelOdleglosc);
        frame.add(LabelResultOdleglosc);

    }

    public void run()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == buttonReturn)
        {
            frame.dispose();
        }

        if(source == buttonCount)
        {
            double Xa, Ya, A, B, D;

            Xa = Float.parseFloat(FieldPointAx.getText());
            Ya = Float.parseFloat(FieldPointAy.getText());
            A = Float.parseFloat(FieldProstaX.getText());
            B = Float.parseFloat(FieldProstaY.getText());

            D = Math.abs((Xa*-A+Ya-B)/Math.sqrt((A*A)+1));
            LabelResultOdleglosc.setText(String.valueOf(D));


        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "Program za pomocą wzoru |Ax + By + C|/√(A2+B2) oblicza ogległość punktu od prostej.\n" +
                    "By = Ax + C -->  Ax + By + C = 0");
        }

    }
}
