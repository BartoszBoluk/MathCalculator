import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.String.valueOf;

public class Calculator implements ActionListener
{
    private JFrame frame;
    private JTextField input, result;
    private JButton[][] button;
    private JButton[] buttonAction;
    private JButton buttonReturn;
    private int buttonNumber, counter;
    private double currentNumber, currentNumber2;
    private boolean Dodawanie, Odejmowanie, Mnozenie, Dzielenie, newNumber;
    private String currentText = "0", buttonValue;

    public Calculator()
    {

        Dodawanie = false;
        Odejmowanie = false;
        Mnozenie = false;
        Dzielenie = false;
        newNumber = true;

        buttonNumber = 1;
        currentNumber = 0;
        currentNumber2 = 0;
        counter = 0;

        frame = new JFrame("Kalkulator");
        frame.setSize(300,430);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        input = new JTextField("0");
        input.setBounds(15,10,250,50);

        result = new JTextField("0");
        result.setBounds(150,10,120,50);

        button = new JButton[4][4];


        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                button[j][i] = new JButton(valueOf(buttonNumber));
                button[j][i].setBounds(7+(j*70), 80+(i*70), 60, 60);
                button[j][i].addActionListener(this);
                frame.add(button[j][i]);
                buttonNumber++;
            }
        }

        buttonAction = new JButton[7];

        for(int i=0; i<4; i++)
        {
            buttonAction[i] = new JButton("o");
            buttonAction[i].setBounds(7+(3*70), 80+(i*70),60,60);
            buttonAction[i].addActionListener(this);
            frame.add(buttonAction[i]);
        }

        for(int i=4; i<7; i++)
        {
            buttonAction[i] = new JButton("0");
            buttonAction[i].setBounds(7+((i-4)*70), 80+(3*70),60,60);
            buttonAction[i].addActionListener(this);
            frame.add(buttonAction[i]);
        }

        buttonAction[0].setText("+");
        buttonAction[1].setText("-");
        buttonAction[2].setText("*");
        buttonAction[3].setText("/");
        buttonAction[4].setText("C");
        buttonAction[6].setText("√");

        buttonReturn = new JButton("Powrót");
        buttonReturn.setBounds(90,360,100,30);
        buttonReturn.addActionListener(this);


        frame.add(input);
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

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(source == button[j][i])
                {
                    if(newNumber == true)
                    {
                        buttonValue = button[j][i].getText();
                        currentText = buttonValue;
                        input.setText(buttonValue);
                        newNumber = false;
                    }
                    else
                    {
                        buttonValue = button[j][i].getText();
                        currentText += buttonValue;
                        input.setText(currentText);
                    }
                }

            }
        }

        if(source == buttonAction[5])
        {
            if (newNumber == true)
            {
                buttonValue = buttonAction[5].getText();
                currentText = buttonValue;
                input.setText(buttonValue);
                newNumber = false;
            }
            else
                {
                buttonValue = buttonAction[5].getText();
                currentText += buttonValue;
                input.setText(currentText);
            }
        }

        if(source == buttonAction[0])
        {
            if(Dodawanie == false)
            {
                Odejmowanie = false;
                Dodawanie = true;
                Mnozenie = false;
                Dzielenie = false;
                currentNumber2 = Double.parseDouble(input.getText());
                newNumber = true;
            }
            else
            {
                currentNumber = Double.parseDouble(input.getText());
                currentNumber2 += currentNumber;

                input.setText(String.valueOf(currentNumber2));
                newNumber = true;
            }
        }

        if(source == buttonAction[1])
        {
            if(Odejmowanie == false)
            {
                Dodawanie = false;
                Odejmowanie = true;
                currentNumber2 = Double.parseDouble(input.getText());
                newNumber = true;
            }
            else
            {
                currentNumber = Double.parseDouble(input.getText());
                currentNumber2 -= currentNumber;

                input.setText(String.valueOf(currentNumber2));
                newNumber = true;
            }
        }

        if(source == buttonAction[2])
        {
            if(Mnozenie == false)
            {
                Odejmowanie = false;
                Dodawanie = false;
                Mnozenie = true;
                Dzielenie = false;
                currentNumber2 = Double.parseDouble(input.getText());
                newNumber = true;
            }
            else
            {
                currentNumber = Double.parseDouble(input.getText());
                currentNumber2 *= currentNumber;

                input.setText(String.valueOf(currentNumber2));
                newNumber = true;
            }
        }

        if(source == buttonAction[3])
        {
            if(Dzielenie == false)
            {
                Odejmowanie = false;
                Dodawanie = false;
                Mnozenie = false;
                Dzielenie = true;
                currentNumber2 = Double.parseDouble(input.getText());
                newNumber = true;
            }
            else
            {
                currentNumber = Double.parseDouble(input.getText());
                currentNumber2 /= currentNumber;

                input.setText(String.valueOf(currentNumber2));
                newNumber = true;
            }
        }

        if(source == buttonAction[4])
        {
            input.setText("0");
            currentNumber2 = 0;
            currentText = "";
        }

        if(source == buttonAction[6])
        {
            currentNumber2 = Math.sqrt(currentNumber2);
            input.setText(String.valueOf(currentNumber2));
        }

        if(source == buttonReturn)
        {
            frame.dispose();
        }

    }
}
