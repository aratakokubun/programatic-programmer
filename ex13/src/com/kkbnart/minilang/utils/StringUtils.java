package com.kkbnart.minilang.utils;

import java.util.List;

public class StringUtils {
  public static final String BR = System.getProperty("line.separator");
  public static final String SPACE = " ";
  public static final String TAB = "    ";
  
  public static final StringBuffer strListToLinesBuffer(final List<String> strs) {
    final StringBuffer buffer = new StringBuffer();
    strs.stream()
        .forEach(
            line -> {
              buffer.append(line);
              buffer.append(StringUtils.BR);
            });
    return buffer;
  }
}
