import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LibraryHomePage extends JFrame {

    private JPanel mainPanel;

    public LibraryHomePage() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        // Top Navigation Bar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("📚 Library"));
        topPanel.add(new JButton("Home"));

        // Categories Button
        JButton categoriesButton = new JButton("Categories");
        categoriesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCategoriesPanel();
            }
        });
        topPanel.add(categoriesButton);

        topPanel.add(new JButton("New Arrivals"));
        topPanel.add(new JButton("🔍"));
        topPanel.add(new JButton("User"));
        add(topPanel, BorderLayout.NORTH);

        // Main Content Panel (make it class-level so we can swap content)
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        populateDefaultHomePage();  // Show default content initially

        // Add scroll pane if content overflows
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    // Default homepage content
    private void populateDefaultHomePage() {
        mainPanel.removeAll();

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

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    // Show the categories panel
    private void showCategoriesPanel() {
        mainPanel.removeAll();
        mainPanel.setLayout(new FlowLayout()); // Center categories
        mainPanel.add(new CategoriesPage());
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryHomePage());
    }
}
