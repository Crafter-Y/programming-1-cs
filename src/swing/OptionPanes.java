package swing;

import javax.swing.*;
import java.awt.*;

// JOptionPane: ready-made dialogs. They are modal = the code waits until the dialog is closed.
// The first parameter is the parent component (dialog is centered on it), null = center of screen.
public class OptionPanes extends JFrame {
    public OptionPanes() {
        super("Option Panes");
        this.setLayout(new GridLayout(0, 1, 5, 5));

        JLabel result = new JLabel("Result shows here", SwingConstants.CENTER);

        // 1. message dialog: just information
        // message types: PLAIN_MESSAGE, INFORMATION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE, QUESTION_MESSAGE
        JButton message = new JButton("showMessageDialog");
        message.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Hello!");
            JOptionPane.showMessageDialog(this, "Something went wrong", "Error", JOptionPane.ERROR_MESSAGE);
        });

        // 2. input dialog: returns the entered String, or null if cancelled
        JButton input = new JButton("showInputDialog");
        input.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(this, "What is your name?");
            if (name == null) {
                result.setText("Cancelled");
            } else {
                result.setText("Hello " + name);
            }
        });

        // input dialog with a drop-down of choices
        JButton choice = new JButton("showInputDialog (choices)");
        choice.addActionListener(e -> {
            String[] options = { "Java", "Python", "C" };
            Object selected = JOptionPane.showInputDialog(this, "Favorite language?", "Choose",
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            result.setText("Chosen: " + selected);
        });

        // 3. confirm dialog: returns YES_OPTION, NO_OPTION, CANCEL_OPTION or CLOSED_OPTION
        // option types: YES_NO_OPTION, YES_NO_CANCEL_OPTION, OK_CANCEL_OPTION
        JButton confirm = new JButton("showConfirmDialog");
        confirm.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm",
                    JOptionPane.YES_NO_CANCEL_OPTION);
            switch (answer) {
                case JOptionPane.YES_OPTION -> result.setText("Yes");
                case JOptionPane.NO_OPTION -> result.setText("No");
                case JOptionPane.CANCEL_OPTION -> result.setText("Cancel");
                default -> result.setText("Closed");
            }
        });

        // 4. option dialog: own buttons, returns the index of the clicked button (-1 if closed)
        JButton option = new JButton("showOptionDialog");
        option.addActionListener(e -> {
            String[] buttons = { "Rock", "Paper", "Scissors" };
            int index = JOptionPane.showOptionDialog(this, "Pick one", "Game",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);
            result.setText(index == -1 ? "Closed" : "You picked " + buttons[index]);
        });

        // the message can also be a component, e.g. a panel with several fields
        JButton custom = new JButton("Dialog with own components");
        custom.addActionListener(e -> {
            JTextField user = new JTextField();
            JPasswordField pass = new JPasswordField();
            Object[] fields = { "User:", user, "Password:", pass };
            int answer = JOptionPane.showConfirmDialog(this, fields, "Login", JOptionPane.OK_CANCEL_OPTION);
            if (answer == JOptionPane.OK_OPTION) result.setText("Logged in as " + user.getText());
        });

        this.add(message);
        this.add(input);
        this.add(choice);
        this.add(confirm);
        this.add(option);
        this.add(custom);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(OptionPanes::new);
    }
}
