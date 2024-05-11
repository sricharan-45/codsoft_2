import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="WordCounter.class" height=500 width=1000></applet>*/
public class WordCounter extends Applet implements ActionListener, KeyListener {
    private TextArea inputArea;
    private Label countLabel;
    private Button clearButton;
    private Label enterTextLabel;

    public void init() {
        setLayout(new BorderLayout(5, 5));
        setBackground(Color.WHITE);
        Panel headingPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        headingPanel.setBackground(Color.WHITE);
        Label headingLabel = new Label("Sricharan's Word Counter");
        headingLabel.setForeground(Color.RED);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        Panel inputPanel = new Panel(new BorderLayout());
        inputPanel.setBackground(Color.WHITE);
        inputArea = new TextArea(4, 30);
        inputArea.setFont(new Font("Arial", Font.PLAIN, 22));
        inputArea.addKeyListener(this);
        inputArea.setFont(new Font("Arial", Font.BOLD, 20));
        inputPanel.add(inputArea, BorderLayout.CENTER);

        enterTextLabel = new Label("Please enter text");
        enterTextLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        enterTextLabel.setForeground(Color.GRAY);
        inputPanel.add(enterTextLabel, BorderLayout.NORTH);
        
        add(inputPanel, BorderLayout.CENTER);

        Panel labelPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(Color.WHITE);
        
        countLabel = new Label("Total words: 0");
        countLabel.setForeground(Color.BLUE);
        countLabel.setAlignment(Label.LEFT);
        countLabel.setFont(new Font("Arial", Font.BOLD, 24));
        labelPanel.add(countLabel);
        
        clearButton = new Button("Clear");
        clearButton.setPreferredSize(new Dimension(100, 30));
        clearButton.addActionListener(this);
        labelPanel.add(new Label("   "));
        labelPanel.add(clearButton);
        labelPanel.add(new Label("   "));
        
        add(labelPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            inputArea.setText("");
            updateWordCount();
        }
    }

    public void keyTyped(KeyEvent e) {
        updateWordCount();
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    private void updateWordCount() {
        String inputText = inputArea.getText().trim();
        
        if (inputText.isEmpty()) {
            enterTextLabel.setVisible(true);
            countLabel.setText("Total words: 0");
            return;
        } else {
            enterTextLabel.setVisible(false);
        }
        
        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        countLabel.setText("Total words: " + wordCount);
    }
}
