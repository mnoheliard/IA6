package srpfacadelab;

import java.util.List;

public class Facade {
    private final IGameEngine gameEngine;
    private final ItemEffectHandler itemEffectHandler;
    private final DamageHandler damageHandler;

    public Facade(IGameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.itemEffectHandler = new ItemEffectHandler(gameEngine);
        this.damageHandler = new DamageHandler(gameEngine);
    }

    public boolean pickUpItem(RpgPlayer player, Item item) {
        Inventory inventory = player.getInventory();

        if (!inventory.canAddItem(item)) {
            return false;
        }

        if (item.isUnique() && inventory.checkIfItemExistsInInventory(item)) {
            return false;
        }

        if (itemEffectHandler.handleHealingOrPickup(player, item)) {
            return true;
        }

        itemEffectHandler.triggerRarityEffects(item);

        inventory.addItem(item);
        return true;
    }

    public void takeDamage(RpgPlayer player, int damage) {
        damageHandler.toTakeDamage(player, damage);
    }


    public void useItem(RpgPlayer player, Item item) {
        if (item.getName().equals("Stink Bomb"))
        {
            List<IEnemy> enemies = gameEngine.getEnemiesNear(player);

            for (IEnemy enemy: enemies){
                enemy.takeDamage(100);
            }
        }
    }
}
