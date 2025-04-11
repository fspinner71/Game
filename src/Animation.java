import java.awt.image.*;

public class Animation {

    public static final int IDLE = 0;
    public static final int MOVEMENT = 1;
    public static final int ACTION = 2;

    private BufferedImage spriteSheet;
    private int frameRate;
    private boolean looped;
    private int priority;
    private int length;
    private int x, y;
    private int width, height;
    private int padding;

    private boolean playing;
    private double totalTime;
    private int currentIndex = -1;
    private BufferedImage currentImage;

    public Animation(BufferedImage spriteSheet, int frameRate, boolean looped, int priority, int length, int x, int y, int width, int height, int padding)
    {
        this.spriteSheet = spriteSheet;
        this.frameRate = frameRate;
        this.looped = looped;
        this.priority = priority;
        this.length = length;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        playing = false;

        currentImage = spriteSheet.getSubimage(x, y, width, height);
    }
    public void play()
    {
        playing = true;
        totalTime = 0;
        currentIndex = -1;
    }
    public void stop()
    {
        playing = false;
    }
    public void update(double deltaTime)
    {
        if(playing)
        {
            totalTime += deltaTime;

            int i = (int)(length * (totalTime % ((double)length/frameRate)/((double)length/frameRate)));

            if(i != currentIndex)
            {
                currentIndex = i;
                currentImage = spriteSheet.getSubimage(x + i * (width + padding) , y, width, height);
            }

            if(!looped && totalTime > (length/frameRate))
            {
                playing = false;
            }
        }
    }
    public BufferedImage getCurrentImage()
    {
        return currentImage;
    }
    public boolean isPlaying()
    {
        return playing;
    }
    public void setFrameRate(int frameRate)
    {
        this.frameRate = frameRate;
    }
    public void setLooped(boolean looped)
    {
        this.looped = looped;
    }
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
    public int getPriority()
    {
        return priority;
    }
}
