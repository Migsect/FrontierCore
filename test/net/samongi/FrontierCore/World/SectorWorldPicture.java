package net.samongi.FrontierCore.World;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.samongi.Test.FakeWorld;

import org.bukkit.Location;

public class SectorWorldPicture
{
  private static final FakeWorld f_world = new FakeWorld();
  private static final File save_to = new File("T:\\PictureLibrary\\capt\\scratch");
  
  /**Creates a picture of sections and levels
   * 
   * @param args
   */
  public static void main(String[] args)
  {
    int w = 1920;
    int h = 1080;
    double s = 1;
    
    double r_ratio = 1.0;
    double g_ratio = 1.0;
    double b_ratio = 1.0;
    
    int r_shift = 0;
    int g_shift = 0;
    int b_shift = 255;

    Location origin = new Location(f_world, 0, 64, 0);
    int t_rate = 200;
    int l_rate = 25;
    int h_mod = 0;
    SectorWorld s_world =  new SectorWorld(origin, t_rate, l_rate, h_mod);
    
    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    
    // getting a matrix of infor about each
    int[][] t_matrix = tierMatrix(w, h, s_world, s);
    int[][] l_matrix = levelMatrix(w, h, s_world, s);
    int[][] s_matrix = sectorMatrix(w, h, s_world, s);
    
    // getting the max values of the matrices
    double t_max = getMax(t_matrix);
    double l_max = getMax(l_matrix);
    double s_max = getMax(s_matrix);
    // Printing out maxes:
    System.out.println("Tier Max:   " + t_max);
    System.out.println("Level Max:  " + l_max);
    System.out.println("Sector Max: " + s_max);
    
    // generating the image
    for(int x = 0; x < w; x++) for(int y = 0; y < h; y++)
    {
      int r = (int) (r_ratio * 255 * t_matrix[x][y] / t_max);
      int g = (int) (g_ratio * 255 * l_matrix[x][y] / l_max);
      int b = (int) (b_ratio * 255 * s_matrix[x][y] / s_max);
      
      if(r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) System.out.println("!!! ("+ r + ", " + g + ", " + b + ") " + "t:" + t_matrix[x][y] + ", l:" + l_matrix[x][y] + ", s:" + s_matrix[x][y]);
      // else                              System.out.println("... ("+ r + ", " + g + ", " + b + ")");
      Color color = new Color(Math.abs(r_shift - r), Math.abs(g_shift - g), Math.abs(b_shift - b));
      img.setRGB(x, y, color.getRGB());
    }
    
    String file_name = "sectors_" + w + "x" + h + "_t" + t_rate + "_l" + l_rate + "_h" + h_mod + "_r" + r_ratio + "x" + r_shift + "_g" + g_ratio + "x" + g_shift + "_b" + b_ratio + "x" + b_shift + ".png"; 
    File save_file = new File(save_to, file_name);
    try{ImageIO.write(img, "png", save_file);} catch (IOException e){}
  }
  
  public static int[][] tierMatrix(int x_max, int y_max, SectorWorld s_world, double scale)
  {
    int[][] matrix = new int[x_max][y_max];
    for(int x = 0; x < x_max; x++) for(int y = 0; y < y_max; y++)
    {
      Location l = new Location(f_world, (x - x_max/2) * scale, 64, (y - y_max/2) * scale);
      matrix[x][y] = s_world.getTier(l);
    }
    return matrix;
  }
  public static int[][] levelMatrix(int x_max, int y_max, SectorWorld s_world, double scale)
  {
    int[][] matrix = new int[x_max][y_max];
    for(int x = 0; x < x_max; x++) for(int y = 0; y < y_max; y++)
    {
      Location l = new Location(f_world, (x - x_max/2) * scale, 64, (y - y_max/2) * scale);
      matrix[x][y] = s_world.getLevel(l);
    }
    return matrix;
  }
  public static int[][] sectorMatrix(int x_max, int y_max, SectorWorld s_world, double scale)
  {
    int[][] matrix = new int[x_max][y_max];
    for(int x = 0; x < x_max; x++) for(int y = 0; y < y_max; y++)
    {
      Location l = new Location(f_world, (x - x_max/2) * scale, 64, (y - y_max/2) * scale);
      matrix[x][y] = s_world.getSector(l);
    }
    return matrix;
  }
  
  public static int getMax(int[][] matrix)
  {
    int max = 0;
    for(int[] a : matrix) for(int i : a) if(i > max) max = i;
    return max;
  }
  
}
