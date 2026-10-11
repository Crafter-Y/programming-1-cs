package swing;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

// JTextField: single line text input. JPasswordField: hides the input.
public class TextFields extends JFrame {
    public TextFields() {
        super("Text Fields");
        this.setLayout(new GridLayout(0, 2, 5, 5));

        // the number is the width in columns (characters), not a max length
        JTextField name = new JTextField(15);
        JTextField prefilled = new JTextField("prefilled text");
        JTextField readOnly = new JTextField("not editable");
        readOnly.setEditable(false);

        JPasswordField password = new JPasswordField(15);
        // password.setEchoChar('#'); // change the hiding character

        JTextField number = new JTextField("21");
        JLabel result = new JLabel();

        // ActionListener on a text field fires when ENTER is pressed
        name.addActionListener(e -> result.setText("Hello " + name.getText()));

        // reading numbers: parse the text and handle wrong input
        JButton calc = new JButton("Double the number");
        calc.addActionListener(e -> {
            try {
                int value = Integer.parseInt(number.getText().trim());
                // double: Double.parseDouble(text.replace(',', '.'))
                result.setText("Result: " + (value * 2));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Not a number!", "Error", JOptionPane.ERROR_MESSAGE);
                number.requestFocus();
                number.selectAll();
            }
        });

        // passwords: getPassword() returns char[] (getText() is deprecated for password fields)
        JButton login = new JButton("Check password");
        login.addActionListener(e -> {
            String pw = new String(password.getPassword());
            result.setText(pw.equals("secret") ? "Correct password" : "Wrong password");
        });

        // DocumentListener: react to every change while typing
        JLabel live = new JLabel("0 characters");
        prefilled.getDocument().addDocumentListener(new DocumentListener() {
            private void update() {
                live.setText(prefilled.getText().length() + " characters");
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
        });

        JButton clear = new JButton("Clear name");
        clear.addActionListener(e -> name.setText(""));

        this.add(new JLabel("Name (press Enter):"));
        this.add(name);
        this.add(new JLabel("Live counter:"));
        this.add(prefilled);
        this.add(live);
        this.add(readOnly);
        this.add(new JLabel("Password (secret):"));
        this.add(password);
        this.add(new JLabel("Number:"));
        this.add(number);
        this.add(calc);
        this.add(login);
        this.add(clear);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(TextFields::new);
    }
}
