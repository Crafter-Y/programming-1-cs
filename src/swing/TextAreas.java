package swing;

import javax.swing.*;
import java.awt.*;

// JTextArea: multi-line plain text. Put it into a JScrollPane, otherwise there are no scrollbars.
public class TextAreas extends JFrame {
    public TextAreas() {
        super("Text Areas");

        JTextArea area = new JTextArea(10, 30); // rows, columns
        area.setLineWrap(true);        // wrap long lines
        area.setWrapStyleWord(true);   // wrap at word boundaries instead of in the middle of a word
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        area.setText("First line\n");
        area.append("Appended line\n"); // add text at the end

        JScrollPane scroll = new JScrollPane(area);

        JButton append = new JButton("Append");
        append.addActionListener(e -> area.append("Another line\n"));

        JButton count = new JButton("Count lines");
        count.addActionListener(e -> JOptionPane.showMessageDialog(this,
                "Lines: " + area.getLineCount() + "\nCharacters: " + area.getText().length()));

        JButton selected = new JButton("Show selection");
        selected.addActionListener(e -> JOptionPane.showMessageDialog(this, "Selected: " + area.getSelectedText()));

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> area.setText(""));

        JCheckBox editable = new JCheckBox("Editable", true);
        editable.addActionListener(e -> area.setEditable(editable.isSelected()));

        JPanel buttons = new JPanel();
        buttons.add(append);
        buttons.add(count);
        buttons.add(selected);
        buttons.add(clear);
        buttons.add(editable);

        this.add(scroll, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(TextAreas::new);
    }
}
