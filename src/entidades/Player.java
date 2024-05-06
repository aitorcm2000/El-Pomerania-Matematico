
package entidades;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4; 
        direction = "up";
    }
   public void getPlayerImage(){
    try{
        up = ImageIO.read(getClass().getResourceAsStream("/recursos/jugador/jugador_up.png"));
        down = ImageIO.read(getClass().getResourceAsStream("/recursos/jugador/jugador_down.png"));
        left = ImageIO.read(getClass().getResourceAsStream("/recursos/jugador/jugador_left.png"));
        right = ImageIO.read(getClass().getResourceAsStream("/recursos/jugador/jugador_right.png"));
    } catch(IOException e){
        e.printStackTrace();
    }
}
    public void update(){
        // Aquí se actualizaría la información del juego, como las posiciones de los personajes, colisiones, etc.
        // Verificar si la tecla de dirección hacia arriba está presionada y ajustar la posición del jugador en consecuencia.
        if(keyH.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyH.downPressed == true){// Si la tecla de dirección hacia abajo está presionada, ajustar la posición del jugador hacia abajo.
            direction = "down";
            y += speed;
        }else if(keyH.leftPressed == true){// Si la tecla de dirección hacia la izquierda está presionada, ajustar la posición del jugador hacia la izquierda.
            direction = "left";
            x -= speed;
        }else if(keyH.rightPressed == true){// Si la tecla de dirección hacia la derecha está presionada, ajustar la posición del jugador hacia la derecha.
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
//        g2.setColor(Color.white); // Establecer el color de dibujo en blanco.
//
//        g2.fillRect(x, y, gp.tamañoTile, gp.tamañoTile); // Dibujar un rectángulo blanco en la posición (100,100) con el tamaño de un "tile".


        BufferedImage image = null;
        switch(direction){
            case "up":
                image = up;
                break;
            case "down":
                image = down;
                break;
            case "left":
                image = left;
                break;
            case "right":
                image = right;
                break;
        }
        g2.drawImage(image, x, y, gp.tamañoTile, gp.tamañoTile, null);
    }
    
    
}
