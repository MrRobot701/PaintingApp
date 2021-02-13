import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class MyPanel extends JPanel {
    private Color[] colors;
    private int currentColor;
    private int x, y;
    private boolean isDrawing;

    private int colorsWidth, colorsHeight;

    public MyPanel(int colorNumber, int colorsWidth, int colorsHeight) {
        this.colors = generateOrdinaryColors();
        //или можно для разнообразия срандомить this.colors = generateRandomColors(colorNumber);
        this.colorsWidth = colorsWidth;
        this.colorsHeight = colorsHeight;

        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());

    }

    private Color[] generateOrdinaryColors() {
        Color[] ordinaryColors = new Color[7];
        ordinaryColors[0] = Color.BLACK;
        ordinaryColors[1] = Color.BLUE;
        ordinaryColors[2] = Color.CYAN;
        ordinaryColors[3] = Color.GREEN;
        ordinaryColors[4] = Color.YELLOW;
        ordinaryColors[5] = Color.ORANGE;
        ordinaryColors[6] = Color.WHITE;

        return ordinaryColors;
    }

    private Color[] generateRandomColors(int colorNumber) {
        Color[] randomColors = new Color[colorNumber];
        int r, g, b;

        for (int i = 0; i < colorNumber; i++) {
            r = new Random().nextInt(256); // -> генерирует число от 0 до 255
            g = new Random().nextInt(256); // -> генерирует число от 0 до 255
            b = new Random().nextInt(256); // -> генерирует число от 0 до 255
            randomColors[i] = new Color(r, g, b);
        }

        return randomColors;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        for(int i = 0; i < colors.length; i++) {
            graphics.setColor(colors[i]);
            graphics.fillRect(i*colorsWidth, 0, colorsWidth, colorsHeight);
        }

        if(isDrawing) {
            graphics.setColor(colors[currentColor]);
            graphics.fillRect(x, y, 3, 3);
        }
    }

    public class MyMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            int currentX = e.getX();
            int currentY = e.getY();

            int clickCount = e.getClickCount();
            int buttonNumber = e.getButton();

            int paintingWidth = colors.length * colorsWidth;
            int paintingHeight = colorsHeight;
            if (0 <= currentX && currentX <= paintingWidth && 0 <= currentY && currentY <= paintingHeight) {
                currentColor = currentX/colorsWidth;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    public class MyMouseMotionListener implements MouseMotionListener {
        @Override
        public void mouseDragged(MouseEvent e) {
            int currentX = e.getX();
            int currentY = e.getY();

            if (currentY > colorsHeight) {
                x = currentX;
                y = currentY;
                isDrawing = true;
                repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
