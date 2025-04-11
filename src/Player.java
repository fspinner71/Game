import java.awt.image.*;
import java.io.File;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;

public class Player extends Entity {
    private static BufferedImage spriteSheet;

    private AnimationController animationController;
    private KeyHandler keyHandler;

    static
    {
        try
        {
            spriteSheet = ImageIO.read(new File("src/Assets/Images/Test/SpriteSheet.png"));
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }

    public Player()
    {
        animationController = super.getAnimationController();
        keyHandler = new KeyHandler();

        keyHandler.addMapping("Right", KeyEvent.VK_D);
        keyHandler.addMapping("Left", KeyEvent.VK_A);
        keyHandler.addMapping("Down", KeyEvent.VK_S);
        keyHandler.addMapping("Up", KeyEvent.VK_W);

        Animation idle = new Animation(spriteSheet, 12, true, Animation.IDLE, 5, 0, 0, 60, 93, 0);
        Animation forwardWalk = new Animation(spriteSheet, 12, true, Animation.MOVEMENT, 5, 0, 94, 74, 92, 0);
        Animation backwardWalk = new Animation(spriteSheet, 12, true, Animation.MOVEMENT, 6, 444, 94, 74, 92, 0);

        animationController.addAnimation("Idle", idle);
        animationController.addAnimation("ForwardWalk", forwardWalk);
        animationController.addAnimation("BackwardWalk", backwardWalk);

        animationController.play("Idle");
        
    }

    public KeyHandler getKeyHandler()
    {
        return keyHandler;
    }

    @Override
    public void update(double deltaTime)
    {
        super.update(deltaTime);
        animationController.update(deltaTime);

        int moveX = 0;

        if(keyHandler.isPressed("Right"))
        {
            moveX += getSpeed();
        }
        if(keyHandler.isPressed("Left"))
        {
            moveX -= getSpeed();
        }

        if(moveX > 0)
        {
            animationController.stop("BackwardWalk");
            animationController.play("ForwardWalk");
        } else if(moveX == 0)
        {
            animationController.stop("BackwardWalk");
            animationController.stop("ForwardWalk");
        } else if(moveX < 0)
        {
            animationController.play("BackwardWalk");
            animationController.stop("ForwardWalk");
        }

        setXVel(moveX);

        addX(getXVel() * deltaTime);
        addY(getYVel() * deltaTime);
    }
}
