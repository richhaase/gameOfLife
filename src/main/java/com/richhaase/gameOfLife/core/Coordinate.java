package com.richhaase.gameOfLife.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a two dimensional coordinate.
 *
 * Created by rdh on 9/26/14.
 */
public class Coordinate {

  private final int x, y;

  /**
   * Constructor
   *
   * @param x x-axis of coordinate
   * @param y y-axix of coordinate
   */
  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * get the x value of the coordinate
   *
   * @return the x-axis of the coordinate
   */
  int getX() {
    return x;
  }

  /**
   * get the y value of the coordinate
   *
   * @return the y-axis of the coordinate
   */
  int getY() {
    return y;
  }

  /**
   * gets a list of adjacent <code>Coordinate</code> objects
   *
   * @return list of <code>Coordinate</code>s
   */
  public List<Coordinate> getAdjacencies() {
    List<Coordinate> adjacencies = new ArrayList<>();

    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (!(i == x && j == y)) {
          adjacencies.add(new Coordinate(i, j));
        }
      }
    }

    return adjacencies;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    if (!(that instanceof Coordinate)) return false;
    return that.hashCode() == hashCode();
  }

  @Override
  public String toString() {
    return "( " + x + ", " + y + " )";
  }


  @Override
  public int hashCode() {
    int hash = 1;
    hash = hash * 17 + x;
    hash = hash * 31 + y;

    return hash;
  }
}