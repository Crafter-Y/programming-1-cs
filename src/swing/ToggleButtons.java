package swing;

import javax.swing.*;
import java.awt.*;

// JToggleButton stays pressed after a click (on/off). JCheckBox and JRadioButton are subclasses of it.
public class ToggleButtons extends JFrame {
    public ToggleButtons() {
        super("Toggle Buttons");
        this.setLayout(new FlowLayout());

        JLabel status = new JLabel("Light is off");

        JToggleButton light = new JToggleButton("Light");
        light.addActionListener(e -> status.setText(light.isSelected() ? "Light is on" : "Light is off"));

        // ItemListener is called whenever the selected state changes (also when changed by code)
        JToggleButton bold = new JToggleButton("Bold", true); // initially selected
        bold.addItemListener(e -> status.setFont(status.getFont().deriveFont(bold.isSelected() ? Font.BOLD : Font.PLAIN)));

        // toggle buttons can also be grouped (only one selected), see RadioButtons
        JToggleButton left = new JToggleButton("Left");
        JToggleButton right = new JToggleButton("Right");
        ButtonGroup group = new ButtonGroup();
        group.add(left);
        group.add(right);
        left.setSelected(true);

        this.add(light);
        this.add(bold);
        this.add(left);
        this.add(right);
        this.add(status);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(400, 100);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ToggleButtons::new);
    }
}
