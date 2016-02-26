package net.samongi.FrontierCore.Inventory.DropTable;

import org.bukkit.entity.Player;

public interface Droppable
{

  /**Will give the droppable to the player in any matter that 
   * the interfacing class deems neccessary
   * 
   * @param player The player getting the drop
   */
  public void give(Player player);
}
