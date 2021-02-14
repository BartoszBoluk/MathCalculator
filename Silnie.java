import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Silnie implements ActionListener
{
    private JFrame frame;
    private JButton buttonCount, buttonReturn, buttonHelp;
    private JTextField textField, textResult;
    private JLabel text1, text2;

    public Silnie()
    {
        frame = new JFrame("Silnie");
        frame.setSize(400,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        buttonCount = new JButton("Policz");
        buttonCount.setBounds(135,90,130,30);
        buttonCount.addActionListener(this);

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(160,220,80,20);
        buttonReturn.addActionListener((ActionListener) this);

        buttonHelp = new JButton("Czym jest Silnia?");
        buttonHelp.setBounds(135,150,130,30);
        buttonHelp.addActionListener((ActionListener) this);

        textField = new JTextField();
        textField.setBounds(20,40,160,20);

        text1 = new JLabel();
        text1.setText("Podaj liczbę N");
        text1.setBounds(60,10,100,20);

        textResult = new JTextField();
        textResult.setBounds(220,40,150,20);

        text2 = new JLabel();
        text2.setText("Wynik");
        text2.setBounds(280,10,100,20);


        frame.add(buttonCount);
        frame.add(buttonReturn);
        frame.add(textField);
        frame.add(textResult);
        frame.add(text1);
        frame.add(buttonHelp);
        frame.add(text2);
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
            int a = Integer.parseInt(textField.getText());
            long wynik=1;

            for(int i=2; i<=a; i++)
            {
                wynik*=i;
            }

            textResult.setText(String.valueOf(wynik));
        }

        if(source == buttonHelp)
        {
            JOptionPane.showMessageDialog(null, "Silnia liczby naturalnej N jest to iloczyn wszystkich liczb naturalnych dodatnich nie większych niż N.");
        }

    }
}
