

import java.util.Map;
import java.util.HashMap;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationController {
    private Map<String, Animation> animations;

    private int pixelScale = 1;
    private float anchorX = 0.5f;
    private float anchorY = 1.f;

    public AnimationController(float anchorX, float anchorY)
    {
        animations = new HashMap<String, Animation>();
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }
    public AnimationController()
    {
        animations = new HashMap<String, Animation>();
    }
    public AnimationController(float anchorX, float anchorY, int scale)
    {
        pixelScale = scale;
        animations = new HashMap<String, Animation>();
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }
    public AnimationController(int scale)
    {
        pixelScale = scale;
        animations = new HashMap<String, Animation>();
    }
    public void setScale(int scale)
    {
        pixelScale = scale;
    }
    public void addAnimation(String name, Animation animation)
    {
        animations.put(name, animation);
    }
    public void hardPlay(String name)
    {
        if(animations.containsKey(name))
        {
            animations.get(name).play();
        }
    }
    public void play(String name)
    {
        if(animations.containsKey(name))
        {
            if(!animations.get(name).isPlaying())
            {
                animations.get(name).play();
            }
        }
    }
    public void stop(String name)
    {
        if(animations.containsKey(name))
        {
            animations.get(name).stop();
        }
    }
    public void update(double deltaTime)
    {
        for(Animation v : animations.values())
        {
            if(v.isPlaying())
            {
                v.update(deltaTime);
            }
        }
    }
    public void paint(int x, int y, Graphics2D g)
    {
        Animation current = null;
        for(Animation v : animations.values())
        {
            if(v.isPlaying())
            {
                if(current == null || v.getPriority() > current.getPriority())
                {
                    current = v;
                }
            }
        }

        if(current != null)
        {
            BufferedImage img = current.getCurrentImage();
            g.drawImage(img, (int)(x - img.getWidth() * anchorX * pixelScale), (int)(y - img.getHeight() * anchorY * pixelScale), img.getWidth() * pixelScale, img.getHeight() * pixelScale, null);
        }
    }
}
