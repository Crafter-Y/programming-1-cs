package swing.layouts;

import javax.swing.*;
import java.awt.*;

// CardLayout: several components (cards) on top of each other, only one is visible at a time.
// Like a JTabbedPane without tabs - you switch by code (e.g. wizard with "next"/"back", game screens).
public class CardLayouts extends JFrame {
    public CardLayouts() {
        super("CardLayout");

        CardLayout cards = new CardLayout();
        JPanel cardPanel = new JPanel(cards);

        // each card is added with a name (String) to show it later by name
        cardPanel.add(createCard("Card 1: Welcome", Color.PINK), "welcome");
        cardPanel.add(createCard("Card 2: Settings", Color.CYAN), "settings");
        cardPanel.add(createCard("Card 3: Done", Color.GREEN), "done");

        JButton first = new JButton("<< First");
        JButton previous = new JButton("< Previous");
        JButton next = new JButton("Next >");
        JButton last = new JButton("Last >>");
        JButton settings = new JButton("Show 'settings'");

        first.addActionListener(e -> cards.first(cardPanel));
        previous.addActionListener(e -> cards.previous(cardPanel)); // wraps around
        next.addActionListener(e -> cards.next(cardPanel));
        last.addActionListener(e -> cards.last(cardPanel));
        settings.addActionListener(e -> cards.show(cardPanel, "settings")); // show by name

        JPanel navigation = new JPanel();
        navigation.add(first);
        navigation.add(previous);
        navigation.add(next);
        navigation.add(last);
        navigation.add(settings);

        this.add(cardPanel, BorderLayout.CENTER);
        this.add(navigation, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(550, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private static JPanel createCard(String text, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(color);
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        card.add(label, BorderLayout.CENTER);
        return card;
    }

    public static void main() {
        SwingUtilities.invokeLater(CardLayouts::new);
    }
}
