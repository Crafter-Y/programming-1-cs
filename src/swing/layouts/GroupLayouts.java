package swing.layouts;

import javax.swing.*;

// GroupLayout: describes the layout TWICE - once horizontally and once vertically.
// Groups are either sequential (one after another) or parallel (side by side / aligned).
// Used by the IntelliJ/NetBeans GUI designers. Good for forms with aligned labels.
//
//  [Label 1] [Field 1        ]
//  [Label 2] [Field 2        ]
//            [OK] [Cancel]
public class GroupLayouts extends JFrame {
    public GroupLayouts() {
        super("GroupLayout");

        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);          // gaps between components
        layout.setAutoCreateContainerGaps(true); // gaps to the container border

        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("E-Mail address:");
        JTextField name = new JTextField(15);
        JTextField email = new JTextField(15);
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Cancel");

        // horizontal: column of labels, then column of fields (fields + button row)
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(nameLabel)
                        .addComponent(emailLabel))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(name)
                        .addComponent(email)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(ok)
                                .addComponent(cancel))));

        // vertical: row 1 (label + field), row 2 (label + field), row 3 (buttons)
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(nameLabel)
                        .addComponent(name))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(emailLabel)
                        .addComponent(email))
                .addGroup(layout.createParallelGroup()
                        .addComponent(ok)
                        .addComponent(cancel)));

        // make both buttons the same size
        layout.linkSize(SwingConstants.HORIZONTAL, ok, cancel);

        ok.addActionListener(e -> JOptionPane.showMessageDialog(this, "Hello " + name.getText()));
        cancel.addActionListener(e -> this.dispose());

        this.add(panel);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(GroupLayouts::new);
    }
}
