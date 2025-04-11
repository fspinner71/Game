import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.Map;
import java.util.HashMap;

public class KeyHandler implements KeyListener {
    Map<Integer, String> mappings;
    Map<String, Boolean> pressed;
    public KeyHandler()
    {
        mappings = new HashMap<Integer, String>();
        pressed = new HashMap<String, Boolean>();
    }
    public void addMapping(String name, int keyCode)
    {
        mappings.put(keyCode, name);
        pressed.put(name, false);
    }
    public boolean isPressed(String name)
    {
        if(pressed.containsKey(name))
        {
            return pressed.get(name);
        }
        return false;
    }
    @Override
    public void keyPressed(KeyEvent e)
    {
        String name = mappings.get(e.getKeyCode());
        if(name != null)
        {
            pressed.put(name, true);
        }
    }
    public void keyReleased(KeyEvent e)
    {
        String name = mappings.get(e.getKeyCode());
        if(name != null)
        {
            pressed.put(name, false);
        }
    }
    public void keyTyped(KeyEvent e)
    {

    }
}
