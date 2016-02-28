package net.samongi.FrontierCore.Inventory.Material;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.material.MaterialData;

import net.samongi.FrontierCore.Utility.Displayable;
import net.samongi.SamongiLib.Items.ItemUtil;

public class MaterialType implements Displayable
{
  private final String key_name;
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;

  MaterialType(String key_name, String display_name, ChatColor display_color, MaterialData display_material)
  {
    this.key_name = key_name.toUpperCase().replace(' ', '_'); // converting it to a true key
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
  }
  /**Will create a material type based on the configuration
   * The configuration should pass in the section that has "key" as its head.
   * This currently doesn't return null but in the future it might
   * 
   * KEY:
   *   display_name: Display Name
   *   display_color: WHITE
   *   display_material: GRASS:1
   * 
   * @param key The key, this should not have any parent keys
   * @param section The section that is received from the key
   * @return A Material type or null if the configuration is invalid
   */
  public static MaterialType parseConfiguration(String key, ConfigurationSection section)
  {
    // Getting the display name
    String display_name = section.getString("display_name", key);
    
    String display_color_str = section.getString("display_color", ChatColor.WHITE.toString()).toUpperCase();
    ChatColor display_color = ChatColor.valueOf(display_color_str);
    
    String display_material_str = section.getString("display_material", "GRASS");
    MaterialData display_material = ItemUtil.getMaterialData(display_material_str);
    
    return new MaterialType(key, display_name, display_color, display_material);
  }
  
  /**Gets the key name used for this Material Type
   * 
   * @return
   */
  public String getKeyName(){return this.key_name;}
  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}
  
  public boolean equals(MaterialType other){return this.key_name.equals(other.key_name);}
}
