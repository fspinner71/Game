import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    private Thread gameThread;

    private Player player;

    public GamePanel()
    {
        setPreferredSize(new Dimension(Frame.WIDTH, Frame.HEIGHT));
        setBackground(Color.WHITE);
        setDoubleBuffered(true);

        player = new Player();
        addKeyListener(player.getKeyHandler());
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        long lastTime = System.nanoTime();
        double deltaTime = 0;
        while(gameThread != null)
        {
            long currentTime = System.nanoTime();

            deltaTime = currentTime - lastTime;
            lastTime = currentTime;

            update(deltaTime/1000000000);
            repaint();
        }
    }

    public void update(double deltaTime)
    {
        player.update(deltaTime);
    }


    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        player.paint(g2);

        g2.dispose();
    }

    public void addNotify()
    {
        super.addNotify();
        requestFocus();
    }
}
