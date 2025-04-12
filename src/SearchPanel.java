import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {

    public SearchPanel(String searchTerm) {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("🔍 Search Results for: " + searchTerm, SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel resultsPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        resultsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 1; i <= 4; i++) {
            JPanel bookPanel = new JPanel(new BorderLayout());
            JLabel image = new JLabel("Insert Image", SwingConstants.CENTER);
            image.setPreferredSize(new Dimension(150, 100));
            image.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            JLabel bookTitle = new JLabel("Result " + i + " - " + searchTerm, SwingConstants.CENTER);
            bookPanel.add(image, BorderLayout.CENTER);
            bookPanel.add(bookTitle, BorderLayout.SOUTH);
            resultsPanel.add(bookPanel);
        }

        add(resultsPanel, BorderLayout.CENTER);
    }
}
