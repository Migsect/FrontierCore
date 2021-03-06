package net.samongi.FrontierCore.Inventory.Equipment;

import net.samongi.FrontierCore.Utility.Displayable;

import org.bukkit.ChatColor;
import org.bukkit.material.MaterialData;

public class EquipmentType implements Displayable
{
  private final String key_name;
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  EquipmentType(String key_name, String display_name, ChatColor display_color, MaterialData display_material)
  {
    this.key_name = key_name.toUpperCase().replace(' ', '_'); // converting it to a true key
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
  }
  
  public String getKeyName(){return this.key_name;}
  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}
  
  public boolean equals(EquipmentType other){return this.key_name.equals(other.key_name);}
}
