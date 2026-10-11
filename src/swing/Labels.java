package swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

// JLabel displays text and/or an icon. The user cannot edit it.
public class Labels extends JFrame {
    public Labels() {
        super("Labels");
        this.setLayout(new GridLayout(0, 1, 5, 5));

        JLabel simple = new JLabel("Simple label");
        this.add(simple);

        // horizontal alignment: SwingConstants.LEFT / CENTER / RIGHT
        JLabel centered = new JLabel("Centered label", SwingConstants.CENTER);
        this.add(centered);

        // font and color
        JLabel styled = new JLabel("Big red bold label");
        styled.setFont(new Font("Arial", Font.BOLD, 20));
        styled.setForeground(Color.RED);
        this.add(styled);

        // background color only shows if the label is opaque
        JLabel withBackground = new JLabel("Label with background");
        withBackground.setOpaque(true);
        withBackground.setBackground(Color.YELLOW);
        this.add(withBackground);

        // HTML works in labels (and buttons) -> multiline text, formatting
        JLabel html = new JLabel("<html>Line one<br><b>bold</b> and <i>italic</i></html>");
        this.add(html);

        // ImageIcon: normally new ImageIcon("path/to/image.png"). Here we draw one so it runs without a file.
        JLabel withIcon = new JLabel("Label with icon", createIcon(Color.GREEN), SwingConstants.LEFT);
        this.add(withIcon);

        // text can be changed later (e.g. in an event listener)
        JLabel changing = new JLabel();
        changing.setText("Text set with setText()");
        System.out.println("Label text: " + changing.getText());
        this.add(changing);

        // tooltip = text shown when hovering
        simple.setToolTipText("I am a tooltip");

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static ImageIcon createIcon(Color color) {
        BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.fillOval(0, 0, 16, 16);
        g.dispose();
        return new ImageIcon(image);
    }

    public static void main() {
        SwingUtilities.invokeLater(Labels::new);
    }
}
