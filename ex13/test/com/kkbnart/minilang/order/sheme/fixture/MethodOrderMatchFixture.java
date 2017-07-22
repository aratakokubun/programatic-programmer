package com.kkbnart.minilang.order.sheme.fixture;

import lombok.Data;

@Data
public class MethodOrderMatchFixture {
  private final String orderLine;
  private final boolean isMatch;
}
