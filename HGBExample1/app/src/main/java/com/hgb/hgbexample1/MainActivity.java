package com.hgb.hgbexample1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import hgb.HGBCellPack;
import hgb.HGBGenerateHive;
import hgb.HGBShared;

public class MainActivity extends AppCompatActivity
{
   @Override
    protected void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      //-------------------------------------------------------------------
      // Initialize and generate a basic hexagon game board

      // There should  be one and only one instance of HGBShared.
      // This is not enforced (HGBShared is not a Singleton.)
      // The instance of HGBShared is passed down from the top
      // to all methods in need.
      HGBShared hgbShared = new HGBShared();

      // Use orientation Portrait Landscape.  (Portrait exist but
      // is not supported.)
      hgbShared.setVertexRadians(HGBShared.OrientationRadians.Landscape);

      // set your initial hive origin, cell size, and number of rings.
      float[] hiveOrigin = {350f, 450f};
      hgbShared.setHiveOrigin(hiveOrigin);
      hgbShared.setCellSize(30d);
      hgbShared.setRoseRings(4);

      HGBGenerateHive hgbGenerateHive = new HGBGenerateHive(hgbShared);
      hgbGenerateHive.generateHive_Main();
      // At this point you have a usable Hexagon Game Board
      //-------------------------------------------------------------------

      // To demonstrate:
      int cells = hgbShared.getCellCount();
      int roses = hgbShared.getRoseCount();
      int rings = hgbShared.getRoseRings();

      String msg = rings + " rings, " + roses + " roses, " + cells + " cells"; //, Cell size: " + cellSize;
      System.out.println(msg);

      float[] origin = hgbShared.getHiveOrigin();
      System.out.println("hive origin:    [0] = " + origin[0] + ", [1] = " + origin[1]);

      HGBCellPack cellPack = hgbShared.getCellPack(0);
      origin = cellPack.getOrigin();
      System.out.println("cell 0 origin:  [0] = " + origin[0] + ", [1] = " + origin[1]);

      // Should see in Debug/Console:
      //   I/System.out: 4 rings, 37 roses, 259 cells
      //       hive origin:    [0] = 350.0, [1] = 450.0
      //       cell 0 origin:  [0] = 350.0, [1] = 450.0
      // (cellIndex == 0 is the hive origin -- the center cell)

      // See HGBBasics2 to for the more complex Android code to draw the hive
   }
}
