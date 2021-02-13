import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame(int width, int height) {
        setTitle("Painting App");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        MyPanel mainPanel = new MyPanel(7, 100, 50);
        Container  container = getContentPane();
        container.add(mainPanel);
    }
}
