package com.richhaase.gameOfLife;

import com.richhaase.gameOfLife.cli.GameText;

/**
* Created by rdh on 9/26/14.
*/
public class GameRunner implements Runnable {

  private int height, width,redraw;

  public GameRunner(int height, int width, int redraw) {
    this.height = height;
    this.width = width;
    this.redraw = redraw;
  }

  public void run() {
    new GameText(height, width, redraw).run();
  }

  public static void main(String[] args) {
    new GameRunner(41, 45, 2).run();
  }
}
