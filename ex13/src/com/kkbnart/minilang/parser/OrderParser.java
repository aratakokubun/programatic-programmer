package com.kkbnart.minilang.parser;

import java.util.List;

import com.kkbnart.minilang.order.Order;

public interface OrderParser <T extends Order>{
  List<T> parse();
}
