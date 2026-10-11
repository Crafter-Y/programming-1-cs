package swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// JTable: shows data in rows and columns. Like JList, the data lives in a model (DefaultTableModel).
// Always put a JTable into a JScrollPane - otherwise the column headers are not shown!
public class Tables extends JFrame {
    public Tables() {
        super("Tables");

        String[] columns = { "Name", "Age", "City" };
        Object[][] data = {
                { "Anna", 21, "Karlsruhe" },
                { "Ben", 23, "Stuttgart" },
                { "Clara", 20, "Mannheim" },
        };
        // a simple read-only table would be: new JTable(data, columns);

        DefaultTableModel model = new DefaultTableModel(data, columns) {
            // make only some cells editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };

        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true); // click on a header to sort

        JLabel status = new JLabel("Select a row");
        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) {
                // with sorting, the view row can differ from the model row
                int modelRow = table.convertRowIndexToModel(row);
                status.setText("Selected: " + model.getValueAt(modelRow, 0) + ", " + model.getValueAt(modelRow, 1));
            }
        });

        JTextField name = new JTextField(8);
        JTextField age = new JTextField(3);
        JTextField city = new JTextField(8);
        JButton add = new JButton("Add row");
        add.addActionListener(e -> model.addRow(new Object[] { name.getText(), age.getText(), city.getText() }));

        JButton remove = new JButton("Remove selected");
        remove.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) model.removeRow(table.convertRowIndexToModel(row));
        });

        JPanel controls = new JPanel();
        controls.add(name);
        controls.add(age);
        controls.add(city);
        controls.add(add);
        controls.add(remove);

        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(controls, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(550, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Tables::new);
    }
}
