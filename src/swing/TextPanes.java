package swing;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

// JEditorPane: shows HTML (or RTF / plain text). JTextPane: text with styles (colors, bold, ...) per part.
public class TextPanes extends JFrame {
    public TextPanes() {
        super("Editor Pane / Text Pane");
        this.setLayout(new GridLayout(1, 2, 5, 5));

        // JEditorPane with HTML content
        JEditorPane editor = new JEditorPane();
        editor.setContentType("text/html");
        editor.setText("<html><h2>JEditorPane</h2><p>Shows <b>HTML</b> with <i>formatting</i>.</p>"
                + "<ul><li>one</li><li>two</li></ul></html>");
        editor.setEditable(false);

        // JTextPane with a StyledDocument
        JTextPane textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();

        SimpleAttributeSet red = new SimpleAttributeSet();
        StyleConstants.setForeground(red, Color.RED);
        StyleConstants.setBold(red, true);

        SimpleAttributeSet big = new SimpleAttributeSet();
        StyleConstants.setFontSize(big, 24);

        try {
            doc.insertString(doc.getLength(), "JTextPane\n", big);
            doc.insertString(doc.getLength(), "normal text, ", null);
            doc.insertString(doc.getLength(), "red bold text\n", red);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        this.add(new JScrollPane(editor));
        this.add(new JScrollPane(textPane));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(TextPanes::new);
    }
}
