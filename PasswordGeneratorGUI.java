import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordGeneratorGUI extends JFrame{
    private PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI() {
        super("Password Generator");
        setSize(550,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        int hexColor = Integer.parseInt("D7E9FE", 16);
        Color backgroundColor = new Color(hexColor);
        getContentPane().setBackground(backgroundColor);
        passwordGenerator = new PasswordGenerator();
        addguicomponents();
    }
    void addguicomponents() {
        JLabel jl = new JLabel("Password Generator");
        jl.setFont(new Font("Times New Roman", Font.ITALIC, 32));
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setBounds(0, 10, 540, 39);
        jl.setForeground(Color.decode("#2F4B26"));
        add(jl);

        JTextArea ta=new JTextArea();
        ta.setEditable(false);
        ta.setFont(new Font("Dialog", Font.PLAIN, 32));

        JScrollPane sc=new JScrollPane(ta);
        sc.setBounds(25,97,479,70);
        sc.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(sc);

        JLabel jl2=new JLabel("Password Length: ");
        jl2.setFont(new Font("Times New Roman",Font.PLAIN,32));
        jl2.setBounds(25,215,272,39);
        jl2.setForeground(Color.decode("#2F4B26"));
        add(jl2);

        JTextArea ta2=new JTextArea();
        ta2.setFont(new Font("Ariel",Font.PLAIN,32));
        ta2.setBounds(310,215,192,39);
        ta2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(ta2);

        JToggleButton uppercase=new JToggleButton("Uppercase");
        uppercase.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        uppercase.setBounds(25, 302, 225, 56);
        uppercase.setForeground(Color.decode("#2F4B26"));
        add(uppercase);

        JToggleButton lowercase=new JToggleButton("Lowercase");
        lowercase.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        lowercase.setBounds(282, 302, 225, 56);
        lowercase.setForeground(Color.decode("#2F4B26"));
        add(lowercase);

        JToggleButton numbers=new JToggleButton("Numbers");
        numbers.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        numbers.setBounds(25, 373, 225, 56);
        numbers.setForeground(Color.decode("#2F4B26"));
        add(numbers);

        JToggleButton symbols=new JToggleButton("Symbols");
        symbols.setFont(new Font("Times New Roman", Font.PLAIN, 26));
        symbols.setBounds(282, 373, 225, 56);
        symbols.setForeground(Color.decode("#2F4B26"));
        add(symbols);

        JToggleButton generate=new JToggleButton("Generate");
        generate.setBounds(155, 477, 222, 41);
        generate.setFont(new Font("Times New Roman",Font.PLAIN,32));
        generate.setForeground(Color.decode("#2F4B26"));

        generate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 if (ta2.getText().length()<=0) return;
                 boolean anytoggleselected=lowercase.isSelected() ||
                         uppercase.isSelected()||
                         numbers.isSelected() ||
                         symbols.isSelected();
                 int passwordlength=Integer.parseInt(ta2.getText());
                 if(anytoggleselected){
                     String generatedpassword = passwordGenerator.passwordgen(passwordlength,
                             uppercase.isSelected(),
                             lowercase.isSelected(),
                             numbers.isSelected(),
                             symbols.isSelected());
                     ta.setText(generatedpassword);
                 }

            }
        });
        add(generate);
    }
}
