
package tile;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileImage();
    }
    
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_blanco.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_blanco.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_blanco.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    } // odio mi vida jaja
    public void draw(Graphics2D g2){
        int col = 0;
        int fil = 0;
        int x = 0;
        int y = 0;
        
        while(col < gp.maxColPantalla && fil < gp.maxFilPantalla){
            g2.drawImage(tile[0].image, x, y, gp.tamañoTile, gp.tamañoTile, null);
            col++;
            x+= gp.tamañoTile;
            
            if(col == gp.maxColPantalla){ //16x12
                col = 0;
                x = 0; 
                fil++;
                y += gp.tamañoTile;
            }
        }
        
    }
}
