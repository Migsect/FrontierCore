package net.samongi.FrontierCore.Player;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerManager
{
  
  private final HashMap<UUID, PlayerData> player_data = new HashMap<>();
  
  public PlayerData getPlayerData(UUID player)
  {
    if(!player_data.containsKey(player)) player_data.put(player, this.generatePlayerData(player));
    return player_data.get(player);
  }
  public PlayerData generatePlayerData(UUID player)
  {
    PlayerData data = new PlayerData(player);
    
    // TODO Set original values
    
    return data;
  }
  
  public void onPlayerJoin(PlayerJoinEvent event)
  {
    
  }
  public void onPlayerQuit(PlayerQuitEvent event)
  {
    
  }
}
