package net.samongi.FrontierCore.Inventory.DropTable;

import org.bukkit.entity.Player;

/**
 * 
 * @author Alex
 *
 */
public class DropTable implements Droppable
{
  private final String key;
  private WeightMap<Droppable> droppables = new WeightMap<>();
  
  DropTable(String key)
  {
    this.key = key.toUpperCase().replace(' ', '_');
  }
  
  public String getKey(){return this.key;}
  
  /**Adds a drop and its weight the the droptable.
   * If it already exists then it will add the weight onto the current weight
   * 
   * @param drop
   * @param weight
   */
  public void addDrop(Droppable drop, Integer weight){this.droppables.add(drop, weight);}
  /**Will remove the drop from the drop table
   * 
   * @param drop
   */
  public void removeDrop(Droppable drop){this.droppables.remove(drop);}
  /**Will get the weight of the drop in the drop table if it exists.
   * 
   * @param drop
   * @return
   */
  public Integer getWeight(Droppable drop){return this.droppables.getWeight(drop);}
  
  /**Generates a random drop from this drop table
   * 
   * @return
   */
  public Droppable generate(){return this.droppables.getRandom();}
  
  @Override
  public void give(Player player){this.generate().give(player);}
}
