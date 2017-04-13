import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
import java.util.Set;

import javax.swing.*;


public class JumblePanel extends JPanel {

    LanguageMap map;
    JTextField word1 = new JTextField(10);
    Map<String, String> langMap = new HashMap<String, String>();

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
//                System.out.println(word1.getText());
                solve();
            }

        });
        add(w1);
        add(word1);
    }



    public void solve(){
//        String[] things = {"apple", "bob", "ham", "bob", "bacon"};
//        List<String> list = Arrays.asList(things);
//
//        Set<String> set = new HashSet<String>(list);
//        System.out.printf("%s ", set);

        //go through the entire dicitonary and add all the map shit
        initMap();
        String sol = langMap.get(alphabetize(word1.getText()));
        System.out.println("Unscambled Word: " + sol);
    }


    public void initMap(){
        try {
            FileReader file = new FileReader("src/language_files/English.txt");
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                langMap.put(alphabetize(line), line);
                line = reader.readLine();
            }

//            System.out.println(langMap.size());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public String alphabetize(String n){
        char[] chars = n.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        return sorted;
    }



}
