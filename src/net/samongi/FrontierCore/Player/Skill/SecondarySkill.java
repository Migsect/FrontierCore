package net.samongi.FrontierCore.Player.Skill;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public enum SecondarySkill implements Skill
{
  SWORDS            ("Swords",            ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.FIGHTING),
  AXES              ("Axes",              ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.FIGHTING),
  
  BOWS              ("Bows",              ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.ARCHERY),
  THROWN            ("Thrown",            ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.ARCHERY),
  
  WANDS             ("Wands",             ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.SORCERY),
  ABILITIES         ("Abilities",         ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          PrimarySkill.SORCERY),

  HEAVY_ARMOR       ("Heavy Armor",       ChatColor.RED,          new MaterialData(Material.IRON_CHESTPLATE),     PrimarySkill.ARMOR),
  LIGHT_ARMOR       ("Light Armor",       ChatColor.RED,          new MaterialData(Material.IRON_CHESTPLATE),     PrimarySkill.ARMOR),
  
  EXCAVATION        ("Excavation",        ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.MINING),
  PROSPECTING       ("Prospecting",       ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.MINING),
  
  WOODCUTTING       ("Woodcutting",       ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.FORESTRY),
  SURVIVAL          ("Survival",          ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.FORESTRY),
  
  AGRICULTURE       ("Agriculture",       ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.HERBALISM),
  BIOLOGY           ("Biology",           ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.HERBALISM),
  
  HUNTING           ("Hunting",           ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.BUTCHERING),
  SLAUGHTERING      ("Slaughtering",      ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            PrimarySkill.BUTCHERING),
  
  ARMOR_SMITHING    ("Armor Smithing",    ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.SMITHING),
  WEAPON_SMITHING   ("Weapon Smithing",   ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.SMITHING),
  TOOL_SMITHING     ("Tool Smithing",     ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.SMITHING),
  
  BREWING           ("Brewing",           ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.ALCHEMY),
  ENCHANTING        ("Enchanting",        ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.ALCHEMY),
  ARTIFICING        ("Inscription",       ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.ALCHEMY),
  
  FLETCHING         ("Fletching",         ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.CRAFTING),
  COOKING           ("Cooking",           ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.CRAFTING),
  CONSTRUCTION      ("Construction",      ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           PrimarySkill.CRAFTING);
  
  private static final String DATA_PREFIX = "skill.primary";
  
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  private final Skill parent_skill;
  
  SecondarySkill(String display_name, ChatColor display_color, MaterialData display_material, Skill parent_skill)
  {
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
    this.parent_skill = parent_skill;
  }
  
  @Override public String getDataKey(){return SecondarySkill.DATA_PREFIX + "." + this.toString().toLowerCase();}

  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}

  @Override public Skill getParent(){return this.parent_skill;}
  @Override public Skill[] getChildren(){return null;}

}
