package com.kkbnart.minilang.order.sheme;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MethodOrder implements SchemeOrder {
  private final String methodName;
}
