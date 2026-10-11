package swing;

import javax.swing.*;
import java.awt.*;

// JSlider: choose a number in a range by dragging. Uses a ChangeListener instead of an ActionListener.
public class Sliders extends JFrame {
    public Sliders() {
        super("Sliders");
        this.setLayout(new BorderLayout());

        // orientation, min, max, initial value
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        // slider.setSnapToTicks(true);

        JLabel value = new JLabel("Value: 50", SwingConstants.CENTER);
        value.setFont(new Font("Arial", Font.BOLD, 50));

        slider.addChangeListener(e -> {
            value.setText("Value: " + slider.getValue());
            value.setFont(value.getFont().deriveFont((float) (10 + slider.getValue())));
            // slider.getValueIsAdjusting() is true while the user is still dragging
        });

        JSlider vertical = new JSlider(JSlider.VERTICAL, 0, 255, 0);
        vertical.addChangeListener(e -> value.setForeground(new Color(vertical.getValue(), 0, 0)));

        this.add(slider, BorderLayout.SOUTH);
        this.add(vertical, BorderLayout.WEST);
        this.add(value, BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Sliders::new);
    }
}
