import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Солнечная система");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);

        ImagePanel panel = new ImagePanel();

        window.add(panel);
        window.setVisible(true);
        ActionListener moveImage = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        };

        Timer speedTimer = new Timer(10,moveImage);
        speedTimer.start();

    }
}
