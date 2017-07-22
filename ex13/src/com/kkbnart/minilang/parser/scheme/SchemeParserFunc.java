package com.kkbnart.minilang.parser.scheme;

import java.util.function.Function;

import com.kkbnart.minilang.order.sheme.SchemeOrder;
import com.kkbnart.minilang.parser.scheme.responsible.SchemeOrderResponsible;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchemeParserFunc implements Function<String, SchemeOrder>{
  private SchemeOrderResponsible responsible;

  @Override
  public SchemeOrder apply(String orderLine) {
    return responsible.apply(orderLine);
  }
}
