import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

public class Ciagi implements ActionListener {
    private JFrame frame;
    private JTextField FieldA1, FieldR, FieldN, FieldResultN, FieldResultSuma;
    private JLabel LabelTitle, LabelA1, LabelR, LabelN, LabelResultN, LabelResultSuma;
    private JButton buttonCount, buttonHelp, buttonReturn;


    public Ciagi()
    {
        frame = new JFrame("Ciągi Arytmetyczne");
        frame.setSize(400,400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        LabelTitle = new JLabel("Ciągi Arytmetyczne");
        LabelTitle.setBounds(120,1,200,50);
        LabelTitle.setFont(new Font("Arial", Font.BOLD, 18));

        LabelA1 = new JLabel("Podaj A1");
        LabelA1.setBounds(50,50,100,50);
        FieldA1 = new JTextField();
        FieldA1.setBounds(50,100,50,30);

        LabelR = new JLabel("Podaj R");
        LabelR.setBounds(172,50,100,50);
        FieldR = new JTextField();
        FieldR.setBounds(170,100,50,30);

        LabelN = new JLabel("Podaj N");
        LabelN.setBounds(292,50,100,50);
        FieldN = new JTextField();
        FieldN.setBounds(290,100,50,30);

        LabelResultN = new JLabel("N-ty wyraz ciągu");
        LabelResultN.setBounds(80,230,100,50);
        FieldResultN = new JTextField();
        FieldResultN.setBounds(100,270,50,30);

        LabelResultSuma = new JLabel("Suma N wyrazów");
        LabelResultSuma.setBounds(210,230,200,50);
        FieldResultSuma = new JTextField();
        FieldResultSuma.setBounds(230,270,50,30);

        buttonCount = new JButton("Policz");
        buttonCount.setBounds(145,150,100,30);
        buttonCount.addActionListener(this);

        buttonHelp = new JButton("Czym jest?");
        buttonHelp.setBounds(145,190,100,30);
        buttonHelp.addActionListener(this);

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(145,320,100,30);
        buttonReturn.addActionListener(this);

        frame.add(FieldA1);
        frame.add(LabelA1);
        frame.add(LabelTitle);
        frame.add(LabelR);
        frame.add(FieldR);
        frame.add(LabelN);
        frame.add(FieldN);
        frame.add(buttonCount);
        frame.add(FieldResultN);
        frame.add(FieldResultSuma);
        frame.add(LabelResultN);
        frame.add(LabelResultSuma);
        frame.add(buttonHelp);
        frame.add(buttonReturn);

    }

    public void run()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == buttonCount)
        {
            double a1, r, n, Nwyraz, SumaAr;
            a1 = Double.parseDouble(FieldA1.getText());
            r = Integer.parseInt(FieldR.getText());
            n = Integer.parseInt(FieldN.getText());

            Nwyraz = a1 + (n-1)*r;
            FieldResultN.setText(String.valueOf(Nwyraz));

            SumaAr = ((2*a1 + (n-1)*r)/2)*n;
            FieldResultSuma.setText(String.valueOf(SumaAr));
        }

        if(source == buttonReturn)
        {
            frame.dispose();
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "Ciąg arytmetyczny - to taki ciąg liczb, w którym każda kolejna liczba różni się od poprzedniej o ustaloną wartość r.\n" +
                    "Liczbę r nazywamy różnicą ciągu arytmetycznego.\nA1 to pierwszy wyraz ciągu.");
        }

    }
}
