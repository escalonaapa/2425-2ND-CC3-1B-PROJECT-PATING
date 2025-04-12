import javax.swing.*;
import java.awt.*;

public class NewArrivalsPage extends JPanel {

    public NewArrivalsPage() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("📦 New Arrivals", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel booksPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        booksPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 1; i <= 6; i++) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            JLabel image = new JLabel("Insert Image", SwingConstants.CENTER);
            image.setPreferredSize(new Dimension(150, 100));
            image.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            JLabel bookTitle = new JLabel("New Book " + i, SwingConstants.CENTER);
            bookPanel.add(image, BorderLayout.CENTER);
            bookPanel.add(bookTitle, BorderLayout.SOUTH);

            booksPanel.add(bookPanel);
        }

        add(booksPanel, BorderLayout.CENTER);
    }
}
