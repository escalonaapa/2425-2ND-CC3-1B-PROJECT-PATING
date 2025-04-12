import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CategoriesPage extends JPanel {

    public CategoriesPage() {
        setLayout(new GridLayout(2, 3, 10, 10));
        String[] categories = {
            "Fiction", "Non-Fiction", "Sci-Fi",
            "Biography", "History", "Mystery"
        };

        for (String category : categories) {
            JButton categoryButton = new JButton(category);
            categoryButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "You selected: " + category);
                }
            });
            add(categoryButton);
        }
    }
}
