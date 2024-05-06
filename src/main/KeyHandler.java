
package main;

// Importar las clases necesarias para manejar eventos de teclado.
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Definir una clase llamada KeyHandler que implementa la interfaz KeyListener para manejar eventos de teclado.
public class KeyHandler implements KeyListener {

    // Definir variables booleanas para indicar si las teclas de dirección están presionadas.
    public boolean upPressed, downPressed, leftPressed, rightPressed;

    // Método que se llama cuando se presiona una tecla, implementado de la interfaz KeyListener.
    @Override
    public void keyPressed(KeyEvent e) {
        updateKeyState(e.getKeyCode(), true);
    }

    // Método que se llama cuando se suelta una tecla, implementado de la interfaz KeyListener.
    @Override
    public void keyReleased(KeyEvent e) {
        updateKeyState(e.getKeyCode(), false);
    }

    // Método de la interfaz KeyListener que no se utiliza en este caso.
    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Función auxiliar para actualizar el estado de las teclas según el código de la tecla y el estado de presionado.
    private void updateKeyState(int keyCode, boolean pressed) {
        switch (keyCode) {
            case KeyEvent.VK_W:
                upPressed = pressed;
                break;
            case KeyEvent.VK_S:
                downPressed = pressed;
                break;
            case KeyEvent.VK_A:
                leftPressed = pressed;
                break;
            case KeyEvent.VK_D:
                rightPressed = pressed;
                break;
            default:
                // No hacemos nada para otras teclas
                break;
        }
    }
}
