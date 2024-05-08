
package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.GamePanel;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapaNumTiles[][]; //la matriz del mapa
    
    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        mapaNumTiles = new int [gp.maxColPantalla][gp.maxFilPantalla];
        getImagenTile();
        cargarMapa();
    }
    public void getImagenTile(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_blanco.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_negro.png"));
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/jaula_perro.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    } // odio mi vida jaja
    
    public void cargarMapa(){
        try{
            InputStream map = getClass().getResourceAsStream("/recursos/mapas/mapa_01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(map)); // es solo un formato para leer el txt
            
            int col = 0;
            int fil = 0;
            
            while(col < gp.maxColPantalla && fil < gp.maxFilPantalla){
                String linea = br.readLine();
                
                while(col < gp.maxColPantalla){
                    String numeros[] = linea.split(" "); 
                    int num = Integer.parseInt(numeros[col]);//cambiamos el string por int
                    mapaNumTiles[col][fil] = num;
                    col++;
                }
                
                if(col == gp.maxColPantalla){
                    col = 0;
                    fil++;
                }
            }
            br.close();
        }catch(Exception e){
             e.printStackTrace();
        }
    }
    
    public void draw(Graphics2D g2){
        int col = 0;
        int fil = 0;
        int x = 0;
        int y = 0;
        
        while(col < gp.maxColPantalla && fil < gp.maxFilPantalla){
            
            int numTile = mapaNumTiles[col][fil];
            
            g2.drawImage(tile[numTile].image, x, y, gp.tamañoTile, gp.tamañoTile, null);
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
