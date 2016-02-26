package net.samongi.FrontierCore.Player.Skill;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.material.MaterialData;

public enum CategorySkill implements Skill
{
  COMBAT        ("Combat",            ChatColor.RED,          new MaterialData(Material.IRON_SWORD)),
  // DEFENSE       ("Defense",           ChatColor.BLUE,         new MaterialData(Material.IRON_CHESTPLATE)),
  GATHERING     ("Gathering",         ChatColor.GREEN,        new MaterialData(Material.IRON_AXE)),
  CRAFTING      ("Crafting",          ChatColor.YELLOW,       new MaterialData(Material.WORKBENCH));
  
  private static final String DATA_PREFIX = "skill.category";
  
  private final String display_name;
  private final ChatColor display_color;
  private final MaterialData display_material;
  private final Skill[] children_skill;
  
  CategorySkill(String display_name, ChatColor display_color, MaterialData display_material)
  {
    this.display_name = display_name;
    this.display_color = display_color;
    this.display_material = display_material;
    
    List<Skill> children_skills = new ArrayList<>();
    for(Skill s : PrimarySkill.values()) if(s.getParent() == this) children_skills.add(s);
    this.children_skill = (Skill[]) children_skills.toArray();
  }
  
  @Override public String getDataKey(){return CategorySkill.DATA_PREFIX + "." + this.toString().toLowerCase();}
  @Override public String getDisplayName(){return this.display_name;}
  @Override public ChatColor getDisplayColor(){return this.display_color;}
  @Override public MaterialData getDisplayMaterial(){return this.display_material;}

  @Override public Skill getParent(){return null;}
  @Override public Skill[] getChildren(){return this.children_skill;}

}
