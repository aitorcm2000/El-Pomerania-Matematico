
package menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.GamePanel;

public class MenuInicial extends JFrame {
    
    private JButton btnJugar;
    public boolean btnJugarPulsado;
    private JButton btnInicioSesion;
    public boolean btnInicioPulsado;
    private JButton btnPuntuaciones;
    public boolean btnPuntuacionesPulsado;
    
    private final int anchoPantalla = 768; //768 pixeles
    private final int altoPantalla = 576; //576 pixeles
    
    public MenuInicial() {
        
        // Establecer las dimensiones preferidas del panel para que coincidan con el tamaño de la pantalla.
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));
        
        // Establecer el diseño del panel
        setLayout(new GridLayout(3, 1));
        
        // Crear botones
        btnJugar = new JButton("Jugar");
        btnInicioSesion = new JButton("Inicio de Sesión");
        btnPuntuaciones = new JButton("Puntuaciones");
        btnJugarPulsado = false;
        btnInicioPulsado = false;
        btnPuntuacionesPulsado = false;
        
        // Añadir botones al panel
        add(btnJugar);
        add(btnInicioSesion);
        add(btnPuntuaciones);
        
        // Asignar acciones a los botones
        btnJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Acción para iniciar el GamePanel
                this.dispose();
                GamePanel gp = new GamePanel();
                gp.setVisible(true);
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
        btnJugarPulsado = true;
    }
    
    private void iniciarSesion() {
        // Lógica para iniciar sesión
        // Por ejemplo, abrir un cuadro de diálogo para iniciar sesión.
        btnInicioPulsado = false;
    }
    
    private void mostrarPuntuaciones() {
        // Lógica para mostrar las puntuaciones
        // Por ejemplo, abrir una ventana que muestre las puntuaciones almacenadas.
        btnPuntuacionesPulsado = false;
    }
}
