
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
        mapaNumTiles = new int [gp.maxColMundo][gp.maxFilMundo];
        getImagenTile();
        cargarMapa("/recursos/mapas/mapa_02.txt");
    }
    public void getImagenTile(){
        try{
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/suelo_blanco.png"));
            
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/pared_negra.png"));
            tile[1].collision = true;
            
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/jaula_perro.png"));
            tile[2].collision = true;
            
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/corazon.png"));
            
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/llave.png"));
            
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/recursos/tiles/ordenador.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    } // odio mi vida jaja
    
    public void cargarMapa(String direccionArchivo) {
        try {
            InputStream map = getClass().getResourceAsStream(direccionArchivo);
            BufferedReader br = new BufferedReader(new InputStreamReader(map));

            int fil = 0;
            while (fil < gp.maxFilMundo) {
                String linea = br.readLine();
                if (linea == null) break; // Para salir si no hay más líneas en el archivo

                String numeros[] = linea.split(" ");
                int col = 0;
                for (String numero : numeros) {
                    int num = Integer.parseInt(numero);
                    mapaNumTiles[col][fil] = num;
                    col++;
                    if (col >= gp.maxColMundo) break; // Para evitar desbordamiento de la matriz
                }
                fil++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void draw(Graphics2D g2) {
        int filMundo = 0;
        while (filMundo < gp.maxFilMundo) {
            int colMundo = 0;
            while (colMundo < gp.maxColMundo) {
                int numTile = mapaNumTiles[colMundo][filMundo];
                int mundoX = colMundo * gp.tamañoTile;
                int mundoY = filMundo * gp.tamañoTile;
                int pantallaX = mundoX - gp.player.mundoX + gp.player.pantallaX;
                int pantallaY = mundoY - gp.player.mundoY + gp.player.pantallaY;

                g2.drawImage(tile[numTile].image, pantallaX, pantallaY, gp.tamañoTile, gp.tamañoTile, null);
                colMundo++;
            }
            filMundo++;
        }
    }

}
