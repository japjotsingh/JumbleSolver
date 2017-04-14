
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
import java.util.List;
import java.util.Set;

import javax.swing.*;


public class JumblePanel extends JPanel {

    LanguageMap map;
    //Text Fields for words
    JTextField word1 = new JTextField(10);
    JTextField word2 = new JTextField(10);
    JTextField word3 = new JTextField(10);
    JTextField word4 = new JTextField(10);
    //Labels for answers
    JLabel j1 = new JLabel();
    JLabel j2 = new JLabel();
    JLabel j3 = new JLabel();
    JLabel j4 = new JLabel();
    Map<String, String> langMap = new HashMap<String, String>();

    public JumblePanel(LanguageMap m) {
        map = m;
        this.setBackground(new Color(255,20,147));// just to make sure we can change...
        init();
        initMap();
    }

    public void init() {
    	setLayout(null);
    	
    	//Solve buttons
        JButton w1 = new JButton();
        JButton w2 = new JButton(); 
        JButton w3 = new JButton();
        JButton w4 = new JButton(); 
        //solve all button
        JButton solveAll = new JButton();
        
        // x,y width,height
        w1.setBounds(10, 10, 90, 20);
        w2.setBounds(10, 110, 90,20);
        w3.setBounds(10, 210, 90, 20);
        w4.setBounds(10, 310, 90,20);
        solveAll.setBounds(300, 10, 150, 90);
        
        j1.setBounds(0, 40, 500, 20);
        j2.setBounds(0, 140, 500, 20);
        j3.setBounds(0, 240, 500, 20);
        j4.setBounds(0, 340, 500, 20);
        
        word1.setBounds(110, 10, 90,20);
        word2.setBounds(110, 110, 90, 20);
        word3.setBounds(110, 210, 90,20);
        word4.setBounds(110, 310, 90, 20);
        
        w1.setText("Solve");
        w2.setText("Solve");
        w3.setText("Solve");
        w4.setText("Solve");
        
        solveAll.setText("Solve All");
        
        j1.setText("Unscrambled Word: ");
        j2.setText("Unscrambled Word: ");
        j3.setText("Unscrambled Word: ");
        j4.setText("Unscrambled Word: ");

        w1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(word1.getText());
                solve(j1, word1);
            }

        });
        w2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(word1.getText());

                solve(j2, word2);
            }

        });
        w3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(word1.getText());
                solve(j3, word3);
            }

        });
        w4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(word1.getText());

                solve(j4, word4);
            }

        });
        
        
        
        solveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println(word1.getText());
            	w1.doClick();
            	w2.doClick();
            	w3.doClick();
            	w4.doClick();
            }

        });
        
        add(w1);
        add(w2);
        add(w3);
        add(w4);
        
        add(solveAll);
        
        add(j1);
        add(j2);
        add(j3);
        add(j4);

        add(word1);
        add(word2);
        add(word3);
        add(word4);
    }

    List<String> multipleAnswers;

    public void solve(JLabel j, JTextField w){
//        String[] things = {"apple", "bob", "ham", "bob", "bacon"};
//        List<String> list = Arrays.asList(things);
//
//        Set<String> set = new HashSet<String>(list);
//        System.out.printf("%s ", set);

        //go through the entire dicitonary and add all the map shit

        String sol = langMap.get(alphabetize(w.getText()));

            multipleAnswers = Arrays.asList(sol.split("\\s*,\\s*"));
            String[] mA = new String[multipleAnswers.size()];
            for (int i = 0; i < multipleAnswers.size(); i++) {
                mA[i] = multipleAnswers.get(i);
            }
            
//            System.out.println(mA[n]);
//        System.out.println("Unscambled Word: " + sol);
//        for(String s: multipleAnswers){
//            System.out.printf(s + " ");
//        }
//        
        j.setText("Unscrambled Words: " + sol);
    }


    public void initMap(){
        try {
            FileReader file = new FileReader("src/language_files/English.txt");
            BufferedReader reader = new BufferedReader(file);

            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);
                if(langMap.get(alphabetize(line)) != null && !langMap.get(alphabetize(line)).isEmpty()){
                    String old = langMap.get(alphabetize(line));
                    langMap.put(alphabetize(line), old + ", " + line);
                }
                else{
                    langMap.put(alphabetize(line), line);
                }
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
