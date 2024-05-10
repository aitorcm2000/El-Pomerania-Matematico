
package main;

import entidades.Entity;

/**
 *
 * @author Estudios
 */
public class CollisionChecker {
    
    GamePanel gp;
    
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    
    public void checkTile(Entity entity){
        int entidadIzquierdaMundoX = entity.mundoX + entity.areaSolida.x;
        int entidadDerechaMundoX = entity.mundoX + entity.areaSolida.x + entity.areaSolida.width;
        int entidadSuperiorMundoY = entity.mundoY + entity.areaSolida.y;
        int entidadInferiorMundoY = entity.mundoY + entity.areaSolida.y + entity.areaSolida.height;
        
        int entidadIzqquierdaCol = entidadIzquierdaMundoX/gp.tamañoTile;
        int entidadDerechaCol = entidadDerechaMundoX/gp.tamañoTile;
        int entidadSuperiorFil = entidadSuperiorMundoY/gp.tamañoTile;
        int entidadInferiorFil = entidadInferiorMundoY/gp.tamañoTile;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case "up":
                entidadSuperiorFil = (entidadSuperiorMundoY - entity.speed)/gp.tamañoTile;
                break;
            case "down":
                break;
            case "left":
                break;
            case "right":
                break;
        }
    }
}
