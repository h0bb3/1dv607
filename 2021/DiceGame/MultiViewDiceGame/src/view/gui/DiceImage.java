package view.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

/* Code from: http://java-articles.info/articles/?p=460 */
 
public class DiceImage {
 
    /** Side of a die in pixels */
    private static final int    SIDE            = 64;
 
    private static final int    SPOT_DIAMETER   = 10;
 
    private Image               image;
 
    public DiceImage() {
        image = new BufferedImage(SIDE, SIDE, 
                BufferedImage.TYPE_INT_RGB);
    }
 
    public Image draw(int count) {
        int w = image.getWidth(null);
        int h = image.getHeight(null);
 
        Graphics g = image.getGraphics();
 
        drawBorder(g, w, h);
        drawBackground(g, w, h);
        drawSpots(g, w, h, count);
 
        g.dispose();
        return image;
    }
 
    private void drawBorder(Graphics g, int w, int h) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, h);
    }
 
    private void drawBackground(Graphics g, int w, int h) {
        g.setColor(Color.WHITE);
        g.fillRect(3, 3, w - 6, h - 6);
    }
 
    private void drawSpots(Graphics g, int w, int h, int count) {
        g.setColor(Color.BLACK);
 
        switch (count) {
        case 1:
            drawSpot(g, w / 2, h / 2);
            break;
        case 3:
            drawSpot(g, w / 2, h / 2);
            // Fall thru to next case
        case 2:
            drawSpot(g, w / 4, h / 4);
            drawSpot(g, 3 * w / 4, 3 * h / 4);
            break;
        case 5:
            drawSpot(g, w / 2, h / 2);
            // Fall thru to next case
        case 4:
            drawSpot(g, w / 4, h / 4);
            drawSpot(g, 3 * w / 4, 3 * h / 4);
            drawSpot(g, 3 * w / 4, h / 4);
            drawSpot(g, w / 4, 3 * h / 4);
            break;
        case 6:
            drawSpot(g, w / 4, h / 4);
            drawSpot(g, 3 * w / 4, 3 * h / 4);
            drawSpot(g, 3 * w / 4, h / 4);
            drawSpot(g, w / 4, 3 * h / 4);
            drawSpot(g, w / 4, h / 2);
            drawSpot(g, 3 * w / 4, h / 2);
            break;
        }
    }
 
    private void drawSpot(Graphics g, int x, int y) {
        g.fillOval(x - SPOT_DIAMETER / 2, y - SPOT_DIAMETER / 2, 
                SPOT_DIAMETER, SPOT_DIAMETER);
    }
 
}