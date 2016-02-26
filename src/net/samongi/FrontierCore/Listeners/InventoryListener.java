package net.samongi.FrontierCore.Listeners;

import java.util.HashMap;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;

public class InventoryListener implements Listener
{
  private static InventoryListener instance = null;
  /**Returns the instantiated instance of the inventory listener
   * 
   * @return the Inventory Listener
   */
  public static InventoryListener getInstance(){return InventoryListener.instance;}
  
  /**A class that depicts another class that can handle an event on an inventory
   * This consists of a lot of method calls for different events
   */
  public static interface InventoryHandler
  {
    public default void handleInventoryEvent(InventoryEvent event){}
    
    public default void handleInventoryOpenEvent(InventoryOpenEvent event){}
    public default void handleInventoryCloseEvent(InventoryCloseEvent event){}
    
    public default void handleEnchantItemEventEvent(EnchantItemEvent event){}
    public default void handlePrepareItemCraftEvent(PrepareItemCraftEvent event){}
    public default void handlePrepareItemEnchantEvent(PrepareItemEnchantEvent event){}
    public default void handleCraftItemEvent(CraftItemEvent event){}
    public default void handleInventoryCreativeEvent(InventoryCreativeEvent event){}
    
    public default void handleInventoryInteractEvent(InventoryInteractEvent event){}
    public default void handleInventoryClickEvent(InventoryClickEvent event){}
    public default void handleInventoryDragEvent(InventoryDragEvent event){}
  }
  
  // Inventory -> Priority mapping -> Handlers
  HashMap<Inventory, List<InventoryHandler>> handlers = new HashMap<>();
  
  public InventoryListener()
  {
    InventoryListener.instance = this;
  }
  
  @EventHandler
  public void onInventoryEvent(InventoryEvent event)
  {
    Inventory inventory = event.getInventory();
    List<InventoryHandler> handlers = this.handlers.get(inventory);
    if(handlers == null) return;
    
    for(InventoryHandler handler : handlers)
    {
      // always will be called
      handler.handleInventoryEvent(event);
      
      if(event instanceof InventoryOpenEvent) handler.handleInventoryOpenEvent((InventoryOpenEvent)event);
      if(event instanceof InventoryCloseEvent) handler.handleInventoryCloseEvent((InventoryCloseEvent)event);
      
      if(event instanceof EnchantItemEvent) handler.handleEnchantItemEventEvent((EnchantItemEvent)event);
      if(event instanceof PrepareItemCraftEvent) handler.handlePrepareItemCraftEvent((PrepareItemCraftEvent)event);
      if(event instanceof PrepareItemEnchantEvent) handler.handlePrepareItemEnchantEvent((PrepareItemEnchantEvent)event);
      if(event instanceof CraftItemEvent) handler.handleCraftItemEvent((CraftItemEvent)event);
      if(event instanceof InventoryCreativeEvent) handler.handleInventoryCreativeEvent((InventoryCreativeEvent)event);
      
      if(event instanceof InventoryInteractEvent) handler.handleInventoryInteractEvent((InventoryInteractEvent)event);
      if(event instanceof InventoryClickEvent) handler.handleInventoryClickEvent((InventoryClickEvent)event);
      if(event instanceof InventoryDragEvent) handler.handleInventoryDragEvent((InventoryDragEvent)event);
    }
  }
  
}
