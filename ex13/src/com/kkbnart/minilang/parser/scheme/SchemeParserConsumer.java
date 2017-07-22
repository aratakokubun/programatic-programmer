package com.kkbnart.minilang.parser.scheme;

import java.util.function.Consumer;

import com.kkbnart.minilang.parser.SchemeParserAcceptor;
import com.kkbnart.minilang.parser.scheme.responsible.SchemeOrderResponsible;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SchemeParserConsumer implements Consumer<String> {
  private SchemeParserAcceptor<?> acceptor;
  private SchemeOrderResponsible responsible;

  @Override
  public void accept(String orderLine) {
    responsible.apply(orderLine, acceptor);
  }
  
  public SchemeParserAcceptor<?> getAcceptor() {
    return acceptor;
  }
}
