package com.kkbnart.minilang.parser.scheme.responsible;

import com.kkbnart.minilang.exception.SchemeParserException;
import com.kkbnart.minilang.order.sheme.NullOrder;
import com.kkbnart.minilang.order.sheme.SchemeOrder;
import com.kkbnart.minilang.parser.SchemeParserAcceptor;

public abstract class SchemeOrderResponsible {
  private SchemeOrderResponsible next = null;
  
  private boolean hasNext() {
    return next != null;
  }
  
  public SchemeOrderResponsible setNext(final SchemeOrderResponsible next) {
    this.next = next;
    return next;
  }
  
  public SchemeOrder apply(final String orderLine) {
    try {
      if (this.isResponsible(orderLine)) {
        return this.parse(orderLine);
      } else if (this.hasNext()) {
        return this.next.apply(orderLine);
      } else {
        System.out.println(String.format("No match found : %s", orderLine));
      }
    } catch (SchemeParserException e) {
      System.out.println("Invalid parsing!");
    }
    return new NullOrder();
  }
  
  public void apply(final String orderLine, final SchemeParserAcceptor<?> acceptor) {
    try {
      if (this.isResponsible(orderLine)) {
        this.parse(orderLine, acceptor);
      } else if (this.hasNext()) {
        this.next.apply(orderLine, acceptor);
      } else {
        System.out.println(String.format("No match found : %s", orderLine));
      }
    } catch (SchemeParserException e) {
      System.out.println("Invalid parsing!");
    }
  }
  
  protected abstract boolean isResponsible(final String orderLine);

  protected abstract SchemeOrder parse(final String orderLine) throws SchemeParserException;

  protected abstract void parse(final String orderLine, final SchemeParserAcceptor<?> acceptor)
      throws SchemeParserException;
}