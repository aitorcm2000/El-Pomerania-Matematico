
package main;

import javax.swing.JFrame;


public class Main {
    
    
    public static void main(String[] args) {
        
        JFrame ventana = new JFrame(); 
        
        // Establecer la acción que se realizará cuando se cierre la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Evitar que la ventana se pueda redimensionar
        ventana.setResizable(false);
        
        // Establecer el título de la ventana
        ventana.setTitle("Math Pomeranian RPG");
        
        // Establecer la ubicación de la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);
        
        GamePanel gp = new GamePanel();
        
        // Agregar el panel de juego a la 
        ventana.add(gp);
        
        // Hacer visible la ventana, mostrándola en la pantalla
        ventana.setVisible(true);
        
        ventana.pack(); //para que se pueda ver
        
        gp.startGameThread(); // sin esto el juego no se mueve
    }
    
}
