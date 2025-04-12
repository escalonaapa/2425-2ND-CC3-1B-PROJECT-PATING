import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {

    public UserPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("👤 User Profile", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JTextArea userInfo = new JTextArea();
        userInfo.setText("Name:Adrian Paul Escalona\nMembership: Regular\nBooks Borrowed: 3\nEmail: adescalona1@gmail.com");
        userInfo.setEditable(false);
        userInfo.setFont(new Font("Monospaced", Font.PLAIN, 16));
        userInfo.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(userInfo, BorderLayout.CENTER);
    }
}
