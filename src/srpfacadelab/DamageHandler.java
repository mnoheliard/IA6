package srpfacadelab;

public class DamageHandler {
    private final IGameEngine gameEngine;

    public DamageHandler(IGameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }
    
    public void toTakeDamage(RpgPlayer player, int damage)
    {
        int armour = player.getInventory().getArmour();
        if(damage < armour)
        {
            gameEngine.playSpecialEffect("parry");
        }
        int damageToDeal = damage - armour;
        if(damageToDeal < 0)
        {
            damageToDeal =0;
        }
        //take 25% less damage if carrying under 50& of capacity
        double currentWeight = player.getInventory().calculateInventoryWeight();
        double capacityThreshold = player.getInventory().getCarryingCapacity() / 2.0;

        if (currentWeight < capacityThreshold) {
            damageToDeal = (int) (damageToDeal * 0.75);
        }

        player.setHealth(player.getHealth() - damageToDeal);
        gameEngine.playSpecialEffect("lots_of_gore");
    }
}
