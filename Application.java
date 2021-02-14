import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Application implements ActionListener
{
    private JFrame frame;
    private JButton buttonCalculator, buttonRownanieKwad, buttonSilnia, buttonExit, buttonCiagiAr, buttonCiagiGeo, buttonProste, buttonProste2, buttonPointsDistance,
            buttonDwumian, buttonInfo, buttonPochodne;
    private JLabel LabelTitle;


    public Application()
    {
        frame = new JFrame("Math Calculator");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        LabelTitle = new JLabel("Kalkulator do działań matematycznych", SwingConstants.CENTER);
        LabelTitle.setBounds(10,10,780,40);
        LabelTitle.setFont(new Font("Arial", Font.BOLD,30));

        buttonCalculator = new JButton("Kalkulator");
        buttonCalculator.setBounds(50,80,200,100);
        buttonCalculator.addActionListener((ActionListener) this);

        buttonRownanieKwad = new JButton("Rownanie Kwadratowe");
        buttonRownanieKwad.setBounds(50,200,200,100);
        buttonRownanieKwad.addActionListener((ActionListener) this);

        buttonSilnia = new JButton("Silnie");
        buttonSilnia.setBounds(50,320,200,100);
        buttonSilnia.addActionListener((ActionListener) this);

        buttonExit = new JButton("Wyjście");
        buttonExit.setBounds(300,440,200,100);
        buttonExit.setFont(new Font("Arial",Font.BOLD,20));
        buttonExit.addActionListener((ActionListener) this);

        buttonCiagiAr = new JButton("Ciągi Arytmetyczne");
        buttonCiagiAr.setBounds(300,80,200,100);
        buttonCiagiAr.addActionListener((ActionListener) this);

        buttonCiagiGeo = new JButton("Ciągi Geometryczne");
        buttonCiagiGeo.setBounds(300,200,200,100);
        buttonCiagiGeo.addActionListener((ActionListener) this);

        buttonProste = new JButton("Równania Prostych przechodzących przez 2 pkt");
        buttonProste.setBounds(300,320,200,100);
        buttonProste.addActionListener((ActionListener) this);

        buttonProste2 = new JButton("Równania Prostych Równoległych/Prostopadłych");
        buttonProste2.setBounds(550,80,200,100);
        buttonProste2.addActionListener((ActionListener) this);

        buttonPointsDistance = new JButton("Odległość Punktów od prostej");
        buttonPointsDistance.setBounds(550,200,200,100);
        buttonPointsDistance.addActionListener((ActionListener) this);

        buttonDwumian = new JButton("Dwumian Newtona");
        buttonDwumian.setBounds(550,320,200,100);
        buttonDwumian.addActionListener((ActionListener) this);

        buttonInfo = new JButton("O Programie");
        buttonInfo.setBounds(550,440,200,100);
        buttonInfo.addActionListener((ActionListener) this);

        buttonPochodne = new JButton("Pochodne");
        buttonPochodne.setBounds(50,440,200,100);
        buttonPochodne.addActionListener((ActionListener) this);

        frame.add(buttonCalculator);
        frame.add(buttonRownanieKwad);
        frame.add(buttonSilnia);
        frame.add(buttonExit);
        frame.add(buttonCiagiAr);
        frame.add(buttonCiagiGeo);
        frame.add(buttonProste);
        frame.add(buttonProste2);
        frame.add(buttonPointsDistance);
        frame.add(buttonDwumian);
        frame.add(LabelTitle);
        frame.add(buttonInfo);
        frame.add(buttonPochodne);
    }

    public void run()
    {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();

        if(source == buttonExit)
        {
            frame.dispose();
        }

        if(source == buttonCalculator)
        {
            Calculator c1 = new Calculator();
            c1.run();
        }

        if(source == buttonSilnia)
        {
            Silnie s1 = new Silnie();
            s1.run();
        }

        if(source == buttonRownanieKwad)
        {
            RownanieKwadratowe r1 = new RownanieKwadratowe();
            r1.run();
        }

        if(source == buttonCiagiAr)
        {
            Ciagi c1 = new Ciagi();
            c1.run();;
        }

        if(source == buttonCiagiGeo)
        {
            CiagiGeometryczne c2 = new CiagiGeometryczne();
            c2.run();
        }

        if(source == buttonProste)
        {
            ProstaPrzez2Pkt p1 = new ProstaPrzez2Pkt();
            p1.run();
        }

        if(source == buttonProste2)
        {
            ProsteRownProst p1 = new ProsteRownProst();
            p1.run();
        }

        if(source == buttonPointsDistance)
        {
            OdleglosciPunktow o1 = new OdleglosciPunktow();
            o1.run();
        }

        if(source == buttonDwumian)
        {
            DwumianNewtona d1 = new DwumianNewtona();
            d1.run();
        }

        if(source == buttonInfo)
        {
            Info i1 = new Info();
            i1.run();
        }

        if(source == buttonPochodne)
        {
//            Pochodne p1 = new Pochodne();
//            p1.run();
        }

    }
}
