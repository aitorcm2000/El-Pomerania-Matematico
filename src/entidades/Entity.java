
package entidades;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int mundoX, mundoY;
    public int speed;
    
    public BufferedImage up, down, left, right;
    public String direction;
    
    public Rectangle areaSolida;
    public boolean collisionOn = false;
}
