import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DwumianNewtona implements ActionListener
{
    private JFrame frame;
    private JButton buttonCount, buttonReturn, buttonHelp;
    private JTextField textField, textField2;
    private JLabel text1, text2, LabelResult;

    public DwumianNewtona()
    {
        frame = new JFrame("Dwumian Newtona");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        buttonCount = new JButton("Policz");
        buttonCount.setBounds(135,90,130,30);
        buttonCount.addActionListener(this);

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(160,320,80,20);
        buttonReturn.addActionListener((ActionListener) this);

        buttonHelp = new JButton("Czym jest Dwumian?");
        buttonHelp.setBounds(135,150,130,30);
        buttonHelp.addActionListener((ActionListener) this);

        textField = new JTextField();
        textField.setBounds(20,40,160,20);

        text1 = new JLabel();
        text1.setText("Podaj N");
        text1.setBounds(60,10,100,20);

        textField2 = new JTextField();
        textField2.setBounds(220,40,150,20);

        text2 = new JLabel();
        text2.setText("Podaj K");
        text2.setBounds(280,10,100,20);

        LabelResult = new JLabel("", SwingConstants.CENTER);
        LabelResult.setBounds(135,200,130,30);


        frame.add(buttonCount);
        frame.add(buttonReturn);
        frame.add(textField);
        frame.add(textField2);
        frame.add(text1);
        frame.add(buttonHelp);
        frame.add(text2);
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

            int n = Integer.parseInt(textField.getText());
            int k = Integer.parseInt(textField2.getText());

            if(n<k)
            {
                n=k;
                textField.setText(String.valueOf(n));

                long SilniaK=1;
                long SilniaN=1;
                long SilniaNK=1;
                long wynik=0;

                for(int i=2; i<=n; i++)
                {
                    SilniaN*=i;
                }

                for(int i=2; i<=k; i++)
                {
                    SilniaK*=i;
                }

                for(int i=2; i<=(n-k); i++)
                {
                    SilniaNK*=i;
                }

                wynik = SilniaN/(SilniaK*SilniaNK);
                LabelResult.setText(String.valueOf(wynik));

            }
            else {

                long SilniaK = 1;
                long SilniaN = 1;
                long SilniaNK = 1;
                long wynik = 0;

                for (int i = 2; i <= n; i++) {
                    SilniaN *= i;
                }

                for (int i = 2; i <= k; i++) {
                    SilniaK *= i;
                }

                for (int i = 2; i <= (n - k); i++) {
                    SilniaNK *= i;
                }

                wynik = SilniaN / (SilniaK * SilniaNK);
                LabelResult.setText(String.valueOf(wynik));
            }
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "N nad K oznacza współczynnik dwumianowy i jest obliczany ze wzoru.");
        }

    }
}
