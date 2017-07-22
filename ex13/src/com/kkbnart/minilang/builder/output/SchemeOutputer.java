package com.kkbnart.minilang.builder.output;

import com.kkbnart.minilang.builder.Scheme;
import com.kkbnart.minilang.exception.SchemeOutputException;

public interface SchemeOutputer {
  void output(final Scheme scheme) throws SchemeOutputException;
}
