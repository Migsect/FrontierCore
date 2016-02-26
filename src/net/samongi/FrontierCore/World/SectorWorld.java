package net.samongi.FrontierCore.World;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class SectorWorld
{
  //private static final double DEF_ORIGIN_X = 0;
  private static final double DEF_ORIGIN_Y = 64;
  //private static final double DEF_ORIGIN_Z = 0;
  
  private final Location origin;
  private final double tier_distance;   // The distance it takes for the world to go up a tier
  private final double level_distance;  // The distance it takes for the world to go up a level
  
  private final double height_coefficient; // Used in the equation to determine the levels added by height
  
  public SectorWorld(Location o, double tier_distance, double level_distance, double height_coefficient)
  {
    this.origin = o.clone();
    
    this.tier_distance = tier_distance;
    this.level_distance = level_distance;
    this.height_coefficient = height_coefficient;
  }
  
  /**Returns the distance from the location to the center of the sector world
   * 
   * @param location The location
   * @return the distance between the origin and the 
   */
  public double getDistance(Location location)
  {
    Vector o = new Vector(this.origin.getX(), DEF_ORIGIN_Y, this.origin.getZ());
    Vector l = new Vector(location.getX(), DEF_ORIGIN_Y, location.getZ());
    return o.distance(l);
  }
  
  /**Returns a copy of the origin of the SectorWorld
   * 
   * @return The origin location
   */
  public Location getOrigin(){return this.origin.clone();}
  
  /**Gets the level of a location in the world
   * 
   * @param location The location to get the level of
   * @return The level of the location
   */
  public int getLevel(Location location)
  {
    double distance = this.getDistance(location);
    
    double height = location.getY();
    double sea_level = this.origin.getY();
    
    // getting the base
    double base = distance / this.level_distance;
    // getting the 
    double height_mod = this.height_coefficient * Math.pow((height / sea_level) - 1, 2);
    
    return (int) Math.ceil(base + height_mod);
  }
  
  /**Used to test "getLevel"
   * Will return the base level of a location disregarding the height in the world
   * 
   * @param location
   * @return
   */
  public int getLevelBase(Location location)
  {
    double distance = this.getDistance(location);
    return (int) Math.ceil(distance / this.level_distance);
  }
  /**Used to test "getLevel"
   * Will return the modifier for levels at the location based on the height
   * 
   * @param location
   * @return
   */
  public double getLevelHeightMod(Location location)
  {
    double height = location.getY();
    double sea_level = this.origin.getY();
    
    return this.height_coefficient * Math.pow((height / sea_level) - 1, 2);
  }
  
  /**Gets the tier of the location in the world
   * 
   * @param location The location in their world.
   * @return The tier of the location
   */
  public int getTier(Location location)
  {
    double distance = this.getDistance(location);
    if(distance == 0) return 1;
    return (int) Math.ceil(distance / this.tier_distance);
  }

  /**Will normalize the angle to be within 0 and 2pi
   * 
   * @param angle An angle to normalize
   * @return The normalized angle
   */
  private static double normalizeAngle(double angle)
  {
    if(angle < 0) return normalizeAngle(angle + 2 * Math.PI);
    if(angle >= 2 * Math.PI) return normalizeAngle(angle - 2 * Math.PI);
    return angle;
  }
  
  /**Returns the sector of the location
   * 
   * @param location
   * @return
   */
  public int getSector(Location location)
  {
    double distance = this.getDistance(location); 
    int tier = (int) Math.ceil(distance / this.tier_distance);
    if(distance == 0) tier = 1;
    
    /*
    Vector v = location.toVector();
    Vector u = null; // setting up the direction vector
    if(tier % 2 == 0) u = new Vector(1,0,0); // even case
    else u = new Vector(-1,0,0); // odd case
    */

    int sector_count = 2 * tier - 1; // Gets the number of sectors for the tier of the location
    double theta_o = 2*Math.PI / sector_count; // Gets the degrees for the location
    // double theta = Math.acos(v.dot(u) / distance); // getting the angle from the unit vector
    
    double theta = Math.atan2(location.getX(), location.getBlockZ());
    if(tier % 2 == 0) theta += Math.PI;
    theta = normalizeAngle(theta);
    if(theta < 0) System.out.println("Theta was less than zero!");
    if(theta >= Math.PI * 2) System.out.println("Theta was greater than 2*PI!");
    
    return (int)Math.floor(theta / theta_o); // returning the sector
  }
}
