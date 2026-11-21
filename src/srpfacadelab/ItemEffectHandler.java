package srpfacadelab;

public class ItemEffectHandler {
    private final IGameEngine gameEngine;
    
    public ItemEffectHandler(IGameEngine gameEngine)
    {
        this.gameEngine = gameEngine;
    }
    
    public boolean handleHealingOrPickup(RpgPlayer player, Item item) {
        if (item.getHeal() > 0) {
            int newHealth = player.getHealth() + item.getHeal();
            player.setHealth(Math.min(newHealth, player.getMaxHealth()));

            if (item.getHeal() > 500) {
                gameEngine.playSpecialEffect("green_swirly");
            }
            return true; 
        }
        return false;
    }

    public void triggerRarityEffects(Item item) {
        //check if its both rare and unique to show blue swirly effect
        if (item.isRare() && item.isUnique()) {
            gameEngine.playSpecialEffect("blue_swirly");
        } else if (item.isRare()) {
            gameEngine.playSpecialEffect("cool_swirly_particles");
        }
    }

}
