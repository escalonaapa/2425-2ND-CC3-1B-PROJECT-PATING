
import javax.swing.*;
import java.awt.*;

public class LibraryHomePage extends JFrame {

    public LibraryHomePage() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        // Top Navigation Bar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("📚 Library"));
        topPanel.add(new JButton("Home"));
        topPanel.add(new JButton("Categories"));
        topPanel.add(new JButton("New Arrivals"));
        topPanel.add(new JButton("🔍"));
        topPanel.add(new JButton("User"));
        add(topPanel, BorderLayout.NORTH);

        // Main Content Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Featured Book Panel
        JPanel featuredPanel = new JPanel(new BorderLayout());
        featuredPanel.setBorder(BorderFactory.createTitledBorder("Featured Book"));
        JLabel featuredLabel = new JLabel("Insert Image", SwingConstants.CENTER);
        featuredLabel.setPreferredSize(new Dimension(800, 200));
        featuredLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        featuredPanel.add(featuredLabel, BorderLayout.CENTER);
        mainPanel.add(featuredPanel);

        // Quick Access Books Panel
        JPanel quickAccessPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        quickAccessPanel.setBorder(BorderFactory.createTitledBorder("Quick Access"));
        for (int i = 1; i <= 4; i++) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            JLabel image = new JLabel("Insert Image", SwingConstants.CENTER);
            image.setPreferredSize(new Dimension(150, 100));
            image.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            JLabel title = new JLabel("Book " + i, SwingConstants.CENTER);
            bookPanel.add(image, BorderLayout.CENTER);
            bookPanel.add(title, BorderLayout.SOUTH);
            quickAccessPanel.add(bookPanel);
        }
        mainPanel.add(quickAccessPanel);

        // More Books Panel
        JPanel moreBooksPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        moreBooksPanel.setBorder(BorderFactory.createTitledBorder("More Books"));
        for (int i = 5; i <= 7; i++) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            JLabel image = new JLabel("Insert Image", SwingConstants.CENTER);
            image.setPreferredSize(new Dimension(150, 100));
            image.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            JLabel title = new JLabel("Book " + i, SwingConstants.CENTER);
            bookPanel.add(image, BorderLayout.CENTER);
            bookPanel.add(title, BorderLayout.SOUTH);
            moreBooksPanel.add(bookPanel);
        }
        mainPanel.add(moreBooksPanel);

        // Add scroll pane if content overflows
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryHomePage());
    }
}
