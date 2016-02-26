package net.samongi.FrontierCore.Data;

import java.io.Serializable;
import java.util.HashMap;

public class DataMap implements Serializable
{
  private static final long serialVersionUID = -85828541571578160L;

  /**Data stories the string-object relations
   */
  private final HashMap<String, Object> data;
  
  private final String parent_key;
  private final DataMap parent_map;
  
  public DataMap()
  {
    this.parent_key = null;
    this.parent_map = null;
    this.data = new HashMap<>();
  }
  private DataMap(DataMap parent_map, String parent_key)
  {
    this.parent_key = parent_key;
    this.parent_map = parent_map;
    this.data = parent_map.data; // This allows it to mutate the parent's key
  }
  
  public String getParentKey(){return this.parent_key;}
  public DataMap getParentMap(){return this.parent_map;}
  /**Gets a new child map using the key
   * This effectively reduces the map down one level, removing all items
   * that do not start with the key.
   * This map is causally linked to its parent, which means any changes made here will be
   * made to the parent one as well.
   * 
   * @param key
   * @return
   */
  public DataMap getChildMap(String key){return new DataMap(this, key);}
  /**Sets the key to the object
   * This will also set the key in the parent map if it exists
   * 
   * @param key
   * @param obj
   */
  public void set(String key, Object obj)
  {
    if(parent_key == null) data.put(key, obj);
    else data.put(this.parent_key + "." + key, obj);
  }
  public boolean has(String key)
  {
    if(parent_key == null) return this.data.containsKey(key);
    else return this.parent_map.has(this.parent_key + "." + key);
  }
  
  /**Returns a pure object that is being stored within the hashmap
   * 
   * @param key The key
   * @return The object being stored
   */
  public Object get(String key)
  {
    if(this.parent_key == null) return data.get(key);
    else return data.get(this.parent_key + "." + key);
  }
  /**Returns the class of the object with the key
   * 
   * @param key The key
   * @return The object's class
   */
  public Class<?> getClass(String key)
  {
    if(!data.containsKey(key)) return null;
    return data.get(key).getClass();
  }
  /**Gets the object as a number if it is a number
   * 
   * @param key The key
   * @return A number, else null
   */
  public Number getNumber(String key)
  {
    if(!data.containsKey(key)) return null;
    if(data.get(key) instanceof Number) return (Number) data.get(key);
    return null;
  }
  /**Gets the object as an integer if it is an integer
   * 
   * @param key The key
   * @return The object as an integer if it is an integer, else null
   */
  public Integer getInteger(String key)
  {
    if(!data.containsKey(key)) return null;
    if(data.get(key) instanceof Integer) return (Integer) data.get(key);
    return null;
  }
  /**Get sthe object as a double if it is a double
   * 
   * @param key The key
   * @return The object as a double if it is a double, else null
   */
  public Double getDouble(String key)
  {
    if(!data.containsKey(key)) return null;
    if(data.get(key) instanceof Double) return (Double) data.get(key);
    return null;
  }
  public Boolean getBoolean(String key)
  {
    if(!data.containsKey(key)) return null;
    if(data.get(key) instanceof Boolean) return (Boolean) data.get(key);
    return null;
  }
  public String getString(String key)
  {
    if(!data.containsKey(key)) return null;
    if(data.get(key) instanceof String) return (String) data.get(key);
    return null;
  }
  
}
