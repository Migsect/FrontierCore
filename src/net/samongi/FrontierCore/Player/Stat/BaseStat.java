package net.samongi.FrontierCore.Player.Stat;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

/**
 * 
 *
 */
public enum BaseStat implements Stat
{
  MELEE_DAMAGE                  ("Melee Damage Bonus",        ChatColor.RED,          new MaterialData(Material.IRON_SWORD)),
  RANGE_DAMAGE                  ("Range Damage Bonus",        ChatColor.GREEN,        new MaterialData(Material.BOW)),
  MAGIC_DAMAGE                  ("Magic Damage Bonus",        ChatColor.BLUE,         new MaterialData(Material.BLAZE_ROD)),
  
  MELEE_CRITICAL                ("Melee Critical Bonus",      ChatColor.RED,          new MaterialData(Material.IRON_SWORD)),
  RANGE_CRITICAL                ("Range Critical Bonus",      ChatColor.GREEN,        new MaterialData(Material.BOW)),
  MAGIC_CRITICAL                ("Magic Critical Bonus",      ChatColor.BLUE,         new MaterialData(Material.BLAZE_ROD)),
  
  MELEE_CRITICAL_DAMAGE         ("Melee Critical Bonus",      ChatColor.RED,          new MaterialData(Material.IRON_SWORD)),
  RANGE_CRITICAL_DAMAGE         ("Range Critical Bonus",      ChatColor.GREEN,        new MaterialData(Material.BOW)),
  MAGIC_CRITICAL_DAMAGE         ("Magic Critical Bonus",      ChatColor.BLUE,         new MaterialData(Material.BLAZE_ROD)),

  LIFE_BASE                     ("Life Base",                 ChatColor.RED,          new MaterialData(Material.GOLDEN_APPLE)),
  LIFE_BONUS                    ("Life Bonus",                ChatColor.RED,          new MaterialData(Material.GOLDEN_APPLE)),
  LIFE_COST_EFFICIENCY          ("Life Cost Efficiency",      ChatColor.RED,          new MaterialData(Material.GOLDEN_APPLE)),
  LIFE_REGEN                    ("Life Regeneration",         ChatColor.RED,          new MaterialData(Material.GOLDEN_APPLE)),
  
  STAM_BASE                     ("Stam Base",                 ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  STAM_BONUS                    ("Stam Bonus",                ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  STAM_COST_EFFICIENCY          ("Stam Cost Efficiency",      ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  STAM_REGEN                    ("Stam Regeneration",         ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  
  MANA_BASE                     ("Life Base",                 ChatColor.BLUE,         new MaterialData(Material.POTION)),
  MANA_BONUS                    ("Life Bonus",                ChatColor.BLUE,         new MaterialData(Material.POTION)),
  MANA_COST_EFFICIENCY          ("Life Cost Efficiency",      ChatColor.BLUE,         new MaterialData(Material.POTION)),
  MANA_REGEN                    ("Life Regeneration",         ChatColor.BLUE,         new MaterialData(Material.POTION)),
  
  KNOCKBACK_BONUS               ("Knockback Bonus",           ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  KNOCKBACK_REDUCATION          ("Knockback Resistance",      ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  
  MELEE_CRITICAL_AVOIDANCE      ("Melee Critical Avoidance",  ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  RANGE_CRITICAL_AVOIDANCE      ("Range Critical Avoidance",  ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  MAGIC_CRITICAL_AVOIDANCE      ("Magic Critical Avoidance",  ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  
  MELEE_CRITICAL_RESISTANCE     ("Melee Critical Resistance", ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  RANGE_CRITICAL_RESISTANCE     ("Range Critical Resistance", ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  MAGIC_CRITICAL_RESISTANCE     ("Magic Critical Resistance", ChatColor.GOLD,         new MaterialData(Material.GRASS)),
  
  SPRINT_BASE                   ("Sprint Base",               ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  SPRINT_BONUS                  ("Sprint Bonus",              ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  SPRINT_COST_EFFICIENCY        ("Sprint Cost Efficiency",    ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT)),
  SPRINT_REGEN                  ("Sprint Regen",              ChatColor.GREEN,        new MaterialData(Material.GOLDEN_CARROT));
  
  private final static String DATA_PREFIX = "stat.base";
  
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  private BaseStat(String display_name, ChatColor display_color, MaterialData display_material)
  {
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
  }
  
  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}
  public String getDataKey(){return BaseStat.DATA_PREFIX + "." + this.toString().toLowerCase();}
}
