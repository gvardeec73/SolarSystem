import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {

    private BufferedImage sun, earth;
    private int sunWidth, sunHeight, sunPositionX, sunPositionY;
    private int earthWidth, earthHeight, earthPositionX, earthPositionY, earthOrbitRadius, earthRotationAngle = 0;


    {
        ImagePanel.this.setBackground(Color.BLACK);

    }

   public  ImagePanel() {
       try {
            sun = ImageIO.read(new File("sun.jpg"));
            sunWidth = sun.getWidth();
            sunHeight = sun.getHeight();
            sunPositionX = Constants.WINDOW_WIDTH/2 - sunWidth / 2;
            sunPositionY = Constants.WINDOW_HEIGHT / 2 - sunHeight/2;
       } catch (IOException e) {
           System.err.println("Не могу найти изображение солнца");
       }

       try {
           earth = ImageIO.read(new File("earth.jpg"));
           earthWidth = earth.getWidth();
           earthHeight = earth.getHeight();
          // earthPositionX = sunPositionX - 3 * earthWidth;
         //  earthPositionY = sunPositionY - 3 * earthHeight;
           earthOrbitRadius = sunWidth + earthWidth;
       } catch (IOException e) {
           System.err.println("Не могу найти изображение земли");
       }

   }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(sun, sunPositionX, sunPositionY, this);
        g.drawImage(earth,earthPositionX,earthPositionY,this);



        earthPositionX = (int) (earthOrbitRadius * Math.cos(Math.toRadians(earthRotationAngle))) + sunPositionX + sunWidth / 2 - earthWidth / 2;
        earthPositionY = (int) (earthOrbitRadius * Math.sin(Math.toRadians(earthRotationAngle))) + sunPositionY + sunHeight / 2 - earthHeight / 2;
        earthRotationAngle++;
        if (earthRotationAngle > 359) earthRotationAngle = 0;
    }
}
