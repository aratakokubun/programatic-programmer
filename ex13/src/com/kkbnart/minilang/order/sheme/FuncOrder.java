package com.kkbnart.minilang.order.sheme;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncOrder implements SchemeOrder {
  private final String attrType;
  private final String attrName;
}
