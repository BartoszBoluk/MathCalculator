import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info implements ActionListener {
    private JFrame frame;
    private JLabel LabelInfo, LabelInfo2;
    private JButton buttonReturn;

    public Info()
    {
        frame = new JFrame("O Programie");
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        LabelInfo = new JLabel("Program oblicza typowe maturalne działania matematyczne");
        LabelInfo.setBounds(5,10,380,30);
        LabelInfo.setFont(new Font("Arial",Font.PLAIN,14));

        LabelInfo2 = new JLabel("Wykonał: Bartosz Boluk                                 Wersja: 1.0");
        LabelInfo2.setBounds(10,70,380,30);
        LabelInfo2.setFont(new Font("Arial",Font.PLAIN,14));

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(150,110,100,30);
        buttonReturn.addActionListener(this);

        frame.add(LabelInfo);
        frame.add(LabelInfo2);
        frame.add(buttonReturn);
    }

    public void run()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == buttonReturn)
        {
            frame.dispose();
        }
    }
}
