package swing;

import javax.swing.*;
import java.awt.*;

// JColorChooser: dialog to pick a color
public class ColorChoosers extends JFrame {
    public ColorChoosers() {
        super("Color Choosers");

        JPanel preview = new JPanel();
        preview.setBackground(Color.WHITE);

        // simple way: static dialog, returns the Color or null if cancelled
        JButton choose = new JButton("Choose background color...");
        choose.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Pick a color", preview.getBackground());
            if (color != null) {
                preview.setBackground(color);
            }
        });

        // a JColorChooser is also a normal component that can be embedded
        JColorChooser embedded = new JColorChooser(Color.BLACK);
        embedded.getSelectionModel().addChangeListener(e -> choose.setForeground(embedded.getColor()));

        this.add(choose, BorderLayout.NORTH);
        this.add(preview, BorderLayout.CENTER);
        this.add(embedded, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(650, 550);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(ColorChoosers::new);
    }
}
