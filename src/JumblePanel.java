import com.sun.codemodel.internal.JOp;

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
    JTextField word1 = new JTextField(10);
    Map<String, String> langMap = new HashMap<String, String>();

    public JumblePanel(LanguageMap m) {
        map = m;
        this.setBackground(new Color(0, 255, 138));// just to make sure we can change...
        init();
        initMap();
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

    List<String> multipleAnswers;

    public void solve(){
//        String[] things = {"apple", "bob", "ham", "bob", "bacon"};
//        List<String> list = Arrays.asList(things);
//
//        Set<String> set = new HashSet<String>(list);
//        System.out.printf("%s ", set);

        //go through the entire dicitonary and add all the map shit

        String sol = langMap.get(alphabetize(word1.getText()));

            multipleAnswers = Arrays.asList(sol.split("\\s*,\\s*"));
            String[] mA = new String[multipleAnswers.size()];
            for (int i = 0; i < multipleAnswers.size(); i++) {
                mA[i] = multipleAnswers.get(i);
            }
//        int ct = 0;
//        int nB = mA.length;
//        if(mA.length < 1) {
//            JButton b1 = new JButton(mA[ct]);
//        }
//        if(mA.length < 2) {
//            JButton b2 = new JButton(mA[ct + 1]);
//        }
//        if(mA.length < 3) {
//            JButton b3 = new JButton(mA[ct + 2]);
//        }
//        if(mA.length < 4) {
//            JButton b4 = new JButton(mA[ct + 3]);
//        }
//        if(mA.length < 5) {
//            JButton b5 = new JButton(mA[ct + 4]);
//        }
//        if(mA.length < 6) {
//            JButton b6 = new JButton(mA[ct + 5]);
//        }

//        setLayout(new GridLayout(2,3,3,3,));







//            int n = JOptionPane.showOptionDialog(null,
//                    "Pick one of the following",
//                    "Multiple Unscrambles",
//                    JOptionPane.YES_NO_OPTION,
//                    JOptionPane.QUESTION_MESSAGE,
//                    null,
//                    mA,
//                    mA[mA.length-1]);

//            System.out.println(mA[n]);
        System.out.println("Unscambled Word: " + sol);
        for(String s: multipleAnswers){
            System.out.println(s);
        }
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
