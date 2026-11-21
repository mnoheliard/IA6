package srpfacadelab;

import java.util.List;
import java.util.ArrayList;
public class Inventory {
    private List<Item> inventory;
    // How much the player can carry in pounds
    private int carryingCapacity;
    private int armour;

    public Inventory(int carryingCapacity)
    {
        this.inventory = new ArrayList<>();
        this.carryingCapacity = carryingCapacity;
        this.armour = 0;
    }

    public boolean canAddItem(Item item)
    {
        return (calculateInventoryWeight() + item.getWeight() <= carryingCapacity);
    }

    public boolean checkIfItemExistsInInventory(Item item) {
        for (Item i: inventory) {
            if (i.getId() == item.getId())
                return true;
        }
        return false;
    }
    public void addItem(Item item)
    {
        inventory.add(item);
        armour += item.getArmour();
    }
    public int calculateInventoryWeight() {
        int sum=0;
        for (Item i: inventory) {
            sum += i.getWeight();
        }
        return sum;
    }

    public List<Item> getInventory()
    {
        return inventory;
    }
    public int getCarryingCapacity() {
        return carryingCapacity;
    }

    public int getArmour() {
        return armour;
    }
}
