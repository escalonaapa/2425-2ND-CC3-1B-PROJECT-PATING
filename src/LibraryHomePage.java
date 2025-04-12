import javax.swing.*;
import java.awt.*;

public class LibraryHomePage extends JFrame {

    JPanel mainPanel;

    public LibraryHomePage() {
        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        // Top Navigation Bar
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(new JLabel("📚 Library"));

        JButton homeButton = new JButton("Home");
        JButton categoriesButton = new JButton("Categories");
        JButton newArrivalsButton = new JButton("New Arrivals");
        JButton searchButton = new JButton("🔍");
        JButton userButton = new JButton("User");

        topPanel.add(homeButton);
        topPanel.add(categoriesButton);
        topPanel.add(newArrivalsButton);
        topPanel.add(searchButton);
        topPanel.add(userButton);
        add(topPanel, BorderLayout.NORTH);

        // Main Content Panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(new JScrollPane(mainPanel), BorderLayout.CENTER);

        // Button Actions
        homeButton.addActionListener(e -> loadHomePage());
        categoriesButton.addActionListener(e -> loadCategoriesPage());
        newArrivalsButton.addActionListener(e -> loadNewArrivalsPage());
        searchButton.addActionListener(e -> performSearch());
        userButton.addActionListener(e -> showUserInfo());

        // Load home by default
        loadHomePage();

        setVisible(true);
    }

    private void loadHomePage() {
        mainPanel.removeAll();

        JPanel featuredPanel = new JPanel(new BorderLayout());
        featuredPanel.setBorder(BorderFactory.createTitledBorder("Featured Book"));
        JLabel featuredLabel = new JLabel("Insert Image", SwingConstants.CENTER);
        featuredLabel.setPreferredSize(new Dimension(800, 200));
        featuredLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        featuredPanel.add(featuredLabel, BorderLayout.CENTER);
        mainPanel.add(featuredPanel);

        JPanel quickAccessPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        quickAccessPanel.setBorder(BorderFactory.createTitledBorder("Quick Access"));
        for (int i = 1; i <= 4; i++) {
            quickAccessPanel.add(createBookPanel("Book " + i));
        }
        mainPanel.add(quickAccessPanel);

        JPanel moreBooksPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        moreBooksPanel.setBorder(BorderFactory.createTitledBorder("More Books"));
        for (int i = 5; i <= 7; i++) {
            moreBooksPanel.add(createBookPanel("Book " + i));
        }
        mainPanel.add(moreBooksPanel);

        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void loadCategoriesPage() {
        mainPanel.removeAll();
        mainPanel.add(new CategoriesPage());
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void loadNewArrivalsPage() {
        mainPanel.removeAll();
        mainPanel.add(new NewArrivalsPage());
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void performSearch() {
        String searchTerm = JOptionPane.showInputDialog(this, "Enter book title or keyword:");
        if (searchTerm != null && !searchTerm.trim().isEmpty()) {
            mainPanel.removeAll();
            mainPanel.add(new SearchPanel(searchTerm));
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }

    private void showUserInfo() {
        mainPanel.removeAll();
        mainPanel.add(new UserPanel());
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private JPanel createBookPanel(String titleText) {
        JPanel bookPanel = new JPanel(new BorderLayout());
        JLabel image = new JLabel("Insert Image", SwingConstants.CENTER);
        image.setPreferredSize(new Dimension(150, 100));
        image.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JLabel title = new JLabel(titleText, SwingConstants.CENTER);
        bookPanel.add(image, BorderLayout.CENTER);
        bookPanel.add(title, BorderLayout.SOUTH);
        return bookPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryHomePage());
    }
}