package Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PixelartCharacter extends JPanel implements KeyListener, ActionListener {
    private Image characterImage;
    private int x, y;
    private int characterWidth, characterHeight;
    private int characterSpeed;
    private Timer timer;
    private int currentFrame;
    private int totalFrames;

    public PixelartCharacter() {
        // Carga la imagen de tu personaje
        characterImage = new ImageIcon("C:\\Users\\Jeanette\\Downloads\\UAEM\\cosas random\\imagenPNG\\Assassin_2 (1).gif").getImage();

        x = 100; // Posición inicial en X
        y = 100; // Posición inicial en Y
        characterWidth = characterImage.getWidth(null);
        characterHeight = characterImage.getHeight(null);
        characterSpeed = 5; // Velocidad de movimiento
        currentFrame = 0;
        totalFrames = 4; // Número total de fotogramas de animación

        setFocusable(true);
        addKeyListener(this);

        timer = new Timer(100, this); // Velocidad de animación (100 ms)
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(characterImage, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Actualiza la animación
        currentFrame = (currentFrame + 1) % totalFrames;
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            x -= characterSpeed;
        } else if (key == KeyEvent.VK_RIGHT) {
            x += characterSpeed;
        } else if (key == KeyEvent.VK_UP) {
            y -= characterSpeed;
        } else if (key == KeyEvent.VK_DOWN) {
            y += characterSpeed;
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pixel Art Character");
        PixelartCharacter character = new PixelartCharacter();
        frame.add(character);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
