import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProsteRownProst implements ActionListener
{
    private JFrame frame;
    private JLabel LabelPointA, LabelProsta, LabelProstaA, LabelProstaB, LabelProstopadla, LabelRownolegla, LabelResultProst, LabelResultRowno;
    private JTextField FieldPointAx, FieldPointAy, FieldProstaX, FieldProstaY;
    private JButton buttonCount, buttonReturn, buttonHelp;


    public ProsteRownProst()
    {
        frame = new JFrame("Rownania Prostej równloległej/prostopadłej");
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


        LabelProstopadla = new JLabel("Prosta Prostopadła");
        LabelProstopadla.setBounds(10,220,150,30);
        LabelProstopadla.setFont(new Font("Arial",Font.BOLD,15));
        LabelResultProst = new JLabel("");
        LabelResultProst.setBounds(10,250,150,30);
        LabelResultProst.setFont(new Font("Arial",Font.BOLD,15));

        LabelRownolegla = new JLabel("Prosta Równoległa");
        LabelRownolegla.setBounds(240,220,150,30);
        LabelRownolegla.setFont(new Font("Arial",Font.BOLD,15));
        LabelResultRowno = new JLabel("");
        LabelResultRowno.setBounds(240,250,150,30);
        LabelResultRowno.setFont(new Font("Arial",Font.BOLD,15));


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
        frame.add(LabelProstopadla);
        frame.add(LabelRownolegla);
        frame.add(LabelResultRowno);
        frame.add(LabelResultProst);
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
            float Xa, Ya, A, B, Rowno, Prosto;

            Xa = Float.parseFloat(FieldPointAx.getText());
            Ya = Float.parseFloat(FieldPointAy.getText());
            A = Float.parseFloat(FieldProstaX.getText());
            B = Float.parseFloat(FieldProstaY.getText());

            Rowno = Ya - Xa*A;
            LabelResultRowno.setText("y = "+A+"x + "+Rowno);

            Prosto = Ya - Xa*(-1/A);
            LabelResultProst.setText("y = "+-1/A+"x + "+Prosto);
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "y = a1*x + b       y = a2*x + b\n" +
                    "W przypadku prostej równoległej przechodzącej przez Punkt A(x,y) współczynniki kierunkowe są równe a1 = a2.\n" +
                    "W przypadku prostej prostopadłej współczynnik kierunkowy a1*a2 = -1");
        }

    }
}
