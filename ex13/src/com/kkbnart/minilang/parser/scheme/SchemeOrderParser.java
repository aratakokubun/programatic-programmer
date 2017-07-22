package com.kkbnart.minilang.parser.scheme;

import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SchemeOrderParser {
  private final SchemeParserConsumer consumer;
  private final List<String> orderLines = new ArrayList<>();
  
  public SchemeParserConsumer parse() {
    orderLines.stream().forEach(consumer);
    return consumer;
  }
  
  public void addOrder(String orderLine) {
    orderLines.add(orderLine);
  }

  public void addOrders(List<String> orderLines) {
    this.orderLines.addAll(orderLines);
  }
}
