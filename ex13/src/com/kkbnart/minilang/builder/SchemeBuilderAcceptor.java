package com.kkbnart.minilang.builder;

import com.kkbnart.minilang.order.sheme.EndOrder;
import com.kkbnart.minilang.order.sheme.FuncOrder;
import com.kkbnart.minilang.order.sheme.MethodOrder;
import com.kkbnart.minilang.parser.SchemeParserAcceptor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchemeBuilderAcceptor<T extends Scheme.Builder<?>> implements SchemeParserAcceptor<T> {

  private T builder;

  @Override
  public void accept(EndOrder endOrder) {
    builder.addEndOrder(endOrder);
  }

  @Override
  public void accept(MethodOrder methodOrder) {
    builder.addMethodOrder(methodOrder);
  }

  @Override
  public void accept(FuncOrder funcOrder) {
    builder.addFuncOrder(funcOrder);
  }

  @Override
  public T generate() {
    return builder;
  }
}
