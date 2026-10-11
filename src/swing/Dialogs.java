package swing;

import javax.swing.*;
import java.awt.*;

// Own dialogs with JDialog (top-level window that belongs to a parent frame)
// and JWindow (top-level window WITHOUT title bar and border, e.g. splash screen).
// For simple dialogs see OptionPanes (JOptionPane).
public class Dialogs extends JFrame {
    public Dialogs() {
        super("Dialogs");
        this.setLayout(new FlowLayout());

        JLabel result = new JLabel("No input yet");

        JButton openDialog = new JButton("Open JDialog");
        openDialog.addActionListener(e -> {
            InputDialog dialog = new InputDialog(this);
            dialog.setVisible(true); // modal -> blocks here until the dialog is closed
            result.setText("Dialog returned: " + dialog.getInput());
        });

        JButton openWindow = new JButton("Open JWindow (2s)");
        openWindow.addActionListener(e -> {
            JWindow window = new JWindow(this);
            JLabel splash = new JLabel("Splash screen without border", SwingConstants.CENTER);
            splash.setOpaque(true);
            splash.setBackground(Color.ORANGE);
            window.add(splash);
            window.setSize(250, 100);
            window.setLocationRelativeTo(this);
            window.setVisible(true);
            // javax.swing.Timer: run something once after 2 seconds (on the EDT)
            Timer timer = new Timer(2000, ev -> window.dispose());
            timer.setRepeats(false);
            timer.start();
        });

        this.add(openDialog);
        this.add(openWindow);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // own dialog class: extends JDialog just like a frame extends JFrame
    private static class InputDialog extends JDialog {
        private String input = null;

        public InputDialog(JFrame parent) {
            super(parent, "My dialog", true); // parent, title, modal
            this.setLayout(new BorderLayout(5, 5));

            JTextField field = new JTextField(15);
            JButton ok = new JButton("OK");
            JButton cancel = new JButton("Cancel");

            ok.addActionListener(e -> {
                input = field.getText();
                this.dispose();
            });
            cancel.addActionListener(e -> this.dispose());

            JPanel buttons = new JPanel();
            buttons.add(ok);
            buttons.add(cancel);

            this.add(new JLabel("Enter something:"), BorderLayout.NORTH);
            this.add(field, BorderLayout.CENTER);
            this.add(buttons, BorderLayout.SOUTH);
            this.getRootPane().setDefaultButton(ok);

            this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            this.pack();
            this.setLocationRelativeTo(parent);
        }

        public String getInput() {
            return this.input;
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(Dialogs::new);
    }
}
