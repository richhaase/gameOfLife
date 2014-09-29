package com.richhaase.gameOfLife;

import com.richhaase.gameOfLife.core.Board;
import com.richhaase.gameOfLife.ui.GameApplet;

/**
* Created by rdh on 9/26/14.
*/
public class GameRunner implements Runnable {

  private Board board;
  private int height, width,redraw;

  public GameRunner(int height, int width, int redraw) {
    this.height = height;
    this.width = width;
    this.redraw = redraw;
  }

  public void run() {
    new GameApplet(height, width, redraw).run();
  }

  public static void main(String[] args) {
    new GameRunner(41, 45, 2).run();
  }
}
