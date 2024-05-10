
package main;

import javax.swing.*;

public final class Ventana extends JFrame {
    public Ventana(JPanel jp) {
        
        // Establecer la acción que se realizará cuando se cierre la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Evitar que la ventana se pueda redimensionar
        setResizable(false);
        
        // Establecer el título de la ventana
        setTitle("Math Pomeranian RPG");
        
        // Establecer la ubicación de la ventana en el centro de la pantalla
        setLocationRelativeTo(null);
        
        // Agregar el panel de juego a la 
        add(jp);
        
        // Hacer visible la ventana, mostrándola en la pantalla
        setVisible(true);
        
        pack(); //para que se pueda ver
        
        gp.startGameThread();
    }
}

