import java.awt.Color;

import javax.swing.JPanel;


public class JumblePanel extends JPanel {

	LanguageMap map;
	public JumblePanel(LanguageMap map) {
		this.map = map;
		this.setBackground(new Color(0, 255, 138));// just to make sure we can change...
	}

	ComponentResizer cr = new ComponentResizer();
	JPanel mainPanel = new JPanel(null);
    f.add(mainPanel);

	JTextArea textArea = new JTextArea("Some text\nSome other text");
    cr.registerComponent(textArea);

    mainPanel.add(textArea);
    textArea.setBounds(50, 50, 150, 150);
	
}
 // jingo