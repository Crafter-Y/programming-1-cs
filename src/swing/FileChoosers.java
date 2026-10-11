package swing;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

// JFileChooser: dialog to pick a file for opening or saving. Combined with FileIO this gives a mini editor.
public class FileChoosers extends JFrame {
    private final JTextArea area = new JTextArea(15, 40);

    public FileChoosers() {
        super("File Choosers");

        JButton open = new JButton("Open...");
        open.addActionListener(e -> openFile());

        JButton save = new JButton("Save...");
        save.addActionListener(e -> saveFile());

        JButton folder = new JButton("Choose folder...");
        folder.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // FILES_ONLY (default), FILES_AND_DIRECTORIES
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                area.setText("Folder: " + chooser.getSelectedFile().getAbsolutePath());
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(open);
        buttons.add(save);
        buttons.add(folder);

        this.add(buttons, BorderLayout.NORTH);
        this.add(new JScrollPane(area), BorderLayout.CENTER);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void openFile() {
        // start directory can be passed: new JFileChooser(".") or new JFileChooser(System.getProperty("user.home"))
        JFileChooser chooser = new JFileChooser(".");
        chooser.setFileFilter(new FileNameExtensionFilter("Text files (*.txt, *.java)", "txt", "java"));

        // returns APPROVE_OPTION, CANCEL_OPTION or ERROR_OPTION
        int result = chooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        File file = chooser.getSelectedFile();
        try {
            area.setText(Files.readString(file.toPath()));
            this.setTitle("File Choosers - " + file.getName());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not read: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser(".");
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) return;

        File file = chooser.getSelectedFile();
        if (file.exists()) {
            int overwrite = JOptionPane.showConfirmDialog(this, "Overwrite " + file.getName() + "?",
                    "File exists", JOptionPane.YES_NO_OPTION);
            if (overwrite != JOptionPane.YES_OPTION) return;
        }
        try {
            Files.writeString(file.toPath(), area.getText());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Could not save: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main() {
        SwingUtilities.invokeLater(FileChoosers::new);
    }
}
