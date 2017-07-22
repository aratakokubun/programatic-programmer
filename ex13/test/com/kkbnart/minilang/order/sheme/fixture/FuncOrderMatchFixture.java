package com.kkbnart.minilang.order.sheme.fixture;

import lombok.Data;

@Data
public class FuncOrderMatchFixture {
  private final String orderLine;
  private final boolean isMatch;
}
