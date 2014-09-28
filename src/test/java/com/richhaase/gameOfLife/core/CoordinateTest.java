package com.richhaase.gameOfLife.core;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class CoordinateTest {

  int x, y;
  Coordinate coordinate;

  @Before
  public void setup() throws Exception {
    x = 3;
    y = 5;
    coordinate = new Coordinate(x, y);
  }

  @Test
  public void testGetX() throws Exception {
    assertEquals(x, coordinate.getX());
  }

  @Test
  public void testGetY() throws Exception {
    assertEquals(y, coordinate.getY());
  }

  @Test
  public void testGetAdjacencies() throws Exception {
    List<Coordinate> expected = new ArrayList<>();

    expected.add(new Coordinate(x - 1, y - 1));
    expected.add(new Coordinate(x - 1, y));
    expected.add(new Coordinate(x - 1, y + 1));
    expected.add(new Coordinate(x, y-1));
    expected.add(new Coordinate(x, y + 1));
    expected.add(new Coordinate(x + 1, y - 1));
    expected.add(new Coordinate(x + 1, y));
    expected.add(new Coordinate(x + 1, y + 1));

    assertEquals(expected, coordinate.getAdjacencies());
  }

  @Test
  public void testToString() throws Exception {
    String expected = "( " + x + ", " + y + " )";
    assertEquals(expected, coordinate.toString());
  }

  @Test
  public void testEquality() throws Exception {
    assertEquals(coordinate, coordinate);
    assertEquals(new Coordinate(3, 5), coordinate);
    assertNotEquals(new Cell(coordinate, false), coordinate);
  }

  @Test
  public void testCoordinateAsHashKey() throws Exception {
    Map<Coordinate, String> coordinateKeyedMap = new HashMap<>();

    coordinateKeyedMap.put(coordinate, coordinate.toString());
    assertTrue(coordinateKeyedMap.containsKey(new Coordinate(3, 5)));
  }

}