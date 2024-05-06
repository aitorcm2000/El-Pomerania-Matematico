
package main;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        // Creación de una nueva ventana utilizando la clase JFrame
        JFrame ventana = new JFrame();

        // Establecer la acción que se realizará cuando se cierre la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Evitar que la ventana se pueda redimensionar
        ventana.setResizable(false);

        // Establecer el título de la ventana
        ventana.setTitle("Math Pomeranian RPG");

        // Establecer la ubicación de la ventana en el centro de la pantalla
        ventana.setLocationRelativeTo(null);

        // Hacer visible la ventana, mostrándola en la pantalla
        ventana.setVisible(true);
        
        // Crear una instancia de la clase GamePanel, que representa el panel de juego.
        GamePanel gamePanel = new GamePanel();

        // Agregar el panel de juego a la ventana principal para que sea visible para el usuario.
        ventana.add(gamePanel);
        
        ventana.pack(); //para que se pueda ver
        
        gamePanel.startGameThread();
    }
    
}
