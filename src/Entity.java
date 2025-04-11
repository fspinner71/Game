import java.awt.*;

public class Entity {
    private AnimationController animationController;
    private boolean walking = false;
    private boolean falling = false;
    private boolean action = false;
    private double x = 300, y = 800;
    private double xVel = 0, yVel = 0;
    private double speed = 500;

    public Entity()
    {
        animationController = new AnimationController(6);
    }
    public boolean isWalking()
    {
        return walking;
    }
    public boolean isFalling()
    {
        return falling;
    }
    public boolean inAction()
    {
        return action;
    }
    public void setX(double x)
    {
        this.x = x;
    }
    public void setY(double y)
    {
        this.y = y;
    }
    public void setXVel(double xVel)
    {
        this.xVel = xVel;
    }
    public void setYVel(double yVel)
    {
        this.yVel = yVel;
    }
    public void addX(double x)
    {
        this.x += x;
    }
    public void addY(double y)
    {
        this.y += y;
    }
    public void addXVel(double xVel)
    {
        this.xVel += xVel;
    }
    public void addYVel(double yVel)
    {
        this.yVel += yVel;
    }
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getXVel()
    {
        return xVel;
    }
    public double getYVel()
    {
        return yVel;
    }
    public void setSpeed(double speed)
    {
        this.speed = speed;
    }
    public double getSpeed()
    {
        return speed;
    }
    public AnimationController getAnimationController()
    {
        return animationController;
    }
    public void update(double deltaTime)
    {
        
    }
    public void paint(Graphics2D g)
    {
        animationController.paint((int)x, (int)y, g);
    }
}
