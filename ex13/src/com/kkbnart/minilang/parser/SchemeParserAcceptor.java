package com.kkbnart.minilang.parser;

import com.kkbnart.minilang.order.sheme.EndOrder;
import com.kkbnart.minilang.order.sheme.FuncOrder;
import com.kkbnart.minilang.order.sheme.MethodOrder;

public interface SchemeParserAcceptor<T> {
  void accept(final EndOrder order);

  void accept(final MethodOrder order);

  void accept(final FuncOrder order);
  
  T generate();
}
