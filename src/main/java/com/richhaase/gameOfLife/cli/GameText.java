package com.richhaase.gameOfLife.cli;

import com.richhaase.gameOfLife.core.Board;

/**
 * Created by rdh on 9/29/14.
 */
public class GameText implements Runnable {

  Board board;
  int redraw;

  public GameText(int height, int width, int redraw) {
    this.board = new Board(height, width);
    this.redraw = redraw;
  }

  public void run() {
    while (true) {
      System.out.println(board);
      board = board.nextGeneration();
      try {
        Thread.sleep(redraw * 1000);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

}
