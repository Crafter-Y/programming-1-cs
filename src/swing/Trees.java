package swing;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

// JTree: hierarchical data (like folders). Built from DefaultMutableTreeNode objects.
public class Trees extends JFrame {
    public Trees() {
        super("Trees");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("University");

        DefaultMutableTreeNode semester1 = new DefaultMutableTreeNode("Semester 1");
        semester1.add(new DefaultMutableTreeNode("Programming"));
        semester1.add(new DefaultMutableTreeNode("Math"));

        DefaultMutableTreeNode semester2 = new DefaultMutableTreeNode("Semester 2");
        semester2.add(new DefaultMutableTreeNode("Databases"));

        root.add(semester1);
        root.add(semester2);

        DefaultTreeModel model = new DefaultTreeModel(root);
        JTree tree = new JTree(model);
        // tree.setRootVisible(false);
        tree.expandRow(0);

        JLabel status = new JLabel("Select a node");
        tree.addTreeSelectionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) return;
            status.setText("Selected: " + node.getUserObject() + (node.isLeaf() ? " (leaf)" : "")
                    + " path: " + e.getPath());
        });

        // add a child to the selected node
        JTextField name = new JTextField(10);
        JButton add = new JButton("Add child to selected");
        add.addActionListener(e -> {
            DefaultMutableTreeNode parent = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (parent == null) parent = root;
            DefaultMutableTreeNode child = new DefaultMutableTreeNode(name.getText());
            model.insertNodeInto(child, parent, parent.getChildCount()); // updates the view, parent.add() would not
            tree.expandPath(new javax.swing.tree.TreePath(parent.getPath()));
        });

        JPanel controls = new JPanel();
        controls.add(name);
        controls.add(add);

        this.add(new JScrollPane(tree), BorderLayout.CENTER);
        this.add(controls, BorderLayout.NORTH);
        this.add(status, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(450, 350);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main() {
        SwingUtilities.invokeLater(Trees::new);
    }
}
