 
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.util.Random; 
public class ArithmeticGameMar extends JFrame implements ActionListener { 
// Labels 
private JLabel lblTitle, lblRandom, lblOperation, lblLevel, lblScore, lblCorrect, lblWrong; 
private JTextField txtAnswer; 
private JButton btnSubmit; 
private JCheckBox addBox, subBox, mulBox, divBox; 
private JCheckBox level1Box, level2Box, level3Box; 
// Score counters 
private int correctScore = 0; 
private int wrongScore = 0; 
// Random numbers 
private int num1, num2, result; 
private String operation = "+"; 
private Random random = new Random(); 
public ArithmeticGameMar() { 
        // JFrame setup 
        setTitle("Arithmetic Game"); 
        setSize(600, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setLayout(null); 
        setLocationRelativeTo(null); 
 
        // Title Label 
        lblTitle = new JLabel("Arithmetic Game", SwingConstants.CENTER); 
        lblTitle.setFont(new Font("Arial", Font.BOLD, 22)); 
        lblTitle.setBounds(150, 10, 300, 30); 
        add(lblTitle); 
 
        // Random Number Display 
        lblRandom = new JLabel("", SwingConstants.CENTER); 
        lblRandom.setFont(new Font("Arial", Font.BOLD, 26)); 
        lblRandom.setBounds(150, 60, 300, 50); 
        add(lblRandom); 
 
        // Operation Box 
        lblOperation = new JLabel("OPERATION:"); 
        lblOperation.setBounds(50, 130, 100, 25); 
        add(lblOperation); 
 
        addBox = new JCheckBox("Addition"); 
        subBox = new JCheckBox("Subtraction"); 
        mulBox = new JCheckBox("Multiplication"); 
        divBox = new JCheckBox("Division"); 
 
        addBox.setBounds(50, 160, 100, 25); 
        subBox.setBounds(50, 190, 100, 25); 
        mulBox.setBounds(50, 220, 120, 25); 
        divBox.setBounds(50, 250, 100, 25); 
 
        ButtonGroup operationGroup = new ButtonGroup(); 
        operationGroup.add(addBox); 
        operationGroup.add(subBox); 
        operationGroup.add(mulBox); 
        operationGroup.add(divBox); 
 
        add(addBox); 
        add(subBox); 
        add(mulBox); 
        add(divBox); 
 
        // Level Box 
        lblLevel = new JLabel("LEVEL:"); 
        lblLevel.setBounds(400, 130, 100, 25); 
        add(lblLevel); 
 
        level1Box = new JCheckBox("Level 1 (1–100)"); 
        level2Box = new JCheckBox("Level 2 (101–500)"); 
        level3Box = new JCheckBox("Level 3 (501–1000)"); 
 
        level1Box.setBounds(400, 160, 150, 25); 
        level2Box.setBounds(400, 190, 150, 25); 
        level3Box.setBounds(400, 220, 150, 25); 
 
        ButtonGroup levelGroup = new ButtonGroup(); 
        levelGroup.add(level1Box); 
        levelGroup.add(level2Box); 
        levelGroup.add(level3Box); 
 
        add(level1Box); 
        add(level2Box); 
        add(level3Box); 
 
        // Score Box 
        lblScore = new JLabel("SCORE:"); 
        lblScore.setBounds(250, 320, 100, 25); 
        add(lblScore); 
 
        lblCorrect = new JLabel("Correct: 0"); 
        lblCorrect.setBounds(180, 350, 100, 25); 
        add(lblCorrect); 
 
        lblWrong = new JLabel("Wrong: 0"); 
        lblWrong.setBounds(320, 350, 100, 25); 
        add(lblWrong); 
 
        // Answer input 
        txtAnswer = new JTextField(); 
        txtAnswer.setBounds(230, 270, 120, 30); 
        add(txtAnswer); 
 
        // Submit button 
        btnSubmit = new JButton("Submit"); 
        btnSubmit.setBounds(240, 400, 100, 30); 
        add(btnSubmit); 
 
        btnSubmit.addActionListener(this); 
 
        // Generate the first question 
        generateQuestion(); 
    } 
 
    private void generateQuestion() { 
        int min = 1, max = 100; 
 
        if (level2Box.isSelected()) { min = 101; max = 500; } 
        else if (level3Box.isSelected()) { min = 501; max = 1000; } 
 
        num1 = random.nextInt(max - min + 1) + min; 
        num2 = random.nextInt(max - min + 1) + min; 
 
        if (addBox.isSelected()) { 
            operation = "+"; 
            result = num1 + num2; 
        } else if (subBox.isSelected()) { 
            operation = "-"; 
            result = num1 - num2; 
        } else if (mulBox.isSelected()) { 
            operation = "×"; 
            result = num1 * num2; 
        } else if (divBox.isSelected()) { 
            operation = "÷"; 
            // Ensure division gives whole number 
            result = num1; 
            num1 = num1 * num2; 
        } else { 
            operation = "+"; 
            result = num1 + num2; 
        } 
 
        lblRandom.setText(num1 + " " + operation + " " + num2 + " = ?"); 
        txtAnswer.setText(""); 
    } 
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        try { 
            int answer = Integer.parseInt(txtAnswer.getText()); 
            if (answer == result) { 
                correctScore++; 
                lblCorrect.setText("Correct: " + correctScore); 
                JOptionPane.showMessageDialog(this, "Congratulations!", "Result", 
JOptionPane.INFORMATION_MESSAGE); 
            } else { 
                wrongScore++; 
                lblWrong.setText("Wrong: " + wrongScore); 
                JOptionPane.showMessageDialog(this, "Try again next time!", "Result", 
JOptionPane.ERROR_MESSAGE); 
            } 
            generateQuestion(); 
        } catch (NumberFormatException ex) { 
            JOptionPane.showMessageDialog(this, "Please enter a valid number!"); 
        } 
    } 
 
    public static void main(String[] args) { 
        SwingUtilities.invokeLater(() -> new ArithmeticGameMar().setVisible(true)); 
    } 
} 