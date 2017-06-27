package lineargraph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Graph extends JPanel {
    public static boolean drawGraph = false;
    public static int k = 0, n = 0, func;
    public Graph() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(401, 401);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 401, 401);
        g.setColor(Color.BLACK);
        g.drawLine(200, 0, 200, 401);
        g.drawLine(0, 200, 401, 200);
        if(drawGraph) {
            g.setColor(Color.BLUE);
            if(func == 0)
                g.drawLine(0, 200 - (-200 * k + n), 400, 200 - (200 * k + n));
            else {
                g.drawLine(0 - n, 0, 200 - n, 200);
                g.drawLine(200 - n, 200, 400 - n, 0);
            }
        }
    }
}
