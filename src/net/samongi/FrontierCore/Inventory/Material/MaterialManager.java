package net.samongi.FrontierCore.Inventory.Material;

import java.util.HashMap;
import java.util.Set;

import net.samongi.SamongiLib.Items.ItemUtil;

import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.material.MaterialData;

public class MaterialManager
{
  private HashMap<String, MaterialType> types = new HashMap<>();
  
  /**Registers the material type with the manager
   * 
   * @param type
   */
  public void register(MaterialType type){this.types.put(type.getKeyName(), type);}
  
  /**Will parse a configuration and register all material types found in the section
   * 
   * @param section
   */
  public void parseConfiguration(ConfigurationSection section)
  {
    Set<String> keys = section.getKeys(false);
    for(String k : keys)
    {
      MaterialType type = MaterialType.parseConfiguration(k, section.getConfigurationSection(k));
      if(type == null) continue;
      
      this.register(type);
    }
  }
}
