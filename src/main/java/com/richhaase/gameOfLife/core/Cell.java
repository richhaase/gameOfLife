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
    this.coordinate = coordinate;
    this.alive = alive;
  }

  /**
   * Constructor
   *
   * @param coordinate a <code>Coordinate</code> object
   */
  public Cell(Coordinate coordinate) {
    this(coordinate, false);
  }

  /**
   *
   * @param height
   * @param width
   * @param alive
   */
  public Cell(int height, int width, boolean alive) {
    this.coordinate = new Coordinate(height, width);
    this.alive = alive;
  }

  /**
   * Constructor
   *
   * @param height cell coordinate height
   * @param width  cell coordinate width
   */
  public Cell(int height, int width) {
    this(new Coordinate(height, width), false);
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
    Cell thatCell = (Cell) that;
    return this.getCoordinate().equals(thatCell.getCoordinate()) && this.isAlive() == thatCell.isAlive();
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
