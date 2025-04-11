import javax.swing.*;

public class Frame extends JFrame
{
    public static final int WIDTH = 1920;
    public static final int HEIGHT = 1080;
    public Frame()
    {
        super("Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }
}