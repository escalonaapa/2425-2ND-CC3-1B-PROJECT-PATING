import javax.swing.*;
import java.awt.*;

public class CategoriesPage extends JPanel {

    public CategoriesPage() {
        setLayout(new GridLayout(2, 3, 10, 10));
        setBorder(BorderFactory.createTitledBorder("Categories"));

        String[] categories = {
            "Fiction", "Non-Fiction", "Sci-Fi",
            "Biography", "History", "Mystery"
        };

        for (String cat : categories) {
            JButton categoryButton = new JButton(cat);
            categoryButton.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "You selected: " + cat)
            );
            add(categoryButton);
        }
    }
}

