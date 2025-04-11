public class Runner {
    public static void main(String args[])
    {
        Frame frame = new Frame();
        GamePanel panel = new GamePanel();
        frame.add(panel);
        panel.startGameThread();

        frame.setVisible(true);
    }
}
