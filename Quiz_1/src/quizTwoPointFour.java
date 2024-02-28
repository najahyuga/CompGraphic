import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class quizTwoPointFour extends JPanel implements ActionListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int PLANET_RADIUS = 10;
    private static final int ORBIT_RADIUS = 200;
    private static final int SUN_RADIUS = 20;
    private static final double ROTATION_SPEED = 2 * Math.PI / 365; // 1 rotation per orbit
    private double angle = 0;

    public quizTwoPointFour(){
        Timer timer = new Timer(20, this); // timer to update animation
        timer.start();
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;

        // set background
        graphics2D.setColor(Color.BLACK);
        graphics2D.fillRect(0, 0, WIDTH, HEIGHT);

        // draw sun
        graphics2D.setColor(Color.CYAN);
        graphics2D.fillOval(WIDTH / 2 - SUN_RADIUS, HEIGHT / 2 - SUN_RADIUS, 2 * SUN_RADIUS, 2 * SUN_RADIUS);

        // calculate position of the planet
        int planetX = (int) (WIDTH / 2 + ORBIT_RADIUS * Math.cos(angle) - PLANET_RADIUS);
        int planetY = (int) (HEIGHT / 2 + ORBIT_RADIUS * Math.sin(angle) - PLANET_RADIUS);

        // draw planet
        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(planetX, planetY, 2 * PLANET_RADIUS, 2 * PLANET_RADIUS);

        // draw line from sun to planet
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawLine(WIDTH / 2, HEIGHT / 2, planetX + PLANET_RADIUS, planetY + PLANET_RADIUS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // update angle
        angle += ROTATION_SPEED;
        if (angle >= 2 * Math.PI) {
            angle -= 2 * Math.PI; // Ensure angle stays within one orbit
        }

        repaint(); // redraw panel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Solar System Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(WIDTH, HEIGHT);
            frame.getContentPane().add(new quizTwoPointFour());
            frame.setVisible(true);
        });
    }
}
