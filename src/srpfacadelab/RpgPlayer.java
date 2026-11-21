package srpfacadelab;

import java.util.List;
import java.util.ArrayList;


public class RpgPlayer {
    public static final int MAX_CARRYING_CAPACITY = 1000;

    private final IGameEngine gameEngine;

    private int health;

    private int maxHealth;

    private Inventory inventory;


    public RpgPlayer(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        inventory = new Inventory(MAX_CARRYING_CAPACITY);
        
    }


    public Inventory getInventory()
    {
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public IGameEngine getGameEngine()
    {
        return gameEngine;
    }

    

    

    

    
}
