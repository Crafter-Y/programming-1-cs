package swing;

import javax.swing.*;
import java.awt.*;

// Tool tips: small text that appears when hovering a component. Every JComponent has setToolTipText.
public class ToolTips extends JFrame {
    public ToolTips() {
        super("Tool Tips");
        this.setLayout(new FlowLayout());

        JButton button = new JButton("Hover me");
        button.setToolTipText("I am a tool tip");

        // HTML is allowed for multi-line tool tips
        JLabel label = new JLabel("Hover me too");
        label.setToolTipText("<html><b>Bold</b> tool tip<br>with two lines</html>");

        JTextField field = new JTextField(10);
        field.setToolTipText("Enter your name");

        // global settings via the ToolTipManager
        ToolTipManager.sharedInstance().setInitialDelay(100);  // ms until it appears
        ToolTipManager.sharedInstance().setDismissDelay(5000); // ms until it disappears

        this.add(button);
        this.add(label);
        this.add(field);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ToolTips::new);
    }
}
