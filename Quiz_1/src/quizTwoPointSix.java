import javax.swing.*;
import java.awt.*;

public class quizTwoPointSix extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set font and size
        Font font = new Font("Arial", Font.BOLD, 50);
        g2d.setFont(font);

        // Draw the letter "N"
        g2d.drawString("N", 250, 200);
        // Draw the letter "Y"
        g2d.drawString("Y", 280, 250);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Two Point Six");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.add(new quizTwoPointSix());
        frame.setVisible(true);
    }
}
