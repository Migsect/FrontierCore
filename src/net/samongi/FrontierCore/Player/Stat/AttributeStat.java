package net.samongi.FrontierCore.Player.Stat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public enum AttributeStat implements Stat
{
  
  STRENGTH      ("Strength",          ChatColor.RED,            new MaterialData(Material.WOOD_SWORD)),       
  DEXTERITY     ("Dexterity",         ChatColor.GREEN,          new MaterialData(Material.BOW)),              
  INTELLECT     ("Intellect",         ChatColor.BLUE,           new MaterialData(Material.STICK)),           
  
  VITALITY      ("Vitality",          ChatColor.GOLD,           new MaterialData(Material.GOLDEN_APPLE)),     
  ENDURANCE     ("Endurance",         ChatColor.DARK_GREEN,     new MaterialData(Material.GOLDEN_CARROT)),   
  DISCIPLINE    ("Discipline",        ChatColor.LIGHT_PURPLE,   new MaterialData(Material.POTION)),           
  
  RESILIENCE    ("Resilience",        ChatColor.YELLOW,         new MaterialData(Material.IRON_CHESTPLATE)),  
  VIGOR         ("Vigor",             ChatColor.AQUA,           new MaterialData(Material.LEATHER_BOOTS)),    
  SPIRIT        ("Spirit",            ChatColor.DARK_PURPLE,    new MaterialData(Material.GHAST_TEAR));       

  private static final String DATA_PREFIX = "stat.attribute";
  
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  AttributeStat(String display_name, ChatColor display_color, MaterialData display_material)
  {
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
  }
  
  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}
  @Override public String getDataKey(){return AttributeStat.DATA_PREFIX + "." + this.toString().toLowerCase();}
}
