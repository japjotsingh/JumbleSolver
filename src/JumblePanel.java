import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class JumblePanel extends JPanel {

    LanguageMap map;
    JTextField word1 = new JTextField(10);

    public JumblePanel(LanguageMap m) {
        map = m;
        this.setBackground(new Color(0, 255, 138));// just to make sure we can change...
        init();
    }

    public void init() {
        JButton w1 = new JButton();
        w1.setBounds(10, 10, 20, 10);
        w1.setText("Solve!");
        w1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(word1.getText());
                // call the function for unscrambling
            }
        });
        add(w1);
        add(word1);
    }


}
