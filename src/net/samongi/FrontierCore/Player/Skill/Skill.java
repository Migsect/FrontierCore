package net.samongi.FrontierCore.Player.Skill;

import net.samongi.FrontierCore.Data.DataKeyed;
import net.samongi.FrontierCore.Utility.Displayable;

public interface Skill extends DataKeyed, Displayable
{
  public Skill getParent();
  public default boolean hasParent(){return this.getParent() != null;}
  public Skill[] getChildren();
  public default boolean hasChildren(){return this.getChildren() != null;}
}
