package com.richhaase.gameOfLife.core;

 import org.junit.Before;
 import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

  Cell cell;
  Coordinate coordinate;

  @Before
  public void setup() throws Exception {
    coordinate = new Coordinate(3, 7);
    cell = new Cell(coordinate, false);
  }

  @Test
  public void testSpawn() throws Exception {
    assertFalse(cell.isAlive());
    cell.spawn();
    assertTrue(cell.isAlive());
  }

  @Test
  public void testKill() throws Exception {
    cell.spawn();
    assertTrue(cell.isAlive());
    cell.kill();
    assertFalse(cell.isAlive());
  }

  @Test
  public void testToString() throws Exception {
    cell.spawn();
    assertEquals(" @ ", cell.toString());
    cell.kill();
    assertEquals("   ", cell.toString());
  }

  @Test
  public void testGetCoordinate() throws Exception {
    assertEquals(coordinate, cell.getCoordinate());
  }

  @Test
  public void testEquality() throws Exception {
    assertEquals(cell, cell);
    assertNotEquals(cell, coordinate);
    Cell equalCell = new Cell(coordinate, false);
    assertEquals(cell, equalCell);
  }
}