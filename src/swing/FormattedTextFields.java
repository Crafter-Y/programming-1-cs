package swing;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// JFormattedTextField only accepts input matching a format (number, date, mask).
// Invalid input is reverted when the field loses focus.
public class FormattedTextFields extends JFrame {
    public FormattedTextFields() {
        super("Formatted Text Fields");
        this.setLayout(new GridLayout(0, 2, 5, 5));

        // numbers
        JFormattedTextField integer = new JFormattedTextField(NumberFormat.getIntegerInstance());
        integer.setValue(42);

        // currency (uses the system locale)
        JFormattedTextField money = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        money.setValue(9.99);

        // dates
        JFormattedTextField date = new JFormattedTextField(new SimpleDateFormat("dd.MM.yyyy"));
        date.setValue(new Date());

        // mask: # = digit, U = uppercase letter, L = lowercase letter, A = letter or digit, * = anything
        JFormattedTextField postalCode;
        try {
            MaskFormatter mask = new MaskFormatter("#####");
            mask.setPlaceholderCharacter('_');
            postalCode = new JFormattedTextField(mask);
        } catch (ParseException e) {
            postalCode = new JFormattedTextField();
        }

        JLabel result = new JLabel();
        JButton read = new JButton("Read values");
        JFormattedTextField finalPostalCode = postalCode;
        read.addActionListener(e -> {
            // getValue() returns the parsed object (Number, Date, String), getText() the raw text
            Number n = (Number) integer.getValue();
            result.setText("int=" + n.intValue() + ", money=" + money.getValue()
                    + ", plz=" + finalPostalCode.getValue());
        });

        this.add(new JLabel("Integer:"));
        this.add(integer);
        this.add(new JLabel("Currency:"));
        this.add(money);
        this.add(new JLabel("Date:"));
        this.add(date);
        this.add(new JLabel("Postal code (mask):"));
        this.add(postalCode);
        this.add(read);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(FormattedTextFields::new);
    }
}
