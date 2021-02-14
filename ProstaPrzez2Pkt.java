import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProstaPrzez2Pkt implements ActionListener
{
    private JFrame frame;
    private JLabel LabelPointA, LabelPointB, LabelResult;
    private JTextField FieldPointAx, FieldPointAy, FieldPointBx, FieldPointBy;
    private JButton buttonCount, buttonReturn, buttonHelp;


    public ProstaPrzez2Pkt()
    {
        frame = new JFrame("Rownania Prostej przechodzącej przez 2 pkt");
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LabelPointA = new JLabel("Punkt A (X,Y)");
        LabelPointA.setBounds(50,20,100,50);
        LabelPointA.setFont(new Font("Arial",Font.BOLD,15));
        FieldPointAx = new JTextField();
        FieldPointAx.setBounds(50,70,50,50);
        FieldPointAy = new JTextField();
        FieldPointAy.setBounds(100,70,50,50);

        LabelPointB = new JLabel("Punkt B (X,Y)");
        LabelPointB.setBounds(230,20,100,50);
        LabelPointB.setFont(new Font("Arial",Font.BOLD,15));
        FieldPointBx = new JTextField();
        FieldPointBx.setBounds(230,70,50,50);
        FieldPointBy = new JTextField();
        FieldPointBy.setBounds(280,70,50,50);

        buttonCount = new JButton("Policz");
        buttonCount.setBounds(145,150,100,30);
        buttonCount.addActionListener(this);

        buttonHelp = new JButton("Pomoc");
        buttonHelp.setBounds(145,190,100,30);
        buttonHelp.addActionListener(this);

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(145,320,100,30);
        buttonReturn.addActionListener(this);

        LabelResult = new JLabel("",SwingConstants.CENTER);
        LabelResult.setBounds(10,240,390,30);
        LabelResult.setFont(new Font("Arial",Font.BOLD,20));

        frame.add(LabelPointA);
        frame.add(FieldPointAx);
        frame.add(FieldPointAy);
        frame.add(LabelPointB);
        frame.add(FieldPointBx);
        frame.add(FieldPointBy);
        frame.add(buttonCount);
        frame.add(buttonHelp);
        frame.add(buttonReturn);
        frame.add(LabelResult);
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
            float Xa, Ya, Xb, Yb, A, B;

            Xa = Float.parseFloat(FieldPointAx.getText());
            Ya = Float.parseFloat(FieldPointAy.getText());
            Xb = Float.parseFloat(FieldPointBx.getText());
            Yb = Float.parseFloat(FieldPointBy.getText());

            A = (Ya-Yb)/(Xa-Xb);
            System.out.println(Xa+","+Ya+", sd "+Xb+","+Yb);
            B = (Ya - ((Ya-Yb)/(Xa-Xb))*Xa);
            LabelResult.setText("y = "+A+"x + "+B);
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "Program wyznaczy równanie prostej, którza będzie przechodzić przez podane 2 punkty");
        }

    }
}
