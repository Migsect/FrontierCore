package net.samongi.FrontierCore.Utility;

import org.bukkit.ChatColor;
import org.bukkit.material.MaterialData;

public interface Displayable
{
  public String getDisplayName();
  public ChatColor getDisplayColor();
  public MaterialData getDisplayMaterial();
}
