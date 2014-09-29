package com.richhaase.gameOfLife.core;

/**
 * A cell in the game of life can either be alive or dead.
 * A dead cell can be spawned and a living cell can die.
 *
 * Created by rdh on 9/26/14.
 */
public class Cell {

  private boolean alive = false;
  private final Coordinate coordinate;

  /**
   * Constructor
   *
   * @param coordinate a <code>Coordinate</code> object
   * @param alive a boolean value of alive or dead (t or f)
   */
  public Cell(Coordinate coordinate, boolean alive) {
    this.coordinate = new Coordinate(coordinate.getX(), coordinate.getY());
    this.alive = alive;
  }

  /**
   * Constructor
   *
   * @param x     <code>Coordinate</code> x axis
   * @param y     <code>Coordinate</code> y axis
   * @param alive a boolean value of alive or dead (t or f)
   */
  public Cell(int x, int y, boolean alive) {
    this(new Coordinate(x, y), alive);
  }

  /**
   * gets the state of the cell, alive or dead
   *
   * @return a boolean
   */
  public boolean isAlive() {
    return alive;
  }

  /**
   * brings the cell to life regardless of its current state
   */
  public void spawn() {
    alive = true;
  }

  /**
   * kills the cell regardless of its current state
   */
  public void kill() {
    alive = false;
  }

  /**
   * get the coordinates of the cell
   *
   * @return a <code>Coordinate</code> object
   */
  public Coordinate getCoordinate() {
    return coordinate;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    if (! (that instanceof Cell)) return false;
    return this.hashCode() == that.hashCode();
  }

  @Override
  public int hashCode() {
    return coordinate.hashCode() * 17 + (isAlive() ? 1 : 0);
  }

  @Override
  public String toString() {
    return isAlive() ? " @ " : "   ";
  }

}
