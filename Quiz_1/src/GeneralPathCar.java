import java.awt.*;
import java.awt.geom.GeneralPath;
import javax.swing.*;

public class GeneralPathCar extends JFrame {

    public GeneralPathCar() {
        initUI();
    }

    private void initUI() {
        setTitle("Car");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawCar(g);
    }

    private void drawCar(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // Draw the car body
        int[] xPoints = {50, 100, 250, 300};
        int[] yPoints = {200, 100, 100, 200};
        int nPoints = 4;

        GeneralPath carBody = new GeneralPath(GeneralPath.WIND_EVEN_ODD, nPoints);
        carBody.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < nPoints; i++) {
            carBody.lineTo(xPoints[i], yPoints[i]);
        }
        carBody.closePath();

        g2d.setColor(Color.BLUE);
        g2d.fill(carBody);

        // Draw control points for the quadratic curve
        int[] quadCtrlX = {100, 150, 200};
        int[] quadCtrlY = {100, 50, 100};
        int numCtrlPointsQuad = 3;

        g2d.setColor(Color.RED);
        for (int i = 0; i < numCtrlPointsQuad; i++) {
            g2d.fillOval(quadCtrlX[i] - 3, quadCtrlY[i] - 3, 6, 6);
        }

        // Draw the quadratic curve
        GeneralPath quadCurve = new GeneralPath();
        quadCurve.moveTo(quadCtrlX[0], quadCtrlY[0]);
        quadCurve.quadTo(quadCtrlX[1], quadCtrlY[1], quadCtrlX[2], quadCtrlY[2]);

        // Draw control points for the cubic curve
        int[] cubicCtrlX = {150, 175, 225, 250};
        int[] cubicCtrlY = {100, 50, 50, 100};
        int numCtrlPointsCubic = 4;

        for (int i = 0; i < numCtrlPointsCubic; i++) {
            g2d.fillOval(cubicCtrlX[i] - 3, cubicCtrlY[i] - 3, 6, 6);
        }

        // Draw the cubic curve
        GeneralPath cubicCurve = new GeneralPath();
        cubicCurve.moveTo(cubicCtrlX[0], cubicCtrlY[0]);
        cubicCurve.curveTo(cubicCtrlX[1], cubicCtrlY[1], cubicCtrlX[2], cubicCtrlY[2], cubicCtrlX[3], cubicCtrlY[3]);

        // Draw dashed lines connecting control points to the corresponding curve endings
        g2d.setColor(Color.BLACK);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        g2d.setStroke(dashed);

        // For quadratic curve
        g2d.drawLine(quadCtrlX[0], quadCtrlY[0], xPoints[1], yPoints[1]);
        g2d.drawLine(quadCtrlX[2], quadCtrlY[2], xPoints[2], yPoints[2]);

        // For cubic curve
        g2d.drawLine(cubicCtrlX[0], cubicCtrlY[0], xPoints[1], yPoints[1]);
        g2d.drawLine(cubicCtrlX[3], cubicCtrlY[3], xPoints[2], yPoints[2]);

        g2d.setColor(Color.BLACK);
        g2d.draw(quadCurve);
        g2d.draw(cubicCurve);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            GeneralPathCar ex = new GeneralPathCar();
            ex.setVisible(true);
        });
    }
}
