package net.samongi.FrontierCore.Player;

import java.util.HashMap;
import java.util.UUID;

import net.samongi.FrontierCore.Data.DataMap;
import net.samongi.FrontierCore.Inventory.Material.MaterialInventory;
import net.samongi.FrontierCore.Player.Skill.CategorySkill;
import net.samongi.FrontierCore.Player.Skill.PrimarySkill;
import net.samongi.FrontierCore.Player.Skill.Skill;
import net.samongi.FrontierCore.Player.Stat.AttributeStat;
import net.samongi.FrontierCore.Player.Stat.BaseStat;
import net.samongi.FrontierCore.Player.Stat.Stat;

public class PlayerData
{
  private final UUID player;
  // private DataMap data = new DataMap();
  
  private final HashMap<Skill, Integer> skill_levels = new HashMap<>();
  private final HashMap<Skill, Integer> skill_experience = new HashMap<>();
  
  private final HashMap<Stat, Integer> stats = new HashMap<>();
  
  private MaterialInventory mat_inv = new MaterialInventory();
  
  public PlayerData(UUID player)
  {
    this.player = player;
  }
  
  public MaterialInventory getMaterialInventory(){return this.mat_inv;}
  
  /**Gets the UUID of this player data
   * 
   * @return A UUID
   */
  public UUID getPlayer(){return this.player;}
  
  /**Gets the level of the skill of this player
   * 
   * @param skill
   * @return
   */
  public int getLevel(Skill skill)
  {
    if(!skill_experience.containsKey(skill)) return 0;
    return this.skill_experience.get(skill);
  }
  
  /**Gets the experience of the skill
   * 
   * 
   * @param skill
   * @return
   */
  public int getExperience(Skill skill)
  {
    if(!skill_levels.containsKey(skill)) return 0;
    return this.skill_experience.get(skill);
  }
}
