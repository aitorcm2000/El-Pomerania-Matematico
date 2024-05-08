
package menuInicial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.VentanaJuego;

public class MenuInicial extends JPanel {
    
    private JButton btnJugar;
    private boolean btnJugarPulsado;
    private JButton btnInicioSesion;
    private boolean btnInicioPulsado;
    private JButton btnPuntuaciones;
    private boolean btnPuntuacionesPulsado;
    
    public MenuInicial() {
        // Establecer el diseño del panel
        setLayout(new GridLayout(3, 1));
        
        // Crear botones
        btnJugar = new JButton("Jugar");
        btnInicioSesion = new JButton("Inicio de Sesión");
        btnPuntuaciones = new JButton("Puntuaciones");
        
        // Añadir botones al panel
        add(btnJugar);
        add(btnInicioSesion);
        add(btnPuntuaciones);
        
        // Asignar acciones a los botones
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para iniciar el GamePanel
                iniciarJuego();
            }
        });
        
        btnInicioSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para iniciar sesión
                iniciarSesion();
            }
        });
        
        btnPuntuaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para mostrar las puntuaciones
                mostrarPuntuaciones();
            }
        });
    }
    
    private void iniciarJuego() {
        // Lógica para iniciar el GamePanel
        // Aquí deberías crear una instancia de GamePanel y añadirla a una ventana JFrame.
        // Por simplicidad, supondré que tienes una clase llamada VentanaJuego.
        VentanaJuego ventanaJuego = new VentanaJuego();
        ventanaJuego.setVisible(true);
    }
    
    private void iniciarSesion() {
        // Lógica para iniciar sesión
        // Por ejemplo, abrir un cuadro de diálogo para iniciar sesión.
    }
    
    private void mostrarPuntuaciones() {
        // Lógica para mostrar las puntuaciones
        // Por ejemplo, abrir una ventana que muestre las puntuaciones almacenadas.
    }
}
