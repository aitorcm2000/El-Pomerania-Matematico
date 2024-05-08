
package main;import javax.swing.*;

public class VentanaJuego extends JFrame {
    
    private GamePanel gamePanel;
    
    public VentanaJuego() {
        // Establecer el título de la ventana
        setTitle("Math Pomeranian RPG");
        
        // Crear una instancia del panel de juego
        gamePanel = new GamePanel();
        
        // Agregar el panel de juego a la ventana
        add(gamePanel);
        
        // Establecer el tamaño de la ventana automáticamente según su contenido
        pack();
        
        // Establecer la ubicación de la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        
        // Hacer visible la ventana
        setVisible(true);
    }
}

