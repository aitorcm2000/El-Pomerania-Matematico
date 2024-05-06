
package main;

// Importar las clases necesarias del paquete awt (Abstract Window Toolkit) para manipular color y dimensiones, 
// y del paquete swing para utilizar JPanel
import entidades.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

// Definición de la clase GamePanel que extiende JPanel, lo que significa que esta clase representa un panel
// dentro de una ventana donde se puede dibujar y colocar componentes.
public class GamePanel extends JPanel implements Runnable{
    
    // Definición de variables finales para el tamaño original de los "tiles" (16x16) y el factor de escala (3).
    private final int tamañoOriginalTiles = 16; //16x16 tiles es el tamaño estandar como es muy pequeño lo vamos a escalar
    private final int escala = 3; //16x3 
    
    // Cálculo del tamaño final de los "tiles" después de aplicar el factor de escala.
    public final int tamañoTile = tamañoOriginalTiles * escala; //46x48 tile
    
    // Definición de variables finales para el número máximo de columnas y filas en la pantalla.
    public final int maxColPantalla = 16;
    public final int maxFilPantalla = 12;
    
    // Cálculo del ancho y alto de la pantalla en píxeles, basado en el tamaño de los "tiles" escalados 
    // y el número máximo de columnas y filas en la pantalla.
    private final int anchoPantalla = tamañoTile * maxColPantalla; //768 pixeles
    private final int altoPantalla = tamañoTile * maxFilPantalla; //576 pixeles
    
    //FPS
    private int FPS = 60;

    // Declaración de una variable llamada gameThread que representa un hilo de ejecución.
    // Los hilos permiten que el programa realice múltiples tareas simultáneamente, lo que es útil
    // para ejecutar operaciones que pueden bloquear el hilo principal, como operaciones de red o cálculos intensivos.
    Thread gameThread;
    
    KeyHandler keyH = new KeyHandler();
    Player player = new Player(this, keyH);

    

    // Constructor de la clase GamePanel
    public GamePanel() {
        // Establecer las dimensiones preferidas del panel para que coincidan con el tamaño de la pantalla.
        this.setPreferredSize(new Dimension(anchoPantalla, altoPantalla));

        // Establecer el color de fondo del panel como negro.
        this.setBackground(Color.black);

        // Habilitar el doble búfer para mejorar el rendimiento de la representación gráfica.
        this.setDoubleBuffered(true);

        // Agregar el KeyListener para manejar eventos de teclado.
        this.addKeyListener(keyH);

        // Permitir que el panel obtenga el enfoque para que pueda recibir eventos de teclado.
        this.setFocusable(true);
    }

    // Método para iniciar el hilo del juego.
    public void startGameThread(){
        // Se crea un nuevo hilo utilizando esta instancia de la clase (this) como el objeto que implementa Runnable.
        // Esto significa que el método run() definido en esta clase será ejecutado por el hilo.
        gameThread = new Thread(this);
        // Se inicia el hilo.
        gameThread.start();
    }

    // Método run que se ejecuta cuando se inicia el hilo del juego.
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;//0.016666 segundos
        double nextDrawTime = System.nanoTime() + drawInterval;
        
        // GAME LOOP: Un ciclo que se ejecuta continuamente mientras el hilo del juego esté activo.
        while(gameThread != null){
            
            long currentTime = System.nanoTime();
            System.out.println("current time "+ currentTime);
            
            // 1. Actualización de información del juego, como las posiciones del personaje.
            update();
            // 2. Dibujar en la pantalla la información actualizada.
            repaint();
            
            
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000.0; // Ajuste para asegurar precisión decimal

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para actualizar la información del juego.
public void update(){
    player.update();
}


    // Método para dibujar componentes en el panel.
    public void paintComponent(Graphics g){
        super.paintComponent(g); // Llamada al método de la clase padre para realizar las operaciones de pintado estándar.

        Graphics2D g2 = (Graphics2D)g; // Conversión del objeto Graphics a Graphics2D para acceder a métodos más avanzados.
        
        player.draw(g2);
        
        g2.dispose(); // Liberar recursos gráficos.
    }

}