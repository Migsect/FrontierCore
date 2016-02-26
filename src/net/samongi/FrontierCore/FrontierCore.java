package net.samongi.FrontierCore;

import java.util.logging.Logger;

import net.samongi.FrontierCore.Debug.FrontierLogger;

import org.bukkit.plugin.java.JavaPlugin;

public class FrontierCore extends JavaPlugin
{
  private static FrontierCore instance;
  public static FrontierCore instance(){return FrontierCore.instance;}
  
  private static FrontierLogger logger;
  public static FrontierLogger logger(){return FrontierCore.logger;}
  
  
  @Override
  public void onEnable()
  {
    FrontierCore.instance = this; // setting up the static instance of this class
    
    FrontierCore.logger = new FrontierLogger(Logger.getLogger("Minecraft")); // Setting up the logger
    FrontierCore.logger.parseConfiguration(this.getConfig().getConfigurationSection("logger")); // parsing the logger configuration
  }
  @Override
  public void onDisable()
  {
    
  }
}
