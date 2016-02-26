package net.samongi.FrontierCore.Inventory.Material;

import java.util.HashMap;

public class MaterialInventory
{
  /**Hashmap that stores the inventory
   */
  private HashMap<MaterialType, HashMap<Integer, Double>> materials = new HashMap<>();
  
  /**Will generate a new instance of the material type and quality in this inventory
   * and will initialize it to be equal to 0.
   * 
   * @param type The type to initialize
   * @param quality The quality to initialize
   */
  private void generate(MaterialType type, Integer quality)
  {
    if(!materials.containsKey(type)) materials.put(type, new HashMap<Integer, Double>());
    HashMap<Integer, Double> material_qualities = materials.get(type);
    if(!material_qualities.containsKey(quality)) material_qualities.put(quality, 0.0);
  }
  
  /**Returns true if the inventory has more than zero of the specified
   * material type with the quality.
   * 
   * @param type The type of the material
   * @param quality The quality level of the material
   * @return True if the inventory has more than zero of the material with quality
   */
  private boolean has(MaterialType type, Integer quality)
  {
    if(!materials.containsKey(type)) return false;
    if(!materials.get(type).containsKey(quality)) return false;
    if(!(materials.get(type).get(quality) <= 0)) return false;
    return true;
  }
  
  /**Adds the specified amount of the material into the inventory
   * 
   * @param type The type of the material
   * @param quality The quality of the material
   * @param amount The amount of the material
   * @return The inventory that was added to
   */
  public MaterialInventory add(MaterialType type, Integer quality, Double amount)
  {
    this.generate(type, quality);
    this.materials.get(type).put(quality, this.materials.get(type).get(quality) + amount);
    
    return this;
  }
  
  /**Sets the amount of the material in this inventory
   * 
   * @param type The type of the material
   * @param quality The quality of the material
   * @param amount The amount to set it to
   * @return The inventory that was just set in
   */
  public MaterialInventory set(MaterialType type, Integer quality, Double amount)
  {
    this.generate(type, quality);
    this.materials.get(type).put(quality, amount);
    
    return this;
  }
  /**Returns the amount of the material in this inventory
   * 
   * @param type The type of the material item
   * @param quality The quality of the material item
   * @return The amount of the material 
   */
  public double get(MaterialType type, Integer quality)
  {
    if(this.has(type, quality)) return this.materials.get(type).get(quality);
    return 0;
  }
}
