package net.samongi.FrontierCore.Inventory;

import java.util.HashMap;

import net.minecraft.server.v1_8_R3.Material;
import net.samongi.FrontierCore.Listeners.InventoryListener;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PagedInventory
{
  /**The total number of rows that each page can support
   * One row of an inventory is reserved for the page buttons.
   */
  private static final int MAX_FILLABLE_ROWS = 5;
  
  /**A page object to store each pages information
   * 
   */
  public static class InventoryPage implements InventoryListener.InventoryHandler
  {
    private final PagedInventory container; // The container of the page
    private final int page_number; // The index of the page in the paged inventory
    
    private final int max_index; // The maximum index of the items in the inventory
    
    /**All the items stored within this page
     */
    private HashMap<Integer, ItemStack> items = new HashMap<>();
    
    /**A cached inventory when this page is being viewed.
     */
    private Inventory inv = null;
    
    InventoryPage(PagedInventory container, int number)
    {
      this.page_number = number;
      this.container = container;
      this.max_index = container.getRowPerPage() * 9;
    }
    
    /**Returns the itemstack stored at the index in the inventory
     * 
     * @param index The index in the inventory.
     * @return The itemstack stored at the index
     */
    public ItemStack get(int index){return this.items.get(index);}
    
    /**This will set the itemstack at the index
     * If the inventory is currently opened then the opened inventory
     * will also be updated.
     * 
     * @param index The index that is being set
     * @param item The item being set
     */
    public void set(int index, ItemStack item)
    {
      this.items.put(index, item);
      if(inv != null) inv.setItem(index, item);
    }
    
    /**Returns the page that was previous to this page
     * 
     * @return The previous page
     */
    public InventoryPage prev(){return this.next(-1);}
    
    /**Returns the next page to this page
     * 
     * @return
     */
    public InventoryPage next(){return this.next(1);}
    
    /**returns the page that is the next n pages away
     * 
     * @param num The number of pages to count to get to the next page
     * @return The next page
     */
    public InventoryPage next(int num)
    {
      // Case one: checks to see if the next is overshooting
      if(this.container.getPageCount() <= num + this.page_number) return this.container.getLast();
      // Case two: checks to see if the next is undershooting (with negatives)
      if(num + this.page_number < 0) return this.container.getFirst();
      // Otherwise we can just get the added
      return this.container.get(this.page_number + num);
    }
    
    /**Will generate an inventory for this page
     * If the inventory is already opened, then it will open that inventory
     * 
     * @return
     */
    public Inventory getInventory()
    {
      if(this.inv != null) return this.inv;
      
      Inventory inventory = Bukkit.createInventory(null, (this.container.getRowPerPage() + 1) * 9, "");
      for(int i = 0; i < this.max_index; i++)
      {
        ItemStack item = this.get(i);
        if(item == null) continue;
        inventory.setItem(i, item);
      }
      
      return inventory;
    }
    
    /**Synces the page with the inventory
     * 
     * @param inventory
     */
    public void syncInventory(Inventory inventory)
    {
      // Looping throw the inventory
      for(int i = 0; i < this.max_index && i < inventory.getSize(); i++)
      {
        ItemStack item = inventory.getItem(i);
        if(item == null || item.getType().equals(Material.AIR)) this.items.remove(i);
        this.items.put(i, item);
      }
    }
    
    @Override
    public void handleInventoryCloseEvent(InventoryCloseEvent event)
    {
      Inventory inventory = event.getInventory();
      
      // If we still have a viewer, don't drop the inventory
      if(inventory.getViewers().size() > 0) return;
      
      // Otherwise sync and clear
      this.syncInventory(inventory);
      this.inv = null;
      
    }
    
    
  }
  
  private final InventoryPage[] pages;
  private final int page_rows;
  private final String title;
  
  public PagedInventory(int pages, int page_rows, String title)
  {
    // Generating all the inventory pages
    this.pages = new InventoryPage[pages];
    for(int i = 0; i < this.pages.length; i++) this.pages[i] = new InventoryPage(this, i);
    
    // Calculating the page rows each page will have
    this.page_rows = page_rows;
    if(this.page_rows >= PagedInventory.MAX_FILLABLE_ROWS);
    
    // Setting the title
    this.title = title;
  }
  
  /**Gets the page at the specified index
   * This will perform wrap around if the specified index is too long
   * 
   * @param page_index The pages index
   */
  public InventoryPage get(int page_index){return this.pages[page_index % pages.length];}
  
  /**Returns the first page in the paged inventory
   * 
   * @return The first page
   */
  public InventoryPage getFirst(){return this.pages[0];}
  
  /**Returns the last page in the paged inventory
   * 
   * @return The last page
   */
  public InventoryPage getLast(){return this.pages[this.pages.length - 1];}
  
  /**Returns the number of rows each page will have
   * 
   * @return The number of rows each page has
   */
  public int getRowPerPage(){return this.page_rows;}
  
  /**Returns the number of pages in the paged inventory
   * 
   * @return The number of pages in the paged inventory
   */
  public int getPageCount(){return this.pages.length;}
  
  /**Checks to see if the page index exists
   * 
   * @param page The page index to see if exists
   * @return
   */
  public boolean exists(int page){return page >= this.pages.length || page < 0;}
  
  /**Returns the title of the inventory
   * 
   * @return The title of the paged inventory
   */
  public String getTitle(){return this.title;}
}
