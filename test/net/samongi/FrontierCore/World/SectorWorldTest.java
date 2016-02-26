package net.samongi.FrontierCore.World;

import static org.junit.Assert.*;
import net.samongi.Test.FakeWorld;

import org.bukkit.Location;
import org.junit.Test;

public class SectorWorldTest
{
  private static final double EPSILON = 0.00001;
  
  private static final FakeWorld w_0 =    new FakeWorld();
  
  private static final Location l_0 =     new Location(w_0, 0, 64, 0);
  
  private static final Location l_1_0 =   new Location(w_0, 1, 64, 0);
  private static final Location l_1_1 =   new Location(w_0, 0, 64, 1);
  private static final Location l_1_2 =   new Location(w_0, 1, 64, 0);
  private static final Location l_1_3 =   new Location(w_0, 0, 64, 1);
  
  private static final Location l_2_0 =   new Location(w_0, 100, 64, 0);
  
  private static final Location l_3_0 =   new Location(w_0, 0, 64, 200);
  private static final Location l_3_1 =   new Location(w_0, 0, 64, 201);
  private static final Location l_3_2 =   new Location(w_0, 0, 64, -201);
  
  private static final Location l_4_0 =   new Location(w_0, 0, 0, 0);
  private static final Location l_4_1 =   new Location(w_0, 0, 32, 0);
  private static final Location l_4_2 =   new Location(w_0, 100, 32, 0);

  private static final Location l_5 =     new Location(w_0, -201, 64, 0);
  
  private static final SectorWorld s_1 =  new SectorWorld(l_0, 200, 10, 0); // No height addition
  private static final SectorWorld s_2 =  new SectorWorld(l_0, 200, 10, 1); 
  private static final SectorWorld s_3 =  new SectorWorld(l_0, 200, 10, 100); 
  
  @Test public void getDistance_0(){assertEquals(0, s_1.getDistance(l_0), 0.00001);}
  @Test public void getDistance_1()
  {
    assertEquals(1, s_1.getDistance(l_1_0), EPSILON);
    assertEquals(1, s_1.getDistance(l_1_1), EPSILON);
    assertEquals(1, s_1.getDistance(l_1_2), EPSILON);
    assertEquals(1, s_1.getDistance(l_1_3), EPSILON);
  }
  @Test public void getDistance_2()
  {
    assertEquals(100, s_1.getDistance(l_2_0), EPSILON);
    assertEquals(200, s_1.getDistance(l_3_0), EPSILON);
  }
  
  @Test public void getTier_0(){assertEquals(0, s_1.getTier(l_0));}
  @Test public void getTier_1(){assertEquals(1, s_1.getTier(l_1_0));}
  @Test public void getTier_2()
  {
    assertEquals(1, s_1.getTier(l_3_0));
    assertEquals(2, s_1.getTier(l_3_1));
  }
  
  @Test public void getLevel_0(){assertEquals(0, s_1.getLevel(l_0));}
  @Test public void getLevel_1(){assertEquals(1, s_1.getLevel(l_1_0));}
  @Test public void getLevel_2(){assertEquals(10, s_1.getLevel(l_2_0));}
  @Test public void getLevel_3(){assertEquals(11, s_2.getLevel(l_4_2));}
  
  @Test public void getLevelBase_0(){assertEquals(0, s_1.getLevelBase(l_0));}
  @Test public void getLevelBase_1(){assertEquals(1, s_1.getLevelBase(l_1_0));}
  @Test public void getLevelBase_3(){assertEquals(10, s_1.getLevelBase(l_2_0));}
  @Test public void getLevelBase_4(){assertEquals(20, s_1.getLevelBase(l_3_0));}
  @Test public void getLevelBase_5(){assertEquals(21, s_1.getLevelBase(l_3_1));}
  
  @Test public void getLevelHeightMod_0(){assertEquals(0, s_1.getLevelHeightMod(l_0), EPSILON);}
  @Test public void getLevelHeightMod_1(){assertEquals(0, s_1.getLevelHeightMod(l_1_0), EPSILON);}
  @Test public void getLevelHeightMod_2(){assertEquals(0, s_1.getLevelHeightMod(l_2_0), EPSILON);}
  @Test public void getLevelHeightMod_3_0(){assertEquals(0, s_2.getLevelHeightMod(l_0), EPSILON);}
  @Test public void getLevelHeightMod_3_1(){assertEquals(1, s_2.getLevelHeightMod(l_4_0), EPSILON);}
  @Test public void getLevelHeightMod_3_1_0(){assertEquals(100, s_3.getLevelHeightMod(l_4_0), EPSILON);}
  @Test public void getLevelHeightMod_3_2(){assertEquals(0.25, s_2.getLevelHeightMod(l_4_1), EPSILON);}
  
  @Test public void getSector_0(){assertEquals(0, s_1.getSector(l_0));}
  @Test public void getSector_1(){assertEquals(0, s_1.getSector(l_1_0));}
  @Test public void getSector_2(){assertEquals(0, s_1.getSector(l_3_0));}
  @Test public void getSector_3(){assertEquals(0, s_1.getSector(l_3_1));}
  @Test public void getSector_4(){assertEquals(1, s_1.getSector(l_3_2));}
  @Test public void getSector_5(){assertEquals(2, s_1.getSector(l_5));}
}
