package com.worldweatheronline.domain.entity;

/**
 * @user Kailash Dabhi (kailash09dabhi@gmail.com)
 * @date 19 Sep, 2017 23:56
 */

public class Constants {

  public static final String NEW_LINE = "\n";
  public static final String TAB = "  ";

  public static String newLineWithTab(int count) {
    String newLineTab = NEW_LINE;
    for (int i = 0; i < count; i++) {
      newLineTab = newLineTab + TAB;
    }
    return newLineTab;
  }
}
