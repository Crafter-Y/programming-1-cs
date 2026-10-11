package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// JButton + the different ways to write an ActionListener (event handling)
public class Buttons extends JFrame {
    private final JLabel output = new JLabel("Click a button");
    private int counter = 0;

    public Buttons() {
        super("Buttons");
        this.setLayout(new FlowLayout());

        // 1. anonymous inner class
        JButton anonymous = new JButton("Anonymous class");
        anonymous.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("Anonymous class clicked");
            }
        });

        // 2. lambda (ActionListener is a functional interface -> only one method)
        JButton lambda = new JButton("Lambda");
        lambda.addActionListener(e -> output.setText("Lambda clicked " + (++counter) + " times"));

        // 3. separate (inner) class - useful if the listener is reused
        JButton separate = new JButton("Separate class");
        separate.addActionListener(new MyListener());

        // 4. one listener for multiple buttons: find out which one via getSource() or getActionCommand()
        JButton a = new JButton("A");
        JButton b = new JButton("B");
        ActionListener shared = e -> {
            JButton source = (JButton) e.getSource();
            output.setText("Shared listener, source: " + source.getText() + ", command: " + e.getActionCommand());
        };
        a.setActionCommand("command-a"); // default action command is the button text
        a.addActionListener(shared);
        b.addActionListener(shared);

        // enable / disable
        JButton disabled = new JButton("Disabled");
        disabled.setEnabled(false);
        JButton toggleEnabled = new JButton("Enable/Disable");
        toggleEnabled.addActionListener(e -> disabled.setEnabled(!disabled.isEnabled()));

        // mnemonic: Alt + C triggers the button
        JButton mnemonic = new JButton("Close (Alt+C)");
        mnemonic.setMnemonic(KeyEvent.VK_C);
        mnemonic.addActionListener(e -> this.dispose());

        // look: tooltip, colors, font, programmatic click
        lambda.setToolTipText("I count clicks");
        separate.setBackground(Color.ORANGE);
        separate.setFont(new Font("Arial", Font.ITALIC, 14));
        // lambda.doClick(); // simulates a click

        this.add(anonymous);
        this.add(lambda);
        this.add(separate);
        this.add(a);
        this.add(b);
        this.add(disabled);
        this.add(toggleEnabled);
        this.add(mnemonic);
        this.add(output);

        // the default button is triggered by pressing Enter
        this.getRootPane().setDefaultButton(lambda);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 150);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // inner (member) class - has access to the fields of Buttons
    private class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            output.setText("Separate class clicked");
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(Buttons::new);
    }
}
