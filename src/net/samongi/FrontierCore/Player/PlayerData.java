package net.samongi.FrontierCore.Player;

import java.util.HashMap;
import java.util.UUID;

import net.samongi.FrontierCore.Data.DataMap;
import net.samongi.FrontierCore.Inventory.Material.MaterialInventory;
import net.samongi.FrontierCore.Player.Skill.CategorySkill;
import net.samongi.FrontierCore.Player.Skill.PrimarySkill;
import net.samongi.FrontierCore.Player.Skill.Skill;
import net.samongi.FrontierCore.Player.Stat.Attribute;
import net.samongi.FrontierCore.Player.Stat.BaseStat;
import net.samongi.FrontierCore.Player.Stat.Stat;

public class PlayerData
{
  private final UUID player;
  // private DataMap data = new DataMap();
  
  private MaterialInventory mat_inv = new MaterialInventory();
  
  public PlayerData(UUID player)
  {
    this.player = player;
  }
  
  public MaterialInventory getMaterialInventory(){return this.mat_inv;}
  
}
