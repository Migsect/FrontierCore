package net.samongi.FrontierCore.Player.Skill;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public enum PrimarySkill implements Skill
{
  FIGHTING      ("Fighting",          ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          CategorySkill.COMBAT),
  ARCHERY       ("Archery",           ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          CategorySkill.COMBAT),
  SORCERY       ("Sorcery",           ChatColor.RED,          new MaterialData(Material.IRON_SWORD),          CategorySkill.COMBAT),
  ARMOR         ("Armor",             ChatColor.RED,          new MaterialData(Material.IRON_CHESTPLATE),     CategorySkill.COMBAT),
  
  // HEAVY_ARMOR   ("Heavy Armor",       ChatColor.BLUE,         new MaterialData(Material.IRON_CHESTPLATE),     CategorySkill.DEFENSE),
  // MEDIUM_ARMOR  ("Medium Armor",      ChatColor.BLUE,         new MaterialData(Material.IRON_CHESTPLATE),     CategorySkill.DEFENSE),
  // LIGHT_ARMOR   ("Light Armor",       ChatColor.BLUE,         new MaterialData(Material.IRON_CHESTPLATE),     CategorySkill.DEFENSE),
  
  MINING        ("Mining",            ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            CategorySkill.GATHERING),
  FORESTRY      ("Forestry",          ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            CategorySkill.GATHERING),
  HERBALISM     ("Herbalism",         ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            CategorySkill.GATHERING),
  BUTCHERING    ("Butchering",        ChatColor.GREEN,        new MaterialData(Material.IRON_AXE),            CategorySkill.GATHERING),
  
  SMITHING      ("Smithing",          ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           CategorySkill.CRAFTING),
  ALCHEMY       ("Alchemy",           ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           CategorySkill.CRAFTING),
  CRAFTING      ("Crafting",          ChatColor.BLUE,         new MaterialData(Material.WORKBENCH),           CategorySkill.CRAFTING);
  

  private static final String DATA_PREFIX = "skill.primary";
  
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  
  private final Skill parent_skill;
  private final Skill[] children_skill;
  
  PrimarySkill(String display_name, ChatColor display_color, MaterialData display_material, Skill parent_skill)
  {
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
    this.parent_skill = parent_skill;
    
    List<Skill> children_skills = new ArrayList<>();
    for(Skill s : SecondarySkill.values()) if(s.getParent() == this) children_skills.add(s);
    this.children_skill = (Skill[]) children_skills.toArray();
  }
  
  @Override public String getDataKey(){return PrimarySkill.DATA_PREFIX + "." + this.toString().toLowerCase();}

  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}

  @Override public Skill getParent(){return this.parent_skill;}
  @Override public Skill[] getChildren(){return this.children_skill;}

}
