package swing;

import javax.swing.*;
import java.awt.*;

// JComboBox: drop-down list, one item can be selected. It is generic: JComboBox<String>, JComboBox<Integer>, ...
public class ComboBoxes extends JFrame {
    public ComboBoxes() {
        super("Combo Boxes");
        this.setLayout(new FlowLayout());

        String[] currencies = { "EUR", "USD", "GBP", "CHF" };
        JComboBox<String> combo = new JComboBox<>(currencies);
        combo.setSelectedIndex(1); // or combo.setSelectedItem("USD")

        JLabel result = new JLabel("Selected: USD");
        combo.addActionListener(e -> {
            String selected = (String) combo.getSelectedItem();
            result.setText("Selected: " + selected + " (index " + combo.getSelectedIndex() + ")");
        });

        // editable combo box: user can also type own values
        JComboBox<Integer> editable = new JComboBox<>(new Integer[] { 10, 20, 50 });
        editable.setEditable(true);

        // items can be added / removed later
        JTextField newItem = new JTextField(6);
        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            if (!newItem.getText().isBlank()) {
                combo.addItem(newItem.getText());
                newItem.setText("");
            }
        });
        JButton remove = new JButton("Remove selected");
        remove.addActionListener(e -> {
            if (combo.getSelectedIndex() >= 0) combo.removeItemAt(combo.getSelectedIndex());
        });

        // also possible with objects - the combo box shows toString()
        JComboBox<Planet> planets = new JComboBox<>(Planet.values());
        planets.addActionListener(e -> result.setText("Planet: " + planets.getSelectedItem()));

        this.add(combo);
        this.add(editable);
        this.add(newItem);
        this.add(add);
        this.add(remove);
        this.add(planets);
        this.add(result);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private enum Planet {
        MERCURY, VENUS, EARTH, MARS
    }

    public static void main() {
        SwingUtilities.invokeLater(ComboBoxes::new);
    }
}
