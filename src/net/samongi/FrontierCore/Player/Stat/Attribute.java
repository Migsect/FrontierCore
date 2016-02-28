package net.samongi.FrontierCore.Player.Stat;

import net.samongi.FrontierCore.Data.DataKeyed;
import net.samongi.FrontierCore.Utility.Displayable;

import org.bukkit.ChatColor;
import org.bukkit.material.MaterialData;

public class Attribute implements Displayable, DataKeyed
{   
  private static final String DATA_PREFIX = "stat.attribute";
  
  private final String key_name;
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  Attribute(String key_name, String display_name, ChatColor display_color, MaterialData display_material)
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
  
  @Override public String getDataKey(){return Attribute.DATA_PREFIX + "." + this.toString().toLowerCase();}
  
  public boolean equals(Attribute other){return this.key_name.equals(other.key_name);}
}
