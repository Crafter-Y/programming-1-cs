package swing;

import javax.swing.*;
import java.awt.*;

// JList: shows a list of items, one or more can be selected.
// To add/remove items at runtime use a DefaultListModel (the "data" behind the list).
public class Lists extends JFrame {
    public Lists() {
        super("Lists");

        DefaultListModel<String> model = new DefaultListModel<>();
        model.addElement("Apple");
        model.addElement("Banana");
        model.addElement("Cherry");

        JList<String> list = new JList<>(model);
        // a list from a fixed array would be: new JList<>(new String[] { "a", "b" });

        // SINGLE_SELECTION, SINGLE_INTERVAL_SELECTION, MULTIPLE_INTERVAL_SELECTION (default, Ctrl/Shift + click)
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setVisibleRowCount(6);

        JLabel result = new JLabel("Nothing selected");

        // ListSelectionListener is called on selection changes
        list.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return; // ignore events while the mouse is still dragging
            result.setText("Selected: " + list.getSelectedValuesList() + " first index: " + list.getSelectedIndex());
        });

        JTextField input = new JTextField(10);
        JButton add = new JButton("Add");
        add.addActionListener(e -> {
            if (!input.getText().isBlank()) {
                model.addElement(input.getText());
                input.setText("");
            }
        });
        input.addActionListener(e -> add.doClick()); // Enter in the text field = click on add

        JButton remove = new JButton("Remove selected");
        remove.addActionListener(e -> {
            // remove from the back so indices stay valid
            int[] indices = list.getSelectedIndices();
            for (int i = indices.length - 1; i >= 0; i--) {
                model.remove(indices[i]);
            }
        });

        JButton clear = new JButton("Clear");
        clear.addActionListener(e -> model.clear());

        JPanel controls = new JPanel();
        controls.add(input);
        controls.add(add);
        controls.add(remove);
        controls.add(clear);

        this.add(new JScrollPane(list), BorderLayout.CENTER); // scroll pane for many items
        this.add(controls, BorderLayout.NORTH);
        this.add(result, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Lists::new);
    }
}
