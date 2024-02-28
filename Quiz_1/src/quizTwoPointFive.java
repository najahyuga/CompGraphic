import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quizTwoPointFive extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final int HEART_WIDTH = 50;
    private static final int HEART_HEIGHT = 50;
    private static final int LINE_LENGTH = 600;
    private static final int LINE_START_X = 100;
    private static final int LINE_START_Y = HEIGHT / 2;
    private int heartX = LINE_START_X;
    private int heartY = LINE_START_Y;
    private Timer timer;

    public quizTwoPointFive(){
        timer = new Timer(20, this);
        timer.start();
    }

    protected void paintComponent(Graphics2D g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        // draw the line
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawLine(LINE_START_X, LINE_START_Y, LINE_START_X + LINE_LENGTH, LINE_START_Y);

        // draw the heart
        drawHeart(graphics2D, heartX, heartY);
    }

    private void drawHeart(Graphics2D graphics2D, int x, int y){
        graphics2D.setColor(Color.RED);

        // Draw left half of the heart
        graphics2D.fillArc(x, y - HEART_HEIGHT / 2, HEART_WIDTH, HEART_HEIGHT, 0, 180);

        // Draw right half of the heart
        graphics2D.fillArc(x - HEART_WIDTH, y - HEART_HEIGHT / 2, HEART_WIDTH, HEART_HEIGHT, 0, 180);

        // Draw bottom triangle of the heart
        int[] xPoints = {x - HEART_WIDTH / 2, x + HEART_WIDTH / 2, x};
        int[] yPoints = {y, y, y + HEART_HEIGHT / 2};
        graphics2D.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move heart along the line with sinusoidal motion
        heartX += 2;
        heartY = LINE_START_Y + (int) (50 * Math.sin(Math.toRadians(heartX * 2)));

        if (heartX > LINE_START_X + LINE_LENGTH) {
            heartX = LINE_START_X;
        }

        repaint(); // Redraw the panel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Beating Heart Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.getContentPane().add(new quizTwoPointFive());
            frame.setVisible(true);
        });
    }
}
