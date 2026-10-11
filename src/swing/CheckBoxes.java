package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

// JCheckBox: independent on/off options (multiple can be selected at once)
public class CheckBoxes extends JFrame {
    public CheckBoxes() {
        super("Check Boxes");
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        JLabel result = new JLabel("Toppings: ");

        JCheckBox cheese = new JCheckBox("Cheese", true); // initially checked
        JCheckBox ham = new JCheckBox("Ham");
        JCheckBox mushrooms = new JCheckBox("Mushrooms");
        JCheckBox[] boxes = { cheese, ham, mushrooms };

        // read all states when something changes
        for (JCheckBox box : boxes) {
            box.addActionListener(e -> {
                List<String> selected = new ArrayList<>();
                for (JCheckBox b : boxes) {
                    if (b.isSelected()) selected.add(b.getText());
                }
                result.setText("Toppings: " + String.join(", ", selected));
            });
            this.add(box);
        }

        // ItemListener tells you if it was selected or deselected
        JCheckBox agree = new JCheckBox("I accept the terms");
        JButton order = new JButton("Order");
        order.setEnabled(false);
        agree.addItemListener(e -> order.setEnabled(e.getStateChange() == ItemEvent.SELECTED));

        // set state by code
        JButton reset = new JButton("Uncheck all");
        reset.addActionListener(e -> {
            for (JCheckBox b : boxes) b.setSelected(false);
            result.setText("Toppings: ");
        });

        this.add(result);
        this.add(agree);
        this.add(order);
        this.add(reset);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(CheckBoxes::new);
    }
}
