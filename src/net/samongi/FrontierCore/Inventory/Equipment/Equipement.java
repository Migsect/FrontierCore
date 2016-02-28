package net.samongi.FrontierCore.Inventory.Equipment;

import org.bukkit.inventory.ItemStack;

import net.samongi.FrontierCore.Inventory.Itemable;

/**Represents an equipment that a player can "equipe"
 * This is basically all armor.
 * 
 * @author Alex
 *
 */
public class Equipement implements Itemable
{
  
  private String display_name;
  
  public static Equipement fromItemstack(ItemStack item)
  {
    return null;
  }
  @Override
  public ItemStack toItemstack()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
